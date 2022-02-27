package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.pushyapp.GameController;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.LevelPool;
import com.example.pushyapp.R;

/**
 * Ermöglich das Spielen eines Levels
 * @Author Dirk Dresselhaus
 */


public class GamefieldActivity extends AppCompatActivity
{
    private GameController controller;

    /**
     * Setz das in den Extras hinterlegte Level als Titel in der Actionbar und
     * initialisiert mit diesem zusammen mit der Activitey den GameController
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Übergebene Level-ID ermitteln
        Bundle extras = getIntent().getExtras();
        Level level = LevelPool.getLevel(extras.getInt("id"));
        getSupportActionBar().setTitle("Level " + (level.getId() + 1));

        // Spiel mit Level starten
        this.controller = new GameController(this, level);
    }

    /**
     * Setz  das übergebene Menü als Actionbar
     * @param menu wird als Actionbar verwendet
     * @source https://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gamefield, menu);
        return true;
    }

    /**
     * Erfasst welches Item in der Actionbar engeclickt wurde und ruft dem entsprechend eine Methode auf
     * @param item ist das angeclickte Item
     * @source https://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.reset:
                this.controller.restart();
                return true;

            case R.id.close:
                this.controller.cancel();
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
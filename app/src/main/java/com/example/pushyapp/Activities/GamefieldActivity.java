package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.pushyapp.Models.GameController;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.Models.LevelPool;
import com.example.pushyapp.R;



public class GamefieldActivity extends AppCompatActivity
{
    private GameController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Übergebene Level-ID ermitteln
        Bundle extras = getIntent().getExtras();
        Level level = LevelPool.getLevel(extras.getInt("id"));

        // Spiel mit Level starten
        this.controller = new GameController(this, level);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gamefield, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.reset:
                this.controller.restart();
                return true;

            case R.id.close:
                this.controller.cancel();
                Intent intent2 = new Intent(this, LevelSelectionActivity.class);
                startActivity(intent2);
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
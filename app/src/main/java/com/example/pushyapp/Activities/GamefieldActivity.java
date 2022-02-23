package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.pushyapp.Models.GameController;

import com.example.pushyapp.Models.GameElements.GameElement;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.Presenter;
import com.example.pushyapp.R;
import com.example.pushyapp.Services.OnSwipeTouchListener;

import java.util.ArrayList;


public class GamefieldActivity extends AppCompatActivity {

    private GameController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // TODO: Id aus Intent holen
        Level level = new Level(0, 0);
        this.controller = new GameController(this, level);

        //tests
        //ArrayList<GameElement> testElements = new ArrayList<GameElement>();
        //Presenter p = new Presenter(this, testElements, 15, 10);
        //p.drawEmptyGamefield();




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
                // To do: reset level funktion
                this.controller.restart();

                return true;

            case R.id.close:
                Intent intent2 = new Intent(this, LevelSelectionActivity.class);
                startActivity(intent2);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
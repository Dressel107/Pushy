package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.Gamefield;
import com.example.pushyapp.R;

public class LevelOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_activity);

        GameElement[][] gameElement = new GameElement[1][1];
        Gamefield gamefield = new Gamefield(this, gameElement);


    }
}
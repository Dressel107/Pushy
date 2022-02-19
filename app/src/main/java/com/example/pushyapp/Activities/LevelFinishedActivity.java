package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pushyapp.R;
import com.example.pushyapp.Services.AppDatabaseHandler;

public class LevelFinishedActivity extends AppCompatActivity  {
    Button btnSelectLevel;
    Button btnNextLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_finished);
        getSupportActionBar().hide();
        btnSelectLevel = findViewById(R.id.btn_select_level);
        btnNextLevel = findViewById(R.id.btn_next_level);

        btnSelectLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelFinishedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelFinishedActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
package com.example.pushyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level_finished extends AppCompatActivity  {
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
                Intent intent = new Intent(Level_finished.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level_finished.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
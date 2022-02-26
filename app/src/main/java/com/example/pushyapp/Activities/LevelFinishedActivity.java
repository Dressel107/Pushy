package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.Models.LevelPool;
import com.example.pushyapp.R;
import com.example.pushyapp.Services.AppDatabaseHandler;

public class LevelFinishedActivity extends AppCompatActivity  {
    Button btnSelectLevel;
    Button btnNextLevel;

    TextView time;
    TextView NumberOfAttemps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_finished);
        getSupportActionBar().hide();

        Bundle extras = getIntent().getExtras();
        int triesCount = extras.getInt("triesCount");
        long durationInSeconds = extras.getLong("duration");
        int nextLevelID = extras.getInt("nextLevel");

        this.btnSelectLevel = findViewById(R.id.btn_select_level);
        this.btnNextLevel = findViewById(R.id.btn_next_level);

        this.time = findViewById(R.id.tv_time);
        this.NumberOfAttemps = findViewById(R.id.tv_number_attemps);

        this.time.setText( getResources().getString(R.string.time) + " " + durationInSeconds + " " + getResources().getString(R.string.seconds));
        this.NumberOfAttemps.setText( getResources().getString(R.string.number_of_attemps) + " " + triesCount);



        btnSelectLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelFinishedActivity.this, LevelSelectionActivity.class);
                startActivity(intent);
            }
        });

        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nextLevelID >= LevelPool.getAll().size()){
                    Intent intent = new Intent(LevelFinishedActivity.this, LevelSelectionActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(LevelFinishedActivity.this, GamefieldActivity.class);
                    intent.putExtra("id", nextLevelID);
                    startActivity(intent);
                }
            }
        });
    }
}
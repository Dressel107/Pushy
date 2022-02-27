package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pushyapp.Helpers.TimeHelper;
import com.example.pushyapp.LevelPool;
import com.example.pushyapp.R;

/**
 * Stellt die Anwednungslogik für den erfolgreichen Abschluss eiens Levels bereit
 * @Author Dirk Dresselhaus
 */
public class LevelFinishedActivity extends AppCompatActivity  {
    Button btnSelectLevel;
    Button btnNextLevel;

    TextView time;
    TextView NumberOfAttemps;

    /**
     * Initaliesert sämtliche View der Activity und zeigt Statistiken zum abgeschlossen Level an
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_finished);
        getSupportActionBar().hide();

        //Level-Statistiken aus extras holen
        Bundle extras = getIntent().getExtras();
        int triesCount = extras.getInt("triesCount");
        long durationInSeconds = extras.getLong("duration");
        int nextLevelID = extras.getInt("nextLevel");

        //View setzten
        this.btnSelectLevel = findViewById(R.id.btn_select_level);
        this.btnNextLevel = findViewById(R.id.btn_next_level);

        this.time = findViewById(R.id.tv_time);
        this.NumberOfAttemps = findViewById(R.id.tv_number_attemps);

        this.time.setText( getResources().getString(R.string.time) + " " + TimeHelper.getDurationText(this, durationInSeconds));
        this.NumberOfAttemps.setText( getResources().getString(R.string.number_of_attemps) + " " + triesCount);

        //onClickListener für Buttons implementieren
        btnSelectLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nextLevelID >= LevelPool.getAll().size()){
                    finish();
                }else{
                    Intent intent = new Intent(LevelFinishedActivity.this, GamefieldActivity.class);
                    intent.putExtra("id", nextLevelID);
                    startActivity(intent);
                }
            }
        });
    }
}
package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pushyapp.R;
import com.example.pushyapp.Services.AppDatabase;
import com.example.pushyapp.Services.AppDatabaseHandler;
import com.example.pushyapp.Services.LevelDao;

public class Splashscreen extends AppCompatActivity {

    private static final String APP_DATABASE_NAME = "app_database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        // App-Datenbank laden und global setzen, damit alle Komponenten der App darauf zugreifen können
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, APP_DATABASE_NAME).build();
        AppDatabaseHandler.setAppDatabase(db);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashscreen.this, LevelSelectionActivity.class);
                startActivity(intent);
                //finish();
            }
        },0);
    }
}
package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pushyapp.ListAdapters.LevelListItemAdapter;
import com.example.pushyapp.Models.Level;
import com.example.pushyapp.R;
import com.example.pushyapp.Services.AppDatabase;
import com.example.pushyapp.Services.AppDatabaseHandler;
import com.example.pushyapp.Services.LevelDao;

import java.util.ArrayList;

public class LevelSelectionActivity extends AppCompatActivity
{
    ListView list;
    Level[] levels = new Level[3];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        Level level1 = new Level(0, 54);
        Level level2 = new Level(1, 77);
        Level level3 = new Level(2, 36);

        levels[0] = level1;
        levels[1] = level2;
        levels[2] = level3;

        LevelListItemAdapter adapter = new LevelListItemAdapter(this, levels);
        list=(ListView)findViewById(R.id.level_selection_listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                System.out.println("Level " + position + " ausgewählt.");

                Thread t1 = new Thread(new Runnable()
                {
                    public void run()
                    {
                        int duration = AppDatabaseHandler.getCurrentLevelDuration(position);
                        System.out.println("Dauer in Sekunden: " + duration);
                    }});
                t1.start();
            }
        });
    }
}
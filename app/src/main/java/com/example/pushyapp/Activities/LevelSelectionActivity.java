package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pushyapp.ListAdapters.LevelListItemAdapter;
import com.example.pushyapp.Models.Level;
import com.example.pushyapp.R;

import java.util.ArrayList;

public class LevelSelectionActivity extends AppCompatActivity
{
    ListView list;
    ArrayList<Level> levels = new ArrayList<Level>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        Level level1 = new Level(0, 54);
        //Level level2 = new Level(2, 77);
        //Level level3 = new Level(3, 36);

        levels.add(level1);
        //levels.add(level2);
        //levels.add(level3);


        LevelListItemAdapter adapter = new LevelListItemAdapter(this, levels);

        list=(ListView)findViewById(R.id.level_selection_listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                System.out.println("Level " + position + " ausgewählt.");
                switch (position){
                    case 0:
                        Intent intent = new Intent(LevelSelectionActivity.this, GamefieldActivity.class);
                        startActivity(intent);
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_level_selection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.language:
                // To do: reset level funktion
                System.out.println("sprach");

                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
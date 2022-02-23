package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pushyapp.ListAdapters.LevelListItemAdapter;
import com.example.pushyapp.Models.Level;
import com.example.pushyapp.Models.LevelPool;
import com.example.pushyapp.R;
import com.example.pushyapp.Services.LocaleHelper;

import java.util.ArrayList;

public class LevelSelectionActivity extends AppCompatActivity
{
    private ListView list;
    Context context;
    Resources resources;
    TextView levelSecound;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        levelSecound = findViewById(R.id.level_needed_time);

        LevelListItemAdapter adapter = new LevelListItemAdapter(this, LevelPool.getAll());
        list=(ListView)findViewById(R.id.level_selection_listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent intent = new Intent(LevelSelectionActivity.this, GamefieldActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
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

            case R.id.german:
                context = LocaleHelper.setLocale(LevelSelectionActivity.this, "en");
                resources = context.getResources();
                levelSecound.setText(resources.getString(R.string.secounds));
                System.out.println("german");
            case R.id.english:
                context = LocaleHelper.setLocale(LevelSelectionActivity.this, "de");
                resources = context.getResources();
                levelSecound.setText(resources.getString(R.string.secounds));
                System.out.println("english");

                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
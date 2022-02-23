package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
import java.util.Locale;

public class LevelSelectionActivity extends AppCompatActivity
{
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);



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
                Locale locale = new Locale("de");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                //Toast.makeText(this, "Locale in English !", Toast.LENGTH_LONG).show();


            case R.id.english:
                Locale locale2 = new Locale("en");
                Locale.setDefault(locale2);
                Configuration config2 = new Configuration();
                config2.locale = locale2;
                getBaseContext().getResources().updateConfiguration(config2, getBaseContext().getResources().getDisplayMetrics());
                //Toast.makeText(this, "Locale in Portugal !", Toast.LENGTH_LONG).show();

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LevelSelectionActivity.class);
        finish();
        startActivity(refresh);
    }


}
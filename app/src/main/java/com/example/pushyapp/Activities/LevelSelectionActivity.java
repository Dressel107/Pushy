package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.pushyapp.Others.LevelListItemAdapter;
import com.example.pushyapp.LevelPool;
import com.example.pushyapp.R;
import com.example.pushyapp.Services.LocalDatabase.AppDatabase;
import com.example.pushyapp.Services.LocalDatabase.AppDatabaseHandler;

/**
 * Stellt die Anwendungslogik für das Auswählen eines Levels bereit.
 * @author Simon Schnitker
 */
public class LevelSelectionActivity extends AppCompatActivity
{
    private static final String APP_DATABASE_NAME = "app_database";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Lokale Datenbank laden
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, APP_DATABASE_NAME).build();
        AppDatabaseHandler.setAppDatabase(db);

        // Theme wechseln
        setTheme(R.style.Theme_PushyApp);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        getSupportActionBar().setTitle("Pushy");
        getSupportActionBar().setSubtitle(getResources().getString(R.string.level_selection));

        // Adapter für ListView erstellen
        LevelListItemAdapter adapter = new LevelListItemAdapter(this, LevelPool.getAll());
        ListView list = (ListView) findViewById(R.id.level_selection_listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent intent = new Intent(LevelSelectionActivity.this, GamefieldActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}
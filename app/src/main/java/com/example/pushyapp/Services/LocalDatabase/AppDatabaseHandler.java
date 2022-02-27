package com.example.pushyapp.Services.LocalDatabase;

import com.example.pushyapp.LevelPool;

public final class AppDatabaseHandler
{
    private static AppDatabase database;

    public static void setAppDatabase(AppDatabase db)
    {
        database = db;

        // Tabelle erstellen, falls noch nicht vorhanden
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                database.levelDao().buildTable((LevelPool.getAll()));
            }});
        thread.start();
    }

    public static long getCurrentLevelDuration(int id)
    {
        return database.levelDao().getCurrentLevelDuration(id);
    }

    public static void updateLevelProgress(int id, long duration)
    {
        database.levelDao().updateProgress(id, duration);
    }

    public static void clearFullLevelProgress()
    {
        database.levelDao().clear();
    }
}
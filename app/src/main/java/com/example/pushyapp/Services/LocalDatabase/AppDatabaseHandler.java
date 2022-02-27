package com.example.pushyapp.Services.LocalDatabase;

import com.example.pushyapp.LevelPool;

/**
 * Stellt einen globalen Zugriffspunkt auf die lokale Datenbank zur Verfügung.
 * @author Simon Schnitker
 */
public final class AppDatabaseHandler
{
    /**
     * Gibt die lokale Datenbank an.
     * @author Simon Schnitker
     */
    private static AppDatabase database;

    /**
     * Setzt die lokale Datenbank für den globalen Zugriff.
     * Diese sollte beim Start der App aufgerufen werden.
     * @param db Die Datenbank.
     * @author Simon Schnitker
     */
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

    /**
     * Ermittelt die benötigte Dauer des Spieler für das Lösen eines Levels.
     * @param id Die ID des Levels.
     * @return Gibt die Dauer in Sekunden zurück.
     * @author Simon Schnitker
     */
    public static long getCurrentLevelDuration(int id)
    {
        return database.levelDao().getCurrentLevelDuration(id);
    }

    /**
     * Aktualisiert die benötigte Dauer für das Lösen eines Levels.
     * @param id Die ID des Levels.
     * @param duration Die benötigte Dauer in Sekunden.
     * @author Simon Schnitker
     */
    public static void updateLevelProgress(int id, long duration)
    {
        database.levelDao().updateProgress(id, duration);
    }

    /**
     * Löscht den gesamten Fortschritt aller Level.
     * @author Simon Schnitker
     */
    public static void clearFullLevelProgress()
    {
        database.levelDao().clear();
    }
}
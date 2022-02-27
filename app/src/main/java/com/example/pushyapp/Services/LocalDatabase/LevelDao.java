package com.example.pushyapp.Services.LocalDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pushyapp.Models.Level;

import java.util.ArrayList;

/**
 * Beschreibt den Aufbau des Datenzugriffobjekts für Level.
 * @author Simon Schnitker
 */
@Dao
public interface LevelDao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void buildTable(ArrayList<Level> levels);

    @Query("SELECT duration FROM Level WHERE id = :id;")
    long getCurrentLevelDuration(int id);

    @Query("UPDATE Level SET duration = :duration WHERE id = :id;")
    void updateProgress(int id, long duration);

    @Query("DELETE FROM Level;")
    void clear();
}
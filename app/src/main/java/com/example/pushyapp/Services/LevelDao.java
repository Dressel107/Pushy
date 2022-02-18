package com.example.pushyapp.Services;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pushyapp.Models.Level;

@Dao
public interface LevelDao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void buildTable(Level[] levels);

    @Query("SELECT duration FROM Level WHERE id = :id;")
    int getCurrentLevelDuration(int id);

    @Query("UPDATE Level SET duration = :duration WHERE id = :id;")
    void updateProgress(int id, int duration);

    @Query("DELETE FROM Level;")
    void clear();
}
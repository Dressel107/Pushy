package com.example.pushyapp.Services;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.pushyapp.Models.Level;

// Quelle mit Erklärung für Room: https://developer.android.com/training/data-storage/room#java

@Database(entities = {Level.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract LevelDao levelDao();
}
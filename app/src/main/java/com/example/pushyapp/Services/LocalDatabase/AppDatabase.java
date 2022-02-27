package com.example.pushyapp.Services.LocalDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.pushyapp.Models.Level;

@Database(entities = {Level.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract LevelDao levelDao();
}
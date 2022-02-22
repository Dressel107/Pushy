package com.example.pushyapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Models.GameElements.Wall;

import java.util.ArrayList;

@Entity
public class Level
{
    // Gibt die ID des Levels an.
    @PrimaryKey
    private int id;

    // Gibt an, wie viele Sekunden der Spieler für das Lösen des Levels benötigt hat.
    @ColumnInfo(name = "duration")
    private int durationInSeconds;

    // Gibt an, ob der Spieler das Level geschafft hat.
    @Ignore
    private boolean hasFinished;

    @Ignore
    private ArrayList<GameElement> elements;

    public Level(int id, int durationInSeconds)
    {
        this.id = id;
        this.durationInSeconds = durationInSeconds;

        if (durationInSeconds > 0)
        {
            hasFinished = true;
        }
        else
        {
            hasFinished = false;
        }

        elements = LevelPool.levels.get(id);
    }

    public int getId() {
        return id;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public ArrayList<GameElement> getElements() {
        return elements;
    }
}

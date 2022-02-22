package com.example.pushyapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
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
    private boolean hasFinished;

    private ArrayList<GameElement> elements;
    private int playerXPosition;
    private int playerYPosition;

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
        playerXPosition = 5;
        playerYPosition = 5;
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

    public int getPlayerXPosition() {
        return playerXPosition;
    }

    public int getPlayerYPosition() {
        return playerYPosition;
    }
}

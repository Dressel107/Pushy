package com.example.pushyapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Services.AppDatabaseHandler;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Level
{
    // Gibt die ID des Levels an.
    @PrimaryKey
    private int id;

    // Gibt an, wie viele Sekunden der Spieler für das Lösen des Levels benötigt hat.
    @ColumnInfo(name = "duration")
    private long durationInSeconds;

    // Gibt die dynamischen Elemente des Levels an oder legt sie fest.
    @Ignore
    private ArrayList<GameElement> elements;

    @Ignore
    private int horizontalFieldCount;

    @Ignore
    private int verticalFieldCount;

    public Level (int id){
        this.id = id;
    }

    public Level(int id, int horizontalFieldCount, int verticalFieldCount)
    {
        this.id = id;
        this.elements = new ArrayList<>();
        this.horizontalFieldCount = horizontalFieldCount;
        this.verticalFieldCount = verticalFieldCount;
        this.addBorders();
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                durationInSeconds = AppDatabaseHandler.getCurrentLevelDuration(id);
            }});
        thread.start();
    }

    public Level(int id, ArrayList<GameElement> elements, int horizontalFieldCount, int verticalFieldCount)
    {
        this(id, horizontalFieldCount, verticalFieldCount);

        for (GameElement element: elements)
        {
            this.elements.add(element);
        }
    }

    private void addBorders()
    {
        for (int i = 0; i < horizontalFieldCount; i++)
        {
            for (int j = 0; j < verticalFieldCount; j++)
            {
                if (i == 0 || i == horizontalFieldCount - 1 || j == 0 || j == verticalFieldCount - 1)
                {
                   elements.add(new Wall(i, j));
                }
            }
        }
    }

    public int getId()
    {
        return id;
    }

    public void setDurationInSeconds(long durationInSeconds)
    {
        this.durationInSeconds = durationInSeconds;
    }

    public long getDurationInSeconds()
    {
        return durationInSeconds;
    }

    public ArrayList<GameElement> getElements()
    {
        return elements;
    }

    public void updateProgress(long duration)
    {
        if (this.durationInSeconds > 0 && duration > this.durationInSeconds)
        {
            return;
        }

        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                AppDatabaseHandler.updateLevelProgress(id, duration);
            }});
        thread.start();

        this.durationInSeconds = duration;
    }

    public void setHorizontalFieldCount(int horizontalFieldCount) {
        this.horizontalFieldCount = horizontalFieldCount;
    }

    public void setVerticalFieldCount(int verticalFieldCount) {
        this.verticalFieldCount = verticalFieldCount;
    }

    public int getHorizontalFieldCount() {
        return horizontalFieldCount;
    }

    public int getVerticalFieldCount() {
        return verticalFieldCount;
    }


}

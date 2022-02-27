package com.example.pushyapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Services.LocalDatabase.AppDatabaseHandler;

import java.util.ArrayList;

/**
 * Definiert den Aufbau eines Levels.
 * @author Simon Schnitker, Dirk Dresselhaus
 */
@Entity
public class Level
{
    /**
     * Gibt die ID des Levels an.
     * @author Simon Schnitker
     */
    @PrimaryKey
    private int id;

    /**
     * Gibt an, wie viele Sekunden der Spieler für das Lösen des Levels benötigt hat.
     * @author Simon Schnitker
     */
    @ColumnInfo(name = "duration")
    private long durationInSeconds;

    /**
     * Gibt die dynamischen Elemente des Levels an oder legt sie fest.
     * @author Simon Schnitker
     */
    @Ignore
    private ArrayList<GameElement> elements;

    /**
     * Gibt an, wie viele Felder das Level horizontal besitzt.
     * @author Simon Schnitker
     */
    @Ignore
    private int horizontalFieldCount;

    /**
     * Gibt an, wie viele Felder das Level vertikal besitzt.
     * @author Simon Schnitker
     */
    @Ignore
    private int verticalFieldCount;

    // Wird leider benötigt für Room.
    public Level()
    {

    }

    public Level(int id, ArrayList<GameElement> elements, int horizontalFieldCount, int verticalFieldCount)
    {
        this.id = id;
        this.elements = new ArrayList<>();
        this.horizontalFieldCount = horizontalFieldCount;
        this.verticalFieldCount = verticalFieldCount;
        this.elements = elements;

        this.addBorders();
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                durationInSeconds = AppDatabaseHandler.getCurrentLevelDuration(id);
            }});
        thread.start();
    }

    /**
     * Fügt dem Level Objekte vom Typ "Wall" hinzu, sodass es außenrum eine Grenze besitzt.
     * @author Dirk Dresselhaus
     */
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

    /**
     * Aktualisiert die benötigte Dauer des Levels, sollte die übergebene Zeit besser sein.
     * @author Simon Schnitker
     * @param duration Die Dauer in Sekunden.
     */
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

    public int getId()
    {
        return id;
    }

    public long getDurationInSeconds()
    {
        return durationInSeconds;
    }

    public ArrayList<GameElement> getElements()
    {
        return elements;
    }

    public int getHorizontalFieldCount()
    {
        return horizontalFieldCount;
    }

    public int getVerticalFieldCount()
    {
        return verticalFieldCount;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setDurationInSeconds(long durationInSeconds)
    {
        this.durationInSeconds = durationInSeconds;
    }
}

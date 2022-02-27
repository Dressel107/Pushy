package com.example.pushyapp;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.Models.GameElements.ColorArea;
import com.example.pushyapp.Models.GameElements.ColorSphere;
import com.example.pushyapp.Models.GameElements.ColorSplash;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Gate;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Key;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Models.GameElements.Switch;
import com.example.pushyapp.Models.GameElements.SwitchGate;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.GameElements.WoodenBox;
import com.example.pushyapp.Models.Level;

import java.util.ArrayList;

/**
 * Stellt eine Sammlung von Leveln bereit und initialisiert diese.
 * @author Dirk Dresselhaus, Simon Schnitker
 */
public class LevelPool
{
    /**
     * Gibt eine Liste von Leveln an.
     * @author Simon Schnitker
     */
    private static ArrayList<Level> levels;

    /**
     * Initialisiert die einzelnen Level und fügt sie der ArrayList "levels" hinzu.
     * @author Simon Schnitker, Dirk Dresselhaus
     */
    static
    {
        levels = new ArrayList<Level>();

        // Level 1
        ArrayList<GameElement> level1Elements = new ArrayList<>();
        level1Elements.add(new Wall(5, 1));
        level1Elements.add(new Wall(5, 2));
        level1Elements.add(new Wall(4, 2));
        level1Elements.add(new Wall(1, 6));
        level1Elements.add(new Wall(2, 6));
        level1Elements.add(new Wall(3, 6));
        level1Elements.add(new Wall(4, 6));
        level1Elements.add(new Wall(5, 6));
        level1Elements.add(new Wall(6, 6));
        level1Elements.add(new Wall(5, 5));
        level1Elements.add(new Wall(8, 5));
        level1Elements.add(new Wall(6, 7));
        level1Elements.add(new Wall(6, 8));
        level1Elements.add(new Wall(6, 9));
        level1Elements.add(new Wall(7, 11));
        level1Elements.add(new Wall(8, 11));
        level1Elements.add(new Wall(5, 9));
        level1Elements.add(new Wall(3, 10));
        level1Elements.add(new Wall(4, 10));
        level1Elements.add(new Wall(2, 9));
        level1Elements.add(new Wall(3, 8));
        level1Elements.add(new WoodenBox(5, 3));
        level1Elements.add(new WoodenBox(5, 4));
        level1Elements.add(new WoodenBox(6, 4));
        level1Elements.add(new WoodenBox(7, 4));
        level1Elements.add(new WoodenBox(7, 10));
        level1Elements.add(new WoodenBox(5, 11));
        level1Elements.add(new WoodenBox(1, 9));
        level1Elements.add(new WoodenBox(3, 7));
        level1Elements.add(new Goal(3, 9));
        level1Elements.add(new Player(2, 3));
        levels.add(new Level(0, level1Elements, 10, 13));

        // Level 2
        ArrayList<GameElement> level2Elements = new ArrayList<>();
        level2Elements.add(new Wall(2,11));
        level2Elements.add(new Wall(3,11));
        level2Elements.add(new Wall(4,11));
        level2Elements.add(new Wall(5,11));
        level2Elements.add(new Wall(6,11));
        level2Elements.add(new Wall(7,11));
        level2Elements.add(new Wall(8,11));
        level2Elements.add(new Wall(5,1));
        level2Elements.add(new Wall(5,2));
        level2Elements.add(new Wall(5,3));
        level2Elements.add(new Wall(5,4));
        level2Elements.add(new Wall(6,1));
        level2Elements.add(new Wall(7,1));
        level2Elements.add(new Wall(5,5));
        level2Elements.add(new Wall(5,9));
        level2Elements.add(new Wall(6,9));
        level2Elements.add(new Wall(7,9));
        level2Elements.add(new Wall(8,9));
        level2Elements.add(new Wall(4,2));
        level2Elements.add(new Wall(3,2));
        level2Elements.add(new Wall(2,2));
        level2Elements.add(new WoodenBox(3,10));
        level2Elements.add(new WoodenBox(2, 13));
        level2Elements.add(new WoodenBox(8,3));
        level2Elements.add(new WoodenBox(6,3));
        level2Elements.add(new Key(8,10));
        level2Elements.add(new Gate(1,2));
        level2Elements.add(new ColorSphere(7,3, Color.Red));
        level2Elements.add(new ColorSphere(7,12, Color.Blue));
        level2Elements.add(new ColorSplash(4,5, Color.Blue));
        level2Elements.add(new ColorArea(1,9, Color.Blue));
        level2Elements.add(new Goal(4,1));
        level2Elements.add(new Player(3,13));
        levels.add(new Level(1, level2Elements, 10, 15));

        // Level 3
        ArrayList<GameElement> level3Elements = new ArrayList<>();
    }

    /**
     * Gibt ein Level zurück.
     * @param index Der Index, bzw. die ID des Levels.
     * @author Simon Schnitker
     */
    public static Level getLevel(int index)
    {
        return levels.get(index);
    }

    /**
     * Gibt alle Level zurück.
     * @author Simon Schnitker
     */
    public static ArrayList<Level> getAll()
    {
        return levels;
    }
}

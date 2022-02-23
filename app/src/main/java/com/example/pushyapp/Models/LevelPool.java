package com.example.pushyapp.Models;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.Models.GameElements.ColorArea;
import com.example.pushyapp.Models.GameElements.ColorSphere;
import com.example.pushyapp.Models.GameElements.ColorSplash;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Gate;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Key;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.GameElements.WoodenBox;

import java.util.ArrayList;

public class LevelPool
{
    private static ArrayList<Level> levels;

    static
    {
        levels = new ArrayList<Level>();

        // Level 1
        ArrayList<GameElement> level1Elements = new ArrayList<>();
        level1Elements.add(new WoodenBox(4, 5));
        level1Elements.add(new WoodenBox(5, 5));
        level1Elements.add(new WoodenBox(6, 5));
        level1Elements.add(new Key(2,3));
        level1Elements.add(new Goal(7,3));
        level1Elements.add(new Player(7,7));
        level1Elements.add(new Gate(1,2));
        level1Elements.add(new ColorSphere(6,10, Color.Blue));
        level1Elements.add(new ColorSplash(7,8, Color.Red));
        level1Elements.add(new ColorArea(7,11, Color.Red));
        levels.add(new Level(0, level1Elements));

        // Level 2
        ArrayList<GameElement> level2Elements = new ArrayList<>();

        level2Elements.add(new Goal(4,1));

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

        level2Elements.add(new Key(8,10));
        level2Elements.add(new Gate(1,2));

        level2Elements.add(new WoodenBox(3,10));
        level2Elements.add(new WoodenBox(2, 13));
        level2Elements.add(new WoodenBox(8,3));
        level2Elements.add(new WoodenBox(6,3));

        level2Elements.add(new ColorSphere(7,3, Color.Red));
        level2Elements.add(new ColorSplash(4,5, Color.Blue));
        level2Elements.add(new ColorSphere(7,12, Color.Blue));
        level2Elements.add(new ColorArea(1,9, Color.Blue));

        level2Elements.add(new Player(3,13));
        levels.add(new Level(1, level2Elements));
    }

    public static Level getLevel(int index)
    {
        return levels.get(index);
    }

    public static ArrayList<Level> getAll()
    {
        return levels;
    }
}

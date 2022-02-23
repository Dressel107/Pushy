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

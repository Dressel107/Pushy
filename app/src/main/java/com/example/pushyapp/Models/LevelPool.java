package com.example.pushyapp.Models;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.WoodenBox;

import java.util.ArrayList;

public class LevelPool
{
    public static ArrayList<ArrayList<GameElement>> levels;

    static
    {
        levels = new ArrayList<ArrayList<GameElement>>();

        // Level 1
        ArrayList<GameElement> level1 = new ArrayList<>();
        level1.add(new WoodenBox(5, 5));
        level1.add(new WoodenBox(5, 5));
        level1.add(new WoodenBox(5, 5));

        levels.add(level1);
    }
}

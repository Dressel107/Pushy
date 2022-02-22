package com.example.pushyapp.Models;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Key;
import com.example.pushyapp.Models.GameElements.Player;
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
        level1.add(new WoodenBox(4, 5));
        level1.add(new WoodenBox(5, 5));
        level1.add(new WoodenBox(6, 5));
        level1.add(new Key(2,2));
        level1.add(new Goal(7,2));
        level1.add(new Player(7,7));

        levels.add(level1);
    }
}

package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Wall extends GameElement implements Solid
{
    private static final int res = R.drawable.wall;

    public Wall(int x, int y)
    {
        super(x, y, res);
    }

    public Wall(int x, int y, float size)
    {
        super(x, y, size, res);
    }
}
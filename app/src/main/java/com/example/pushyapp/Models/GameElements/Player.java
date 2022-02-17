package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;

public class Player extends GameElement implements Movable, Accessible
{
    private static final String BITMAP_SOURCE = "Pushy.png";
    private Direction lookDirection;
    private int keysCount;

    public Player()
    {
        super(BITMAP_SOURCE);
    }

    public void collectKey()
    {
        this.keysCount++;
    }

    public boolean useKey()
    {
        if (keysCount > 0)
        {
            keysCount--;
            return true;
        }

        return false;
    }
}

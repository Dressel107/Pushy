package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

public class Player extends GameElement implements Movable, Accessible
{
    private static final int res = R.drawable.player;
    private Direction lookDirection;
    private int keysCount;

    public Player()
    {
        super(res);
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

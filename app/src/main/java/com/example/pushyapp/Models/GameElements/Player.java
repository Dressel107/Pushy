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

    public Player(int x, int y){
        super(x,y,res);
    }

    public void collectKey()
    {
        this.keysCount++;
    }

    public boolean tryUsingKey()
    {
        if (keysCount > 0)
        {
            keysCount--;
            return true;
        }

        return false;
    }

    @Override
    public void move(Direction direction)
    {
        switch (direction)
        {
            case Left:
                x--;
                lookDirection = Direction.Left;
                break;
            case Right:
                x++;
                lookDirection = Direction.Right;
                break;
            case Up:
                y--;
                lookDirection = Direction.Up;
                break;
            case Down:
                y++;
                lookDirection = Direction.Down;
                break;
        }
    }
}

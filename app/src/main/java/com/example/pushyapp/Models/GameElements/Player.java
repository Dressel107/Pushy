package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

public class Player extends GameElement implements Movable {
    private static int res = R.drawable.player_up;
    private static final int resUp = R.drawable.player_up;
    private static final int resRight = R.drawable.player_right;
    private static final int resDown = R.drawable.player_down;
    private static final int resLeft = R.drawable.player_left;
    private Direction lookDirection;
    private int keysCount;

    public Player(int x, int y)
    {
        super(x, y, res);
    }

    public Player(int x, int y, float size)
    {
        super(x, y, size, res);
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

    public void reset()
    {
        super.reset();
        keysCount = 0;
    }

    @Override
    public void move(Direction direction)
    {
        switch (direction)
        {
            case Left:
                x--;
                lookDirection = Direction.Left;
                setRes(this.resLeft);
                break;
            case Right:
                x++;
                lookDirection = Direction.Right;
                setRes(this.resRight);
                break;
            case Up:
                y--;
                lookDirection = Direction.Up;
                setRes(this.resUp);
                break;
            case Down:
                y++;
                lookDirection = Direction.Down;
                setRes(this.resDown);
                break;
        }
    }


}

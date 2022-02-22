package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

public class WoodenBox extends GameElement implements Movable
{
    private static final int res = R.drawable.woodenbox;

    public WoodenBox()
    {
        super(res);
    }

    public WoodenBox(int x, int y)
    {
        super(x, y, res);
    }

    @Override
    public void move(Direction direction)
    {
        switch (direction)
        {
            case Left:
                x--;
                break;
            case Right:
                x++;
                break;
            case Up:
                y--;
                break;
            case Down:
                y++;
                break;
        }
    }
}

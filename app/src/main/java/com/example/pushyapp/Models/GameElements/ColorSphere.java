package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

public class ColorSphere extends GameElement implements Interactable, Movable, Accessible
{
    private static final int res = R.drawable.colorsphere;
    private static final int res2 = R.drawable.colorsphere_red;

    private Color color;

    public ColorSphere()
    {
        super(res);
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
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

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof ColorSplash)
        {
            ((ColorSplash) element).dye(this);
        }
        else if (element instanceof ColorArea)
        {
            return ((ColorArea) element).tryTake(this);
        }

        return false;
    }
}

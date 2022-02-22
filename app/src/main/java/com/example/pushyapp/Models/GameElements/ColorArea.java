package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

public class ColorArea extends GameElement implements Interactable, Accessible
{
    private static final int res = R.drawable.colorarea;
    private static final int res2 = R.drawable.colorarea_red;
    private Color color;

    public ColorArea(int x, int y, Color color)
    {
        super(x, y, res);
        this.color = color;

        switch (color)
        {
            case Red:
                setRes(res2);
                break;
            case Blue:
                setRes(res);
                break;
        }
    }

    public ColorArea(int x, int y, float size, Color color)
    {
        super(x, y, size, res);
        this.color = color;

        switch (color)
        {
            case Red:
                setRes(res2);
                break;
            case Blue:
                setRes(res);
                break;
        }
    }

    public boolean tryTake(ColorSphere sphere)
    {
        if (this.color == sphere.getColor())
        {
            sphere.setVisible(false);
            return true;
        }

        return false;
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof ColorSphere)
        {
            return tryTake((ColorSphere) element);
        }

        return false;
    }
}

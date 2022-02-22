package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

public class ColorSplash extends GameElement implements Interactable, Accessible
{
    private static final int res = R.drawable.colorsplash;
    private static final int res2 = R.drawable.colorsplash_red;

    private Color color;

    public ColorSplash(int x, int y, Color color)
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

    public ColorSplash(int x, int y, float size, Color color)
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

    public void dye(ColorSphere sphere)
    {
        sphere.setColor(this.color);
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof ColorSphere)
        {
            System.out.println("Wird gefärbt");
            dye((ColorSphere) element);
        }

        return true;
    }
}
package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

public class ColorSphere extends GameElement implements Movable, Accessible
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
}

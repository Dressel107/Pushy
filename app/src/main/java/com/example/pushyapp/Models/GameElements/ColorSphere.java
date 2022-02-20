package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

public class ColorSphere extends GameElement implements Movable, Accessible
{
    private static final String BITMAP_SOURCE = "ColorSphere.png";

    private Color color;

    public ColorSphere()
    {
        super();
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

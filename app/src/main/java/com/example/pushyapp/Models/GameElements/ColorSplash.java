package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;

public class ColorSplash extends GameElement implements Accessible
{
    private static final String BITMAP_SOURCE = "ColorSplash.png";
    private Color color;

    public ColorSplash()
    {
        super();
    }

    public void dye(ColorSphere sphere)
    {
        sphere.setColor(this.color);
    }
}

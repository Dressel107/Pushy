package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

public class ColorSplash extends GameElement implements Accessible
{
    private static final int res = R.drawable.colorsplash;
    private static final int res2 = R.drawable.colorsplash_red;

    private Color color;

    public ColorSplash()
    {
        super(res);
    }

    public void dye(ColorSphere sphere)
    {
        sphere.setColor(this.color);
    }
}

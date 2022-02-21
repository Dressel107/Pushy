package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

public class ColorArea extends GameElement implements Accessible
{
    private static final int res = R.drawable.colorarea;
    private static final int res2 = R.drawable.colorarea_red;
    private Color color;

    public ColorArea()
    {
        super(res);
    }
}

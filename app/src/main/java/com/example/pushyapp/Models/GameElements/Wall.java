package com.example.pushyapp.Models.GameElements;



import android.graphics.Bitmap;

import com.example.pushyapp.R;

public class Wall extends GameElement
{
    private static final String BITMAP_SOURCE = "wall.png";


    public Wall()
    {
        super(BITMAP_SOURCE);
    }
}
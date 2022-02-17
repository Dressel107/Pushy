package com.example.pushyapp.Models.GameElements;

import android.graphics.Bitmap;

public class GameElement
{
    private float x;
    private float y;
    private Bitmap bitmap;

    public GameElement()
    {

    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}

package com.example.pushyapp.Models.GameElements;

import android.graphics.Bitmap;

import com.example.pushyapp.R;

public class GameElement
{
    private float x;
    private float y;
    private float size;
    private boolean isVisible;
    private int res = R.drawable.woodenbox;


    public GameElement(String bitmapSource)
    {

    }

    public GameElement(int bitmap){};

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
    public int getRes() {
        return res;
    }
}

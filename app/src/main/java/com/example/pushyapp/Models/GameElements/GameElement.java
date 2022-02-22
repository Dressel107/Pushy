package com.example.pushyapp.Models.GameElements;

public abstract class GameElement
{
    protected int x;
    protected int y;
    protected float size;
    protected boolean isVisible;
    protected int res;

    public GameElement(int x, int y, int res)
    {
        this.x = x;
        this.y = y;
        this.res = res;
    }

    public GameElement(int x, int y, float size, int res)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.res = res;
    }

    public GameElement(int res){
        this.res = res;
    }

    public float getScreenX()
    {
        return x * size;
    }

    public float getScreenY()
    {
        return y * size;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size)
    {
        this.size = size;
    }

    public void setRes(int res) {
        this.res = res;
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

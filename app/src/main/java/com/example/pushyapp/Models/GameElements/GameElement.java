package com.example.pushyapp.Models.GameElements;



public class GameElement
{
    private float x;
    private float y;
    private float size;
    private boolean isVisible;
    private int res;


    public GameElement()
    {

    }

    public GameElement(int res){
        this.res = res;
    }



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

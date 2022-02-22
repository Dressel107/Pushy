package com.example.pushyapp.Models.GameElements;


import java.util.ArrayList;

public class GameElement
{
    protected int x;
    protected int y;
    protected float size;
    protected boolean isVisible;
    protected int res;
    protected ArrayList<GameElement> interactableElements;

    public GameElement()
    {

    }

    public GameElement(int x, int y){
        this.x = x;
        this.y = y;
    }

    public GameElement(int x, int y, int res){
        this.x = x;
        this.y = y;
        this.res = res;
    }



    public GameElement(int res){
        this.res = res;
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

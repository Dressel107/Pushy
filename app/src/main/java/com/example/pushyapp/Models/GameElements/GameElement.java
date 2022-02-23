package com.example.pushyapp.Models.GameElements;

/**
 * Definiert den Aufbau eines Spielelements.
 * @author Simon Schnitker, Dirk Dresselhaus
 */
public abstract class GameElement
{
    /**
     * Gibt den Startindex des Elements in X-Richtung auf dem Spielfeld an.
     */
    private int startX;

    /**
     * Gibt den Startindex des Elements in Y-Richtung auf dem Spielfeld an.
     */
    private int startY;

    /**
     * Gibt den aktuellen Index des Elements in X-Richtung auf dem Spielfeld an.
     */
    protected int x;

    /**
     * Gibt den aktuellen Index des Elements in Y-Richtung auf dem Spielfeld an.
     */
    protected int y;

    /**
     * Gibt die Größe in X- und Y-Richtung des Elements an.
     */
    protected float size;

    /**
     * Gibt an, ob das Element sichtbar ist.
     */
    protected boolean isVisible;

    /**
     * Gibt die ID der Ressource aus dem drawable-Ordner an.
     */
    protected int res;

    public GameElement(int x, int y, int res)
    {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.res = res;
        this.isVisible = true;
    }

    public GameElement(int x, int y, float size, int res)
    {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.size = size;
        this.res = res;
        this.isVisible = true;
    }

    public void reset(){
        this.x = startX;
        this.y = startY;
        this.isVisible = true;
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

    public float getSize()
    {
        return size;
    }

    public void setSize(float size)
    {
        this.size = size;
    }

    public void setRes(int res)
    {
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

    public int getRes()
    {
        return res;
    }
}

package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

/**
 * Definiert den Aufbau einer Kugel.
 * @author Simon Schnitker
 */
public class ColorSphere extends GameElement implements Interactable, Movable {
    private static final int res = R.drawable.colorsphere;
    private static final int res2 = R.drawable.colorsphere_red;

    private Color color;
    private Color startColor;

    public ColorSphere(int x, int y, Color color)
    {
        super(x, y, res);
        this.startColor = color;
        setColor(color);
    }

    public void reset()
    {
        super.reset();
        setColor(startColor);
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color)
    {
        this.color = color;

        switch (color)
        {
            case Red:
                setRes(res2);
                break;
            case Blue:
                setRes(res);
                break;
        }
    }

    /**
     * Bewegt das Element in die angegebene Richtung.
     * @param direction Die Richtung, in der sich das Element bewegen soll.
     * @author Simon Schnitker
     */
    @Override
    public void move(Direction direction)
    {
        switch (direction)
        {
            case Left:
                x--;
                break;
            case Right:
                x++;
                break;
            case Up:
                y--;
                break;
            case Down:
                y++;
                break;
        }
    }

    /**
     * Versucht, das zugrundeliegende Objekt mit dem übergebenen Objekt interagieren zu lassen.
     * Eine Interaktion ist mit den Elementen "ColorSplash" und "ColorArea" möglich.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, falls die Interaktion möglich war, andernfalls false.
     * @author Simon Schnitker
     */
    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof ColorSplash)
        {
            ((ColorSplash) element).dye(this);
            return true;
        }
        else if (element instanceof ColorArea)
        {
            return ((ColorArea) element).tryTake(this);
        }

        return false;
    }
}

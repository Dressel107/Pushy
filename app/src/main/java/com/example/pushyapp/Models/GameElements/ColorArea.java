package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

/**
 * Definiert den Aufbau einer Farbfläche.
 * @author Simon Schnitker
 */
public class ColorArea extends GameElement implements Interactable {
    private static final int res = R.drawable.colorarea;
    private static final int res2 = R.drawable.colorarea_red;
    private Color color;

    public ColorArea(int x, int y, Color color)
    {
        super(x, y, res);
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

    public boolean tryTake(ColorSphere sphere)
    {
        if (this.color == sphere.getColor())
        {
            sphere.setVisible(false);
            return true;
        }

        return false;
    }

    /**
     * Versucht, das zugrundeliegende Objekt mit dem übergebenen Objekt interagieren zu lassen.
     * Eine Interaktion ist mit dem Element "ColorSphere" möglich.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, falls die Interaktion möglich war, andernfalls false.
     * @author Simon Schnitker
     */
    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof ColorSphere)
        {
            return tryTake((ColorSphere) element);
        }

        return false;
    }
}

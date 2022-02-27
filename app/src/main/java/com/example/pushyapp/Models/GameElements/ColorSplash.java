package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Farbkleckes.
 * @author Simon Schnitker
 */
public class ColorSplash extends GameElement implements Interactable {
    private static final int res = R.drawable.colorsplash;
    private static final int res2 = R.drawable.colorsplash_red;

    /**
     * Gibt an, welche Farbe die Kugel besitzt.
     * @author Simon Schnitker
     */
    private Color color;

    public ColorSplash(int x, int y, Color color)
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

    public ColorSplash(int x, int y, float size, Color color)
    {
        super(x, y, size, res);
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
     * Färbt die Kugel in die Farbe des Farbkleckses um.
     * @param sphere Die Kugel, die umgefärbt werden soll.
     * @author Simon Schnitker
     */
    public void dye(ColorSphere sphere)
    {
        sphere.setColor(this.color);
    }

    /**
     * Versucht, das zugrundeliegende Objekt mit dem übergebenen Objekt interagieren zu lassen.
     * Eine Interaktion ist mit dem Element "ColorSphere" möglich.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, da dieses Element von allen anderen Objekten betretbar ist.
     * @author Simon Schnitker
     */
    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof ColorSphere)
        {
            dye((ColorSphere) element);
            this.isVisible = false;
        }

        return true;
    }
}
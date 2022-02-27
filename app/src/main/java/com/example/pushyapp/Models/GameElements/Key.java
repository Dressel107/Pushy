package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

import java.util.ArrayList;

/**
 * Definiert den Aufbau eines Schlüssels.
 * @author Simon Schnitker
 */
public class Key extends GameElement implements Interactable, Movable
{
    private static final int res = R.drawable.key;

    public Key(int x, int y)
    {
        super(x, y, res);
    }

    /**
     * Versucht, das zugrundeliegende Objekt mit dem übergebenen Objekt interagieren zu lasssen.
     * Eine Interaktion ist mit den Elementen "Player" und "Gate" möglich.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, falls die Interaktion möglich war, andernfalls false.
     * @author Simon Schnitker
     */
    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof Player)
        {
            ((Player) element).collectKey();
            this.isVisible = false;
            return true;
        }
        else if (element instanceof Gate)
        {
            if (((Gate) element).getIsOpen() == false)
            {
                ((Gate) element).open();
                this.isVisible = false;
            }

            return true;
        }

        return false;
    }

    /**
     * Bewegt das Element in die angegebene Richtung.
     * @param direction Die Richtung, in der sich das Element bewegen soll.
     * @author Simon Schnitker
     */
    @Override
    public void move(Direction direction)
    {
        switch (direction) {
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
}
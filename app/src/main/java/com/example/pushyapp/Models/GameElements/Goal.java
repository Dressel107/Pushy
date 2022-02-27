package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Ziels.
 * @author Simon Schnitker
 */
public class Goal extends GameElement implements Interactable {
    private static final int res = R.drawable.goal;

    public Goal(int x, int y)
    {
        super(x, y, res);
    }

    /**
     * Versucht, das zugrundeliegende Objekt mit dem übergebenen Objekt interagieren zu lassen.
     * Eine Interaktion ist mit dem Element "Player" möglich.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, falls die Interaktion möglich war, andernfalls false.
     * @author Simon Schnitker
     */
    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof Player)
        {
            return true;
        }

        return false;
    }
}
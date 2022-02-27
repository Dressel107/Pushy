package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Tores.
 * @author Simon Schnitker
 */
public class Gate extends GameElement implements Interactable {
    private static final int res = R.drawable.gate_lock;
    private static final int res2 = R.drawable.gate_open;
    private boolean isOpen;

    public Gate(int x, int y)
    {
        super(x, y, res);
    }

    public Gate(int x, int y, float size)
    {
        super(x, y, size, res);
    }

    public void open()
    {
        this.isOpen = true;
        setRes(res2);
    }

    /**
     * Setzt den Zustand des Elements zurück.
     * @author Simon Schnitker
     */
    public void reset()
    {
        super.reset();
        isOpen = false;
        setRes(res);
    }

    public boolean getIsOpen()
    {
        return isOpen;
    }

    /**
     * Versucht, das zugrundeliegende Objekt mit dem übergebenen Objekt interagieren zu lassen.
     * Eine Interaktion ist mit den Elementen "Player" und "Key" möglich.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, falls die Interaktion möglich war oder das Tor geöffnet ist, andernfalls false.
     * @author Simon Schnitker
     */
    @Override
    public boolean tryInteract(GameElement element)
    {
        if (isOpen)
        {
            return true;
        }

        if (element instanceof Key)
        {
            if (isOpen == false)
            {
                this.open();
                element.setVisible(false);
            }

            return true;
        }
        else if (element instanceof Player && isOpen == false)
        {
            if (((Player) element).tryUsingKey())
            {
                this.open();
                return true;
            }
        }

        return false;
    }
}

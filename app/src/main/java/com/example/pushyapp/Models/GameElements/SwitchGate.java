package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Schaltertors.
 * @author Dirk Dresselhaus
 */
public class SwitchGate extends GameElement implements Interactable
{
    private static final int res = R.drawable.gate;
    private static final int res2 = R.drawable.gate_open;

    /**
     * Gibt an, ob das Tor geöffnet ist.
     * @author Dirk Dresselhaus
     */
    private boolean isOpen;

    public SwitchGate(int x, int y)
    {
        super(x, y, res);
        isOpen = false;
    }

    /**
     * Öffnet das Tor.
     * @author Dirk Dresselhaus
     */
    public void open()
    {
        this.isOpen = true;
        setRes(res2);
    }

    /**
     * Schließt das Tor.
     * @author Dirk Dresselhaus
     */
    public void close()
    {
        this.isOpen = false;
        setRes(res);
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        return isOpen;
    }
}

package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class SwitchGate extends GameElement implements Interactable
{
    private static final int res = R.drawable.goal;
    private static final int res2 = R.drawable.gate_open;

    private boolean isOpen;

    public SwitchGate(int x, int y)
    {
        super(x, y, res);
        isOpen = false;
    }

    public void open()
    {
        this.isOpen = true;
        setRes(res2);
    }

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

package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Switch extends GameElement implements Interactable
{
    private static final int res = R.drawable.goal;

    private SwitchGate gate;

    public Switch(int x, int y, SwitchGate gate)
    {
        super(x, y, res);
        this.gate = gate;
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (gate.isOpen())
        {
            gate.close();
        }
        else
        {
            gate.open();
        }

        return true;
    }
}

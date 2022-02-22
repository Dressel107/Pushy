package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Gate extends GameElement implements Accessible
{
    private static final int res = R.drawable.gate;
    private static final int res2 = R.drawable.gate_open;
    private boolean isOpen;

    public Gate()
    {
        super(res);
    }

    public void open()
    {
        this.isOpen = true;
    }
}

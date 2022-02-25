package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Switch extends GameElement implements Interactable
{
    private static final int res = R.drawable.lever;
    private static final int res2 = R.drawable.lever_on;
    private boolean isOn;

    private SwitchGate gate;

    public Switch(int x, int y, SwitchGate gate)
    {
        super(x, y, res);
        this.gate = gate;
        this.isOn = false;
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        this.switchLever();
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

    private void switchLever(){
        if(isOn){
            isOn = false;
            this.setRes(res);
        }else{
            isOn = true;
            this.setRes(res2);
        }
    }
}

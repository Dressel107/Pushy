package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Gate extends GameElement implements Interactable, Accessible
{
    private static final int res = R.drawable.gate;
    private boolean isOpen;

    public Gate()
    {
        super(res);
    }

    public void open()
    {
        this.isOpen = true;
    }

    public boolean getIsOpen()
    {
        return isOpen;
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof Key)
        {
            if (isOpen == false)
            {
                this.open();
                element.setVisible(false);
            }

            return true;
        }
        else if (element instanceof Player)
        {
            return ((Player) element).tryUsingKey();
        }

        return false;
    }
}

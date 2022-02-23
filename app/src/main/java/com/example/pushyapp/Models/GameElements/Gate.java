package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Gate extends GameElement implements Interactable {
    private static final int res = R.drawable.gate;
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

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (isOpen)
        {
            return true;
        }
        else if (element instanceof Key)
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
                open();
                return true;
            }
        }

        return false;
    }
}

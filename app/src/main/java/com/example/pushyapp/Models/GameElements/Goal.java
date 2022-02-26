package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Goal extends GameElement implements Interactable {
    private static final int res = R.drawable.goal;

    public Goal(int x, int y)
    {
        super(x, y, res);
    }

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
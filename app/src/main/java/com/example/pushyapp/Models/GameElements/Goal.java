package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Goal extends GameElement implements Interactable {
    private static final int res = R.drawable.goal;

    public Goal(int x, int y)
    {
        super(x, y, res);
    }

    public Goal(int x, int y, float size)
    {
        super(x, y, size, res);
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
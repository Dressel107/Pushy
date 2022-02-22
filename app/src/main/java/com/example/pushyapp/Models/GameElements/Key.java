package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

import java.util.ArrayList;

public class Key extends GameElement implements Interactable, Movable, Collectible
{
    private static final int res = R.drawable.key;

    public Key()
    {
        super(res);
    }

    @Override
    public void collect(Player player)
    {
        player.collectKey();
        this.isVisible = false;
    }

    @Override
    public boolean tryInteract(GameElement element)
    {
        if (element instanceof Player)
        {
            ((Player) element).collectKey();
            return true;
        }
        else if (element instanceof Gate)
        {
            if (((Gate) element).getIsOpen() == false)
            {
                ((Gate) element).open();
                this.isVisible = false;
            }

            return true;
        }

        return false;
    }

    @Override
    public void move(Direction direction)
    {
        switch (direction) {
            case Left:
                x--;
                break;
            case Right:
                x++;
                break;
            case Up:
                y--;
                break;
            case Down:
                y++;
                break;
        }
    }
}
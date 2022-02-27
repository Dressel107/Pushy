package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Spielers.
 * @author Simon Schnitker
 */
public class Player extends GameElement implements Movable {
    private static int res = R.drawable.player_up;
    private static final int resUp = R.drawable.player_up;
    private static final int resRight = R.drawable.player_right;
    private static final int resDown = R.drawable.player_down;
    private static final int resLeft = R.drawable.player_left;
    private int keysCount;

    public Player(int x, int y)
    {
        super(x, y, res);
    }

    /**
     * Sammelt einen Schlüssel ein.
     * @author Simon Schnitker
     */
    public void collectKey()
    {
        this.keysCount++;
    }

    /**
     * Setzt einen Schlüssel ein.
     * @return Gibt zurück, ob ein Schlüssel eingesetzt werden konnte.
     * @author Simon Schnitker
     */
    public boolean tryUsingKey()
    {
        if (keysCount > 0)
        {
            keysCount--;
            return true;
        }

        return false;
    }

    /**
     * Setzt den Zustand des Elements zurück.
     * @author Simon Schnitker
     */
    public void reset()
    {
        super.reset();
        keysCount = 0;
    }

    /**
     * Bewegt den Spieler in die angegebene Richtung.
     * @param direction Die Richtung, in der sich der Spieler bewegen soll.
     * @author Simon Schnitker
     */
    @Override
    public void move(Direction direction)
    {
        switch (direction)
        {
            case Left:
                x--;
                setRes(this.resLeft);
                break;
            case Right:
                x++;
                setRes(this.resRight);
                break;
            case Up:
                y--;
                setRes(this.resUp);
                break;
            case Down:
                y++;
                setRes(this.resDown);
                break;
        }
    }

    public int getKeysCount()
    {
        return keysCount;
    }
}

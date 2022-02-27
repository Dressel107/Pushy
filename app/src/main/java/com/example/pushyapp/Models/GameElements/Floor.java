package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Bodens.
 * @author Dirk Dresselhaus
 */
public class Floor extends GameElement {
    private static final int res = R.drawable.floor;

    public Floor(int x, int y, float size)
    {
        super(x, y, size, res);
    }
}
package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

public class Floor extends GameElement implements Accessible{
    private static final int res = R.drawable.floor;

    public Floor()
    {
        super(res);
    }

    public Floor(int x, int y){
        super(x,y,res);
    }

    public Floor(float x, float y, float size){
        super(x, y, size, res);

    }
}

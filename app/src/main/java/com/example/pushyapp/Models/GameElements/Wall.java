package com.example.pushyapp.Models.GameElements;




import com.example.pushyapp.R;

public class Wall extends GameElement
{
    private static final int res = R.drawable.wall;

    public Wall()
    {
        super(res);
    }

    public Wall(int x, int y)
    {
        super(x,y,res);
    }
<<<<<<< Updated upstream
=======

    public Wall(int x, int y, float size)
    {
       super(x, y, size, res);
    }
>>>>>>> Stashed changes
}
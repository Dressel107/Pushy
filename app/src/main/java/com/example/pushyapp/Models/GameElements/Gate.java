package com.example.pushyapp.Models.GameElements;

public class Gate extends GameElement implements Accessible
{
    private static final String BITMAP_SOURCE = "Gate.png";
    private boolean isOpen;

    public Gate()
    {
        super(BITMAP_SOURCE);
    }

    public void open()
    {
        this.isOpen = true;
    }
}

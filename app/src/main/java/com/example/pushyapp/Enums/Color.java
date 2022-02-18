package com.example.pushyapp.Enums;

public enum Color
{
    Red("#fa6969"),
    Green("#5fd969"),
    Blue("#67b0f5");

    public final String hexValue;

    private Color(String hexValue)
    {
        this.hexValue = hexValue;
    }
}

package com.example.pushyapp.Models;
import com.example.pushyapp.Models.GameElements.GameElement;



public class Gamefield
{
    private GameElement[][][] gameElements;


    public Gamefield(GameElement[][][] elements)
    {
        this.gameElements = elements;
    }

    public GameElement[][][] getGameElements() {
        return gameElements;
    }
}

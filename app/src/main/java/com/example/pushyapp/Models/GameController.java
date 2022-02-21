package com.example.pushyapp.Models;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Presenter;

import java.util.ArrayList;

public class GameController
{
    public static final int HORIZONTAL_FIELD_COUNT = 10;
    public static final int VERTICAL_FIELD_COUNT = 15;

    private ArrayList<GameElement> elements;
    private Presenter presenter;

    public GameController(AppCompatActivity activity, Level level)
    {
        presenter = new Presenter(activity, level.getElements(), HORIZONTAL_FIELD_COUNT, VERTICAL_FIELD_COUNT);
    }

    private void playerMoved(Direction direction)
    {

    }

    private ArrayList<GameElement> getElementsAtPosition(int x, int y)
    {
        ArrayList<GameElement> elements = new ArrayList<>();

        for (GameElement element : elements)
        {
            if (element.getX() == x && element.getY() == y)
            {
                elements.add(element);
            }
        }

        return elements;
    }
}
package com.example.pushyapp.Models;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Activities.LevelFinishedActivity;
import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.Models.GameElements.ColorSphere;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Interactable;
import com.example.pushyapp.Models.GameElements.Movable;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Presenter;

import java.util.ArrayList;

public class GameController implements ScreenListener
{
    public static final int HORIZONTAL_FIELD_COUNT = 10;
    public static final int VERTICAL_FIELD_COUNT = 15;

    AppCompatActivity activity;
    private Level level;
    private Presenter presenter;
    private Player player;

    public GameController(AppCompatActivity activity, Level level)
    {
        this.activity = activity;
        this.level = level;
        presenter = new Presenter(activity, level.getElements(), HORIZONTAL_FIELD_COUNT, VERTICAL_FIELD_COUNT);
        presenter.setScreenListener(this);
        extractPlayerFromLevel();

        level.addBorders(HORIZONTAL_FIELD_COUNT, VERTICAL_FIELD_COUNT);
    }

    private void extractPlayerFromLevel()
    {
        for (GameElement element : level.getElements())
        {
            if (element instanceof Player)
            {
                this.player = (Player) element;
            }
        }
    }

    private boolean canWin()
    {
        for (GameElement element : level.getElements())
        {
            if (element instanceof ColorSphere)
            {
                return false;
            }
        }

        return true;
    }

    private void sortOutElements()
    {
        for (int i = 0; i < level.getElements().size(); i++)
        {
            if (level.getElements().get(i).isVisible() == false)
            {
                level.getElements().remove(level.getElements().get(i));
            }
        }
    }

    private GameElement getElementNextToPosition(int x, int y, Direction direction, int fieldCount)
    {
        int targetX = x;
        int targetY = y;

        switch (direction)
        {
            case Left:
                targetX = x - fieldCount;
                break;
            case Right:
                targetX = x + fieldCount;
                break;
            case Up:
                targetY = y - fieldCount;
                break;
            case Down:
                targetY = y + fieldCount;
                break;
        }

        for (GameElement element : level.getElements())
        {
            if (element.getX() == targetX && element.getY() == targetY)
            {
                return element;
            }
        }

        return null;
    }

    private void forceDraw()
    {
        sortOutElements();
        presenter.drawEmptyGamefield();

        for (GameElement e : level.getElements())
        {
            presenter.draw(e);
        }
    }

    private void showLevelResultsScreen()
    {
        Intent intent = new Intent(this.activity, LevelFinishedActivity.class);
        activity.startActivity(intent);
    }

    public void playerMoving(Direction direction)
    {
        GameElement element = getElementNextToPosition(player.getX(), player.getY(), direction, 1);

        // Wenn Feld frei
        if (element == null)
        {
            player.move(direction);
        }
        // Wenn das Element mit dem Spieler interagieren kann
        else if (element instanceof Interactable && ((Interactable) element).tryInteract(player))
        {
            player.move(direction);

            // Wenn Element das Ziel ist und das Spiel gewonnen werden kann
            if (element instanceof Goal && canWin())
            {
                showLevelResultsScreen();
            }
        }
        // Wenn das Element bewegbar ist
        else if (element instanceof Movable)
        {
            int fieldCount = 2;
            ArrayList<Movable> movables = new ArrayList<>();
            movables.add(player);
            movables.add((Movable) element);

            GameElement e1 = element;
            GameElement e2;

            while (true)
            {
                e2 = getElementNextToPosition(player.getX(), player.getY(), direction, fieldCount);

                if (e2 == null || (e2 instanceof Interactable && ((Interactable) e2).tryInteract(e1)))
                {
                    for (Movable movable : movables)
                    {
                        movable.move(direction);
                    }

                    break;
                }
                else if (e2 instanceof Movable)
                {
                    movables.add((Movable) e2);
                    e1 = e2;
                    fieldCount++;
                }
                else
                {
                    break;
                }
            }
        }

        forceDraw();
    }
}
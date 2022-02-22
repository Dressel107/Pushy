package com.example.pushyapp.Models;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.Models.GameElements.Accessible;
import com.example.pushyapp.Models.GameElements.Collectible;
import com.example.pushyapp.Models.GameElements.ColorArea;
import com.example.pushyapp.Models.GameElements.ColorSphere;
import com.example.pushyapp.Models.GameElements.ColorSplash;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Gate;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Interactable;
import com.example.pushyapp.Models.GameElements.Movable;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Presenter;

import java.util.ArrayList;

public class GameController
{
    public static final int HORIZONTAL_FIELD_COUNT = 10;
    public static final int VERTICAL_FIELD_COUNT = 15;

    private Level level;
    private Presenter presenter;
    private Player player;

    public GameController(AppCompatActivity activity, Level level)
    {
        this.level = level;
        player = new Player(level.getPlayerXPosition(), level.getPlayerYPosition());
        presenter = new Presenter(activity, level.getElements(), HORIZONTAL_FIELD_COUNT, VERTICAL_FIELD_COUNT);

        playerMoved(Direction.Up);
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
            if (level.getElements().get(i).isVisible())
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
            e.setSize(40f);
            presenter.draw(e, e.getX(), e.getY());
        }
    }

    private void playerMoved(Direction direction)
    {
        GameElement element = getElementNextToPosition(player.getX(), player.getY(), direction, 1);

        // Wenn Element das Ziel ist
        if (element instanceof Goal)
        {
            if (canWin())
            {
                // TODO: Intent
            }

            return;
        }

        // Wenn Feld frei
        if (element == null)
        {
            player.move(direction);
            forceDraw();
            return;
        }

        // Wenn das Element mit anderen Elementen interagieren kann
        if (element instanceof Interactable)
        {
            if (((Interactable) element).tryInteract(player))
            {
                player.move(direction);
                forceDraw();
                return;
            }
        }

        // Wenn das Element bewegbar ist
        if (element instanceof Movable)
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

                if (e2 instanceof Interactable)
                {
                    if (((Interactable) e2).tryInteract(e1))
                    {
                        for (Movable movable : movables)
                        {
                            movable.move(direction);
                        }

                        forceDraw();
                        return;
                    }
                }

                if (e2 instanceof Movable)
                {
                    movables.add((Movable) e2);
                    e1 = e2;
                    fieldCount++;
                }
            }
        }









//        if (element == null)
//        {
//            player.move(direction);
//        }
//        else if (element instanceof Goal)
//        {
//            if (canWin())
//            {
//
//            }
//        }
//        else if (element instanceof Gate)
//        {
//            if (player.tryUsingKey())
//            {
//                ((Gate) element).open();
//                player.move(direction);
//            }
//        }
//        else if (element instanceof Collectible)
//        {
//            ((Collectible) element).collect(player);
//            level.getElements().remove(element);
//
//            player.move(direction);
//        }
//        else if (element instanceof Movable)
//        {
//            GameElement element2 = getElementAtPosition(player.getX() - 2, player.getY());
//
//            if (element2 == null)
//            {
//                ((Movable) element).move(direction);
//                player.move(direction);
//            }
//            else if (element2 instanceof ColorSplash && element instanceof ColorSphere)
//            {
//                ((ColorSplash) element2).dye((ColorSphere) element);
//                ((ColorSphere) element).move(direction);
//                player.move(direction);
//            }
//            else if (element2 instanceof ColorArea && element instanceof ColorSphere)
//            {
//                if (((ColorArea) element2).tryTake((ColorSphere) element))
//                {
//                    player.move(direction);
//                }
//            }
//        }

        // presenter.draw(level.getElements());
    }

    private ArrayList<GameElement> getElementsAtPosition(int x, int y)
    {
        ArrayList<GameElement> elements = new ArrayList<>();

        for (GameElement element : level.getElements())
        {
            if (element instanceof Accessible && element.getX() == x && element.getY() == y)
            {
                elements.add(element);
            }
        }

        return elements;
    }

    private GameElement getElementAtPosition(int x, int y)
    {
        for (GameElement element : level.getElements())
        {
            if (element instanceof Accessible && element.getX() == x && element.getY() == y)
            {
                return element;
            }
        }

        return null;
    }

}
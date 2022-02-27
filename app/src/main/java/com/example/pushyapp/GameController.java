package com.example.pushyapp;

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
import com.example.pushyapp.Models.Level;

import java.util.ArrayList;

/**
 * Definiert die Steuerung und Logik des Spielgeschehens eines Levels.
 * @author Simon Schnitker, Dirk Dresselhaus
 */
public class GameController implements ScreenListener
{
    AppCompatActivity activity;
    private Presenter presenter;
    private Level level;
    private Player player;
    private int triesCount;
    private long startTime;

    public GameController(AppCompatActivity activity, Level level)
    {
        this.activity = activity;
        this.level = level;
        presenter = new Presenter(activity, level.getElements(), level.getHorizontalFieldCount(), level.getVerticalFieldCount());
        presenter.setScreenListener(this);

        initializeLevel();
    }

    /**
     * Initialisiert u.a. Variablen, um einen fehlerfreien Start des Levels zu ermöglichen.
     * @author Simon Schnitker
     */
    private void initializeLevel()
    {
        for(GameElement element : level.getElements())
        {
            element.reset();
        }

        extractPlayerFromLevel();
        presenter.draw(level.getElements());

        triesCount = 1;
        startTime = System.currentTimeMillis();
    }

    /**
     * Ermittelt das Player-Objekt aus den Levelelementen.
     * @author Simon Schnitker
     */
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

    /**
     * Ermittelt das Element, das sich in der Nähe des übergebenen Elements befindet.
     * @param source Das Element, von dem das entsprechende Nachbarelement gesucht werden soll.
     * @param direction Die Richtung, in der gesucht werden soll.
     * @param distance Die Anzahl Felder, die entfernt gesucht werden soll.
     * @author Simon Schnitker
     * @return Gibt das ermittelte GameElement zurück.
     */
    private GameElement getNearbyElement(GameElement source, Direction direction, int distance)
    {
        int targetX = source.getX();
        int targetY = source.getY();

        switch (direction)
        {
            case Left:
                targetX = source.getX() - distance;
                break;
            case Right:
                targetX = source.getX() + distance;
                break;
            case Up:
                targetY = source.getY() - distance;
                break;
            case Down:
                targetY = source.getY() + distance;
                break;
        }

        for (GameElement element : level.getElements())
        {
            if (element.isVisible() && element.getX() == targetX && element.getY() == targetY)
            {
                return element;
            }
        }

        return null;
    }

    /**
     * Versucht den Spieler in die gewünschte Richtung zu bewegen. Wird vom Presenter aufgerufen.
     * @param direction Gibt die Richtung an, in die sich der Spieler bewegen möchte.
     * @author Simon Schnitker
     */
    public void playerMoving(Direction direction)
    {
        GameElement element = getNearbyElement(player, direction, 1);

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
                won();
            }
        }
        // Wenn das Element bewegbar ist
        else if (element instanceof Movable)
        {
            int distance = 2;
            ArrayList<Movable> movables = new ArrayList<>();
            movables.add(player);
            movables.add((Movable) element);

            GameElement e1 = element;
            GameElement e2;

            while (true)
            {
                // Element daneben ermitteln
                e2 = getNearbyElement(player, direction, distance);

                // Prüfen, ob die hinteren beiden Elemente der Schlange miteinander interagieren können
                if (e2 == null || (e2 instanceof Interactable && ((Interactable) e2).tryInteract(e1)))
                {
                    for (Movable movable : movables)
                    {
                        movable.move(direction);
                    }

                    break;
                }
                // Falls nicht, prüfen, ob es Movable ist.
                // Falls ja, das Element der Liste der später zu-bewegenden Elemente hinzufügen.
                else if (e2 instanceof Movable)
                {
                    movables.add((Movable) e2);
                    e1 = e2;
                    distance++;
                }
                else
                {
                    break;
                }
            }
        }

        presenter.draw(level.getElements());
    }

    /**
     * Prüft, ob das Level abgeschlossen werden kann.
     * Dies ist nur der Fall, wenn keine Farbkugeln mehr vorhanden sind.
     * @return Gibt zurück, ob das Level abgeschlossen werden kann.
     * @author Simon Schnitker
     */
    private boolean canWin()
    {
        for (GameElement element : level.getElements())
        {
            if (element instanceof ColorSphere && element.isVisible())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Ruft den Ergebnisbildschirm auf.
     * @author Simon Schnitker
     */
    private void won()
    {
        long durationInSeconds = (System.currentTimeMillis() - startTime) / 1000;
        level.updateProgress(durationInSeconds);

        Intent intent = new Intent(activity, LevelFinishedActivity.class);
        intent.putExtra("triesCount", triesCount);
        intent.putExtra("duration", durationInSeconds);
        intent.putExtra("nextLevel", level.getId() + 1);
        activity.startActivity(intent);
    }

    /**
     * Startet das Level neu.
     * @author Dirk Dresselhaus.
     */
    public void restart(){
        for(GameElement element : level.getElements()){
            element.reset();
        }
        triesCount++;
        startTime = System.currentTimeMillis();
        presenter.draw(level.getElements());
    }

    /**
     * Setzt den Zustand aller GameElement-Objekte zurück, um das Level beenden zu können.
     * @author Dirk Dresselhaus.
     */
    public void cancel() {
        for(GameElement element : level.getElements()){
            element.reset();
        }
        triesCount = 1;
        startTime = 0;
    }
}
package com.example.pushyapp;

import com.example.pushyapp.Enums.Direction;

/**
 * Stellt die Fähigkeiten bereit, zwischen Klassen kommunizieren zu können.
 * @author Simon Schnitker
 */
public interface ScreenListener
{
    /**
     * Versucht den Spieler in die gewünschte Richtung zu bewegen.
     * @param direction Die gewünschte Richtung.
     * @author Simon Schnitker
     */
    void playerMoving(Direction direction);
}

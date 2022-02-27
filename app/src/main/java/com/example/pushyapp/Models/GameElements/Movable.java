package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;

/**
 * Interface, welches Elementen die Fähigkeit gibt, sich zu bewegen.
 * @author Simon Schnitker
 */
public interface Movable
{
    /**
     * Bewegt das Element in die angegebene Richtung.
     * @param direction Die gewünschte Richtung.
     * @author Simon Schnitker
     */
    void move(Direction direction);
}

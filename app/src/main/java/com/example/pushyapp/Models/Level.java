package com.example.pushyapp.Models;

public class Level
{
    // Gibt die Nummer des Levels an.
    private int number;

    // Gibt an, wie viele Sekunden der Spieler für das Lösen des Levels benötigt hat.
    private int durationInSeconds;

    // Gibt an, ob der Spieler das Level geschafft hat.
    private boolean hasFinished;

    public Level(int number, int durationInSeconds)
    {
        this.number = number;
        this.durationInSeconds = durationInSeconds;

        if (durationInSeconds > 0)
        {
            hasFinished = true;
        }
        else
        {
            hasFinished = false;
        }
    }

    public int getNumber() {
        return number;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }
}

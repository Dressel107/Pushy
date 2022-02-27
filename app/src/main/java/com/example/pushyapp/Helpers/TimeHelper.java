package com.example.pushyapp.Helpers;

import android.content.Context;

import com.example.pushyapp.R;

/**
 * Stellt Hifsmethoden für Zeitintervalle dar.
 * @author Dirk Dresselhaus
 */
public class TimeHelper {

    /**
     * Erstellt einen Text anhand der Anzahl an Sekunden.
     * @param durationInSeconds Die Anzahl der Sekunden.
     * @return Gibt einen passenden Text zurück.
     */
    public static String getDurationText(Context context, long durationInSeconds) {

        if (durationInSeconds == 0) {
            return  "--:--";
        }
        else if (durationInSeconds < 60) {
            return durationInSeconds + " " + context.getResources().getString(R.string.seconds);
        }
        else {
            long minutes = durationInSeconds / 60;
            long seconds = durationInSeconds - (minutes * 60);

            return minutes + ":" + seconds + " " + context.getResources().getString(R.string.minutes);
        }
    }
}
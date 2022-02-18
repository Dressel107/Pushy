package com.example.pushyapp.ListAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.R;

import java.util.ArrayList;

public class LevelListItemAdapter extends ArrayAdapter<Level>
{
    private final Activity context;
    private final Level[] levels;

    public LevelListItemAdapter(Activity context, Level[] levels)
    {
        super(context, R.layout.level_selection_item, levels);

        this.context = context;
        this.levels = levels;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.level_selection_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.level_title);
        TextView neededTimeText = (TextView) rowView.findViewById(R.id.level_needed_time);

        titleText.setText("Level " + levels[position].getId());

        String durationText;
        int duration = levels[position].getDurationInSeconds();

        if (duration == 0)
        {
            durationText = "--:--";
        }
        else if (duration < 60)
        {
            durationText = duration + " Sekunden";
        }
        else
        {
            int minutes = duration / 60;
            int seconds = duration - (minutes * 60);

            durationText = minutes + ":" + seconds + " Minuten";
        }

        neededTimeText.setText(durationText);
        return rowView;
    }
}

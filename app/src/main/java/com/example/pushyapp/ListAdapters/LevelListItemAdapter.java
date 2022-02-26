package com.example.pushyapp.ListAdapters;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.R;

import java.util.ArrayList;

public class LevelListItemAdapter extends ArrayAdapter<Level>
{
    private final Activity context;
    private final ArrayList<Level> levels;

    public LevelListItemAdapter(Activity context, ArrayList<Level> levels)
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
        ImageView hasLevelFinishedIcon = (ImageView) rowView.findViewById(R.id.has_level_finished_icon);

        hasLevelFinishedIcon.setVisibility(View.VISIBLE);
        titleText.setText("Level " + (levels.get(position).getId() + 1));
        long duration = levels.get(position).getDurationInSeconds();
        String durationText;

        if (duration == 0)
        {
            durationText = "--:--";
            hasLevelFinishedIcon.setVisibility(View.INVISIBLE);
        }
        else if (duration < 60)
        {
            durationText = duration + " " + context.getResources().getString(R.string.seconds);
        }
        else
        {
            long minutes = duration / 60;
            long seconds = duration - (minutes * 60);

            durationText = minutes + ":" + seconds + " " + context.getResources().getString(R.string.minuts);
        }

        neededTimeText.setText(durationText);
        return rowView;
    }
}

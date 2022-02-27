package com.example.pushyapp.ListAdapters;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pushyapp.Helpers.TimeHelper;
import com.example.pushyapp.Models.Level;
import com.example.pushyapp.R;

import java.util.ArrayList;

/**
 * Dient dem Setzen von Texten und weiteren Werten von Level-Objekten in den Items der Levelauswahl-ListView.
 * @author Simon Schnitker
 */
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

        long duration = levels.get(position).getDurationInSeconds();
        titleText.setText("Level " + (levels.get(position).getId() + 1));
        neededTimeText.setText(TimeHelper.getDurationText(context, duration));

        // Grünes Häckchen nur setzen, falls das Level bereits absolviert wurde
        if (duration > 0)
        {
            hasLevelFinishedIcon.setVisibility(View.VISIBLE);
        }
        else
        {
            hasLevelFinishedIcon.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}

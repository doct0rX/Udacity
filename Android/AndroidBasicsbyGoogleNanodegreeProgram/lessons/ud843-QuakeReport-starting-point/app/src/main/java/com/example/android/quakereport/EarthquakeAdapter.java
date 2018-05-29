package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context of the app
     * @param earthquakes is a list of earthquakes, which is the data source of the adapter
     */
    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // check if there is an existing list item view (called ConvertView) then I can reuse,
        // else inflate new one
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) convertView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView
        assert currentEarthquake != null;
        magnitudeView.setText(currentEarthquake.getMagnitude());

        // Same goes for Location && Date
        TextView locationView = (TextView) convertView.findViewById(R.id.location);
        locationView.setText(currentEarthquake.getLocation());

        TextView dateView = (TextView) convertView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getDate());

        // Return the list item view that is now showing the appropriate date.
        return convertView;
    }
}

package com.example.doctorx.p5_tour_guide_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by doctorX on 5/9/18.
 *
 */

public class PlaceAdapter extends ArrayAdapter<Place> {
    /**
     * My own implementation of custom constructor
     * @param context context
     * @param places array of places
     */
    public PlaceAdapter(@NonNull Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    /**
     *
     * @param position position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView convertView The recycled view to populate.
     * @param parent parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.place_item, parent, false);
        }

        /** Get the {@link Place} object located at this position in the list */
        Place currentPlace = getItem(position);

        /** find the Image View */
        ImageView cityImg = listItemView.findViewById(R.id.place_image);
        assert currentPlace != null;
        cityImg.setImageResource(currentPlace.getImagePlace());

        /** Find the textView */
        TextView cityName = listItemView.findViewById(R.id.place_text);
        cityName.setText(currentPlace.getStringPlace());

        return listItemView;
    }
}

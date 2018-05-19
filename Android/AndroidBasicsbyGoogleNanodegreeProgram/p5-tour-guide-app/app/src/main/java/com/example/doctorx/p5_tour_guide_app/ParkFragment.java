package com.example.doctorx.p5_tour_guide_app;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkFragment extends Fragment {


    public ParkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        ArrayList<Place> parks = new ArrayList<>();

        parks.add(new Place(R.drawable.park_waterfront, getString(R.string.park_waterfront)));
        parks.add(new Place(R.drawable.park_windmill_hill, getString(R.string.park_windmill)));
        parks.add(new Place(R.drawable.park_founders, getString(R.string.park_founders)));
        parks.add(new Place(R.drawable.park_beverley, getString(R.string.park_beverley)));
        parks.add(new Place(R.drawable.park_cameron_run_regional, getString(R.string.park_cameron_run)));
        parks.add(new Place(R.drawable.park_waterfront, getString(R.string.park_waterfront)));
        parks.add(new Place(R.drawable.park_windmill_hill, getString(R.string.park_windmill)));
        parks.add(new Place(R.drawable.park_founders, getString(R.string.park_founders)));
        parks.add(new Place(R.drawable.park_beverley, getString(R.string.park_beverley)));
        parks.add(new Place(R.drawable.park_cameron_run_regional, getString(R.string.park_cameron_run)));
        parks.add(new Place(R.drawable.park_waterfront, getString(R.string.park_waterfront)));
        parks.add(new Place(R.drawable.park_windmill_hill, getString(R.string.park_windmill)));
        parks.add(new Place(R.drawable.park_founders, getString(R.string.park_founders)));
        parks.add(new Place(R.drawable.park_beverley, getString(R.string.park_beverley)));
        parks.add(new Place(R.drawable.park_cameron_run_regional, getString(R.string.park_cameron_run)));
        parks.add(new Place(R.drawable.park_waterfront, getString(R.string.park_waterfront)));
        parks.add(new Place(R.drawable.park_windmill_hill, getString(R.string.park_windmill)));
        parks.add(new Place(R.drawable.park_founders, getString(R.string.park_founders)));
        parks.add(new Place(R.drawable.park_beverley, getString(R.string.park_beverley)));
        parks.add(new Place(R.drawable.park_cameron_run_regional, getString(R.string.park_cameron_run)));

        PlaceAdapter pPlace = new PlaceAdapter(Objects.requireNonNull(getActivity()), parks);

        ListView listView = rootView.findViewById(R.id.list_of_places);
        listView.setAdapter(pPlace);

        return rootView;
    }

}

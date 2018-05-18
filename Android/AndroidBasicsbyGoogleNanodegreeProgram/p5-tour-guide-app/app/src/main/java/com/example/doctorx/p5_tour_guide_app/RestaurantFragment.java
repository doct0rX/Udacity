package com.example.doctorx.p5_tour_guide_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        // Create list of Restaurants
        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.sea_gull, "BRANDS SHOP"));
        places.add(new Place(R.drawable.fish_market, "City Centre Alexandria"));
        places.add(new Place(R.drawable.fresca, "Paws 'n paws pet shop"));
        places.add(new Place(R.drawable.byblos_restaurant, "Computer Shop"));
        places.add(new Place(R.drawable.hosni, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.fish_market, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.shrimp_sole, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.sea_gull, "BRANDS SHOP"));
        places.add(new Place(R.drawable.fish_market, "City Centre Alexandria"));
        places.add(new Place(R.drawable.fresca, "Paws 'n paws pet shop"));
        places.add(new Place(R.drawable.byblos_restaurant, "Computer Shop"));
        places.add(new Place(R.drawable.hosni, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.fish_market, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.shrimp_sole, "Fighter Pet Shop"));

        PlaceAdapter tPlaces = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);

        return rootView;
    }

}

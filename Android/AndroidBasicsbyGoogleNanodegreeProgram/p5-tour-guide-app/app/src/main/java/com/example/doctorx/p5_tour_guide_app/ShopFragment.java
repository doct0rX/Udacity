package com.example.doctorx.p5_tour_guide_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        // Create list of Tourism Places
        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.brands_shop, "BRANDS SHOP"));
        places.add(new Place(R.drawable.city_center_alex, "City Centre Alexandria"));
        places.add(new Place(R.drawable.paws_n_paws_pet, "Paws 'n paws pet shop"));
        places.add(new Place(R.drawable.computer_shop, "Computer Shop"));
        places.add(new Place(R.drawable.fighter_pet_shop, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.brands_shop, "BRANDS SHOP"));
        places.add(new Place(R.drawable.city_center_alex, "City Centre Alexandria"));
        places.add(new Place(R.drawable.paws_n_paws_pet, "Paws 'n paws pet shop"));
        places.add(new Place(R.drawable.computer_shop, "Computer Shop"));
        places.add(new Place(R.drawable.fighter_pet_shop, "Fighter Pet Shop"));
        places.add(new Place(R.drawable.brands_shop, "BRANDS SHOP"));
        places.add(new Place(R.drawable.city_center_alex, "City Centre Alexandria"));
        places.add(new Place(R.drawable.paws_n_paws_pet, "Paws 'n paws pet shop"));
        places.add(new Place(R.drawable.computer_shop, "Computer Shop"));
        places.add(new Place(R.drawable.fighter_pet_shop, "Fighter Pet Shop"));

        PlaceAdapter tPlaces = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);

        return rootView;
    }

}

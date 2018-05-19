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
public class ShopFragment extends Fragment {


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        // Create list of Tourism Places
        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.fresca, getString(R.string.shop_paws)));
        places.add(new Place(R.drawable.byblos_restaurant, getString(R.string.shop_computer_shop)));
        places.add(new Place(R.drawable.hosni, getString(R.string.shop_fighter_pet)));
        places.add(new Place(R.drawable.sea_gull, getString(R.string.shop_bands)));
        places.add(new Place(R.drawable.fish_market, getString(R.string.shop_city_center)));
        places.add(new Place(R.drawable.fresca, getString(R.string.shop_paws)));
        places.add(new Place(R.drawable.byblos_restaurant, getString(R.string.shop_computer_shop)));
        places.add(new Place(R.drawable.hosni, getString(R.string.shop_fighter_pet)));
        places.add(new Place(R.drawable.sea_gull, getString(R.string.shop_bands)));
        places.add(new Place(R.drawable.sea_gull, getString(R.string.shop_bands)));
        places.add(new Place(R.drawable.fish_market, getString(R.string.shop_city_center)));
        places.add(new Place(R.drawable.fish_market, getString(R.string.shop_city_center)));
        places.add(new Place(R.drawable.fresca, getString(R.string.shop_paws)));
        places.add(new Place(R.drawable.byblos_restaurant, getString(R.string.shop_computer_shop)));
        places.add(new Place(R.drawable.hosni, getString(R.string.shop_fighter_pet)));
        places.add(new Place(R.drawable.sea_gull, getString(R.string.shop_bands)));
        places.add(new Place(R.drawable.fish_market, getString(R.string.shop_city_center)));
        places.add(new Place(R.drawable.fresca, getString(R.string.shop_paws)));
        places.add(new Place(R.drawable.byblos_restaurant, getString(R.string.shop_computer_shop)));
        places.add(new Place(R.drawable.hosni, getString(R.string.shop_fighter_pet)));
        places.add(new Place(R.drawable.sea_gull, getString(R.string.shop_bands)));
        places.add(new Place(R.drawable.fish_market, getString(R.string.shop_city_center)));
        places.add(new Place(R.drawable.fresca, getString(R.string.shop_paws)));
        places.add(new Place(R.drawable.byblos_restaurant, getString(R.string.shop_computer_shop)));
        places.add(new Place(R.drawable.hosni, getString(R.string.shop_fighter_pet)));
        places.add(new Place(R.drawable.sea_gull, getString(R.string.shop_bands)));
        places.add(new Place(R.drawable.fish_market, getString(R.string.shop_city_center)));
        places.add(new Place(R.drawable.fresca, getString(R.string.shop_paws)));
        places.add(new Place(R.drawable.byblos_restaurant, getString(R.string.shop_computer_shop)));
        places.add(new Place(R.drawable.hosni, getString(R.string.shop_fighter_pet)));

        PlaceAdapter tPlaces = new PlaceAdapter(Objects.requireNonNull(getActivity()), places);

        ListView listView = rootView.findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);

        return rootView;
    }

}

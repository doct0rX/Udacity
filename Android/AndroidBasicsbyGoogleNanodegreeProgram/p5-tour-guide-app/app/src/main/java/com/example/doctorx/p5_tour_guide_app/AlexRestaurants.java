package com.example.doctorx.p5_tour_guide_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by doctorX on 5/7/18.
 *
 * For all Restaurants at the Alex City
 */

public class AlexRestaurants extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_places);

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

        PlaceAdapter tPlaces = new PlaceAdapter(this, places);

        ListView listView = findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);
    }
}

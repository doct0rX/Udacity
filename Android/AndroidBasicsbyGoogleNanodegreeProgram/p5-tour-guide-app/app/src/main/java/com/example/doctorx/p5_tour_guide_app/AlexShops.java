package com.example.doctorx.p5_tour_guide_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by doctorX on 5/7/18.
 *
 * For Shops at Alex City
 */

@SuppressLint("Registered")
public class AlexShops extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_places);

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

        PlaceAdapter tPlaces = new PlaceAdapter(this, places);

        ListView listView = findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);
    }
}

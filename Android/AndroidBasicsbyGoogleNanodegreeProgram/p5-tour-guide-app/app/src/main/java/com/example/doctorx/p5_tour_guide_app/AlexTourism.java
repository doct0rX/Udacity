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
 * Tourism Places at Alex City
 */

@SuppressLint("Registered")
public class AlexTourism extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_places);

        // Create list of Tourism Places
        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.citadel_of_qaitbay, "Citadel Of Qaitbay"));
        places.add(new Place(R.drawable.montaza_palace, "Montaza Palace"));
        places.add(new Place(R.drawable.bibliotheca_alex, "Bibliotheca Alexandrina"));
        places.add(new Place(R.drawable.pomperys_pillar, "Pompey's Pillar"));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, "Abu al-Abbas al-Mursi Mosque"));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, "Catacombs of Kom El Shoqafa"));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, "Royal Jewelry Museum"));
        places.add(new Place(R.drawable.citadel_of_qaitbay, "Citadel Of Qaitbay"));
        places.add(new Place(R.drawable.montaza_palace, "Montaza Palace"));
        places.add(new Place(R.drawable.bibliotheca_alex, "Bibliotheca Alexandrina"));
        places.add(new Place(R.drawable.pomperys_pillar, "Pompey's Pillar"));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, "Abu al-Abbas al-Mursi Mosque"));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, "Catacombs of Kom El Shoqafa"));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, "Royal Jewelry Museum"));
        places.add(new Place(R.drawable.citadel_of_qaitbay, "Citadel Of Qaitbay"));
        places.add(new Place(R.drawable.montaza_palace, "Montaza Palace"));
        places.add(new Place(R.drawable.bibliotheca_alex, "Bibliotheca Alexandrina"));
        places.add(new Place(R.drawable.pomperys_pillar, "Pompey's Pillar"));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, "Abu al-Abbas al-Mursi Mosque"));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, "Catacombs of Kom El Shoqafa"));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, "Royal Jewelry Museum"));
        places.add(new Place(R.drawable.citadel_of_qaitbay, "Citadel Of Qaitbay"));
        places.add(new Place(R.drawable.montaza_palace, "Montaza Palace"));
        places.add(new Place(R.drawable.bibliotheca_alex, "Bibliotheca Alexandrina"));
        places.add(new Place(R.drawable.pomperys_pillar, "Pompey's Pillar"));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, "Abu al-Abbas al-Mursi Mosque"));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, "Catacombs of Kom El Shoqafa"));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, "Royal Jewelry Museum"));

        PlaceAdapter tPlaces = new PlaceAdapter(this, places);

        ListView listView = findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);
    }
}

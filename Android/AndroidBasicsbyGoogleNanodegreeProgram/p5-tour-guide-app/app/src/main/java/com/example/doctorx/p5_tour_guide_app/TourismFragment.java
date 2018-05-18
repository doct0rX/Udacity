package com.example.doctorx.p5_tour_guide_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourismFragment extends Fragment {


    public TourismFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

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

        PlaceAdapter tPlaces = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AboutAlex.class);
                String msg = "abc";
                intent.putExtra(Intent.EXTRA_PACKAGE_NAME, msg);
                startActivity(intent);
            }
        });

        return rootView;
    }

}

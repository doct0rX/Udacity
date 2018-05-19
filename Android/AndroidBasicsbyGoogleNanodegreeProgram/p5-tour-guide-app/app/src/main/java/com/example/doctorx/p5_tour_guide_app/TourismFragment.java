package com.example.doctorx.p5_tour_guide_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourismFragment extends Fragment {


    public TourismFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        // Create list of Tourism Places
        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.citadel_of_qaitbay, getString(R.string.place_citadel_of_qaitbay)));
        places.add(new Place(R.drawable.montaza_palace, getString(R.string.place_montaza)));
        places.add(new Place(R.drawable.bibliotheca_alex, getString(R.string.place_bibliotheca_alex)));
        places.add(new Place(R.drawable.pomperys_pillar, getString(R.string.place_pompey)));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, getString(R.string.place_abu_al_abbas_al_mursi_mosque)));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, getString(R.string.place_catacombs)));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, getString(R.string.place_royal_jewelry_museum)));
        places.add(new Place(R.drawable.citadel_of_qaitbay, getString(R.string.place_citadel_of_qaitbay)));
        places.add(new Place(R.drawable.montaza_palace, getString(R.string.place_montaza)));
        places.add(new Place(R.drawable.bibliotheca_alex, getString(R.string.place_bibliotheca_alex)));
        places.add(new Place(R.drawable.pomperys_pillar, getString(R.string.place_pompey)));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, getString(R.string.place_abu_al_abbas_al_mursi_mosque)));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, getString(R.string.place_catacombs)));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, getString(R.string.place_royal_jewelry_museum)));
        places.add(new Place(R.drawable.citadel_of_qaitbay, getString(R.string.place_citadel_of_qaitbay)));
        places.add(new Place(R.drawable.montaza_palace, getString(R.string.place_montaza)));
        places.add(new Place(R.drawable.bibliotheca_alex, getString(R.string.place_bibliotheca_alex)));
        places.add(new Place(R.drawable.pomperys_pillar, getString(R.string.place_pompey)));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, getString(R.string.place_abu_al_abbas_al_mursi_mosque)));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, getString(R.string.place_catacombs)));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, getString(R.string.place_royal_jewelry_museum)));
        places.add(new Place(R.drawable.citadel_of_qaitbay, getString(R.string.place_citadel_of_qaitbay)));
        places.add(new Place(R.drawable.montaza_palace, getString(R.string.place_montaza)));
        places.add(new Place(R.drawable.bibliotheca_alex, getString(R.string.place_bibliotheca_alex)));
        places.add(new Place(R.drawable.pomperys_pillar, getString(R.string.place_pompey)));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, getString(R.string.place_abu_al_abbas_al_mursi_mosque)));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, getString(R.string.place_catacombs)));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, getString(R.string.place_royal_jewelry_museum)));
        places.add(new Place(R.drawable.citadel_of_qaitbay, getString(R.string.place_citadel_of_qaitbay)));
        places.add(new Place(R.drawable.montaza_palace, getString(R.string.place_montaza)));
        places.add(new Place(R.drawable.bibliotheca_alex, getString(R.string.place_bibliotheca_alex)));
        places.add(new Place(R.drawable.pomperys_pillar, getString(R.string.place_pompey)));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, getString(R.string.place_abu_al_abbas_al_mursi_mosque)));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, getString(R.string.place_catacombs)));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, getString(R.string.place_royal_jewelry_museum)));
        places.add(new Place(R.drawable.citadel_of_qaitbay, getString(R.string.place_citadel_of_qaitbay)));
        places.add(new Place(R.drawable.montaza_palace, getString(R.string.place_montaza)));
        places.add(new Place(R.drawable.bibliotheca_alex, getString(R.string.place_bibliotheca_alex)));
        places.add(new Place(R.drawable.pomperys_pillar, getString(R.string.place_pompey)));
        places.add(new Place(R.drawable.abu_al_abbas_al_mursi_mosque, getString(R.string.place_abu_al_abbas_al_mursi_mosque)));
        places.add(new Place(R.drawable.catacombs_of_kom_el_shoqafa, getString(R.string.place_catacombs)));
        places.add(new Place(R.drawable.alex_royal_jewellery_mus_left, getString(R.string.place_royal_jewelry_museum)));

        PlaceAdapter tPlaces = new PlaceAdapter(Objects.requireNonNull(getActivity()), places);

        ListView listView = rootView.findViewById(R.id.list_of_places);
        listView.setAdapter(tPlaces);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AboutAlex.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}

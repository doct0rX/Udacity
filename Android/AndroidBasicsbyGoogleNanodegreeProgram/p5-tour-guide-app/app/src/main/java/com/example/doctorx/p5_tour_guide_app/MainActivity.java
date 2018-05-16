package com.example.doctorx.p5_tour_guide_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[] cityName = {R.string.alex, R.string.cairo, R.string.luxor, R.string.aswan};
    int[] imageId = {R.drawable.alex, R.drawable.cairo, R.drawable.luxor, R.drawable.aswan};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityAdapter adapter = new CityAdapter(MainActivity.this, cityName, imageId);
        gridView = findViewById(R.id.grid);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + getString(cityName[position]), Toast.LENGTH_SHORT).show();

                // intent doesn't work for now!
                if (position == 0) {
                    Intent myIntent = new Intent(MainActivity.this, AlexTourism.class);
                    startActivity(myIntent);
                } else if (position == 1) {
                    Intent myIntent = new Intent(MainActivity.this, AlexRestaurants.class);
                    startActivity(myIntent);
                } else if (position == 2) {
                    Intent myIntent = new Intent(MainActivity.this, AlexShops.class);
                    startActivity(myIntent);
                } else {
                    Intent myIntent = new Intent(MainActivity.this, AboutAlex.class);
                    startActivity(myIntent);
                }
            }
        });
    }
}

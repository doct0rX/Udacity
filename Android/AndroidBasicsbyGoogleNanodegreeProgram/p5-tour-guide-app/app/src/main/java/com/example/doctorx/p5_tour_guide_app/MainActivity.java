package com.example.doctorx.p5_tour_guide_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] cityName = {"Alex", "Cairo", "Luxor", "Aswan"};
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
                Toast.makeText(MainActivity.this, "You Clicked at " +cityName[+ position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

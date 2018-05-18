package com.example.doctorx.p5_tour_guide_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlexTourism extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new TourismFragment())
                .commit();
    }
}
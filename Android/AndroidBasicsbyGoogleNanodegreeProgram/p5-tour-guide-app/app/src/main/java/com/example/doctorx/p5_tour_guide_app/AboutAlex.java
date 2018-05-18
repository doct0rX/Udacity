package com.example.doctorx.p5_tour_guide_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutAlex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutFragment()).commit();
    }
}

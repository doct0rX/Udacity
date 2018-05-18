package com.example.doctorx.p5_tour_guide_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by doctorX on 5/7/18.
 *
 * For Shops at Alex City
 */

public class AlexShops extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ShopFragment())
                .commit();
    }
}

package com.example.doctorx.p5_tour_guide_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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
                    setContentView(R.layout.activity_view_pager);

                    // Find the view pager that will allow the user to swipe between fragments
                    ViewPager viewPager = findViewById(R.id.viewpager);

                    // Create an adapter that knows which fragment should be shown on each page
                    MainPager adapter = new MainPager(MainActivity.this, getSupportFragmentManager());

                    // Set the adapter onto the view pager
                    viewPager.setAdapter(adapter);

                    // Find the tab layout that shows the tabs
                    TabLayout tabLayout = findViewById(R.id.tabs);

                    tabLayout.setupWithViewPager(viewPager);

                } else if (position == 1) {
                    setContentView(R.layout.activity_view_pager);

                    // Find the view pager that will allow the user to swipe between fragments
                    ViewPager viewPager = findViewById(R.id.viewpager);

                    // Create an adapter that knows which fragment should be shown on each page
                    MainPager adapter = new MainPager(MainActivity.this, getSupportFragmentManager());

                    // Set the adapter onto the view pager
                    viewPager.setAdapter(adapter);

                    // Find the tab layout that shows the tabs
                    TabLayout tabLayout = findViewById(R.id.tabs);

                    tabLayout.setupWithViewPager(viewPager);

                } else if (position == 2) {
                    setContentView(R.layout.activity_view_pager);

                    // Find the view pager that will allow the user to swipe between fragments
                    ViewPager viewPager = findViewById(R.id.viewpager);

                    // Create an adapter that knows which fragment should be shown on each page
                    MainPager adapter = new MainPager(MainActivity.this, getSupportFragmentManager());

                    // Set the adapter onto the view pager
                    viewPager.setAdapter(adapter);

                    // Find the tab layout that shows the tabs
                    TabLayout tabLayout = findViewById(R.id.tabs);

                    tabLayout.setupWithViewPager(viewPager);

                } else {
                    setContentView(R.layout.activity_view_pager);

                    // Find the view pager that will allow the user to swipe between fragments
                    ViewPager viewPager = findViewById(R.id.viewpager);

                    // Create an adapter that knows which fragment should be shown on each page
                    MainPager adapter = new MainPager(MainActivity.this, getSupportFragmentManager());

                    // Set the adapter onto the view pager
                    viewPager.setAdapter(adapter);

                    // Find the tab layout that shows the tabs
                    TabLayout tabLayout = findViewById(R.id.tabs);

                    tabLayout.setupWithViewPager(viewPager);
                }

            }
        });
    }
}

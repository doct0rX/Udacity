package com.example.doctorx.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view that show the Electronic category
        ImageView electronic = findViewById(R.id.electronic);

        // Set click listener to that view
        electronic.setOnClickListener(new View.OnClickListener() {
            // the code will executed when the electric is clicked
            @Override
            public void onClick(View view) {
//                // Create a new intent to open {@link ElectronicActivity}
                Intent electronicIntent = new Intent(MainActivity.this, ElectronicActivity.class);
                startActivity(electronicIntent);
            }
        });


        // Find the view for Pop
        ImageView pop = findViewById(R.id.pop);

        // Set click listener to that view
        pop.setOnClickListener(new View.OnClickListener() {
            // the code will executed when the electric is clicked
            @Override
            public void onClick(View view) {
//                // Create a new intent to open {@link ElectronicActivity}
                Intent popIntent = new Intent(MainActivity.this, ElectronicActivity.class);
                startActivity(popIntent);
            }
        });


        // Find the view for Hip Hop
        ImageView hipHop = findViewById(R.id.hip_hop);

        // Set click listener to that view
        hipHop.setOnClickListener(new View.OnClickListener() {
            // the code will executed when the electric is clicked
            @Override
            public void onClick(View view) {
//                // Create a new intent to open {@link ElectronicActivity}
                Intent hipHopIntent = new Intent(MainActivity.this, ElectronicActivity.class);
                startActivity(hipHopIntent);
            }
        });

        // Find the view for Rock
        ImageView rock = findViewById(R.id.rock);

        // Set click listener to that view
        rock.setOnClickListener(new View.OnClickListener() {
            // the code will executed when the electric is clicked
            @Override
            public void onClick(View view) {
//                // Create a new intent to open {@link ElectronicActivity}
                Intent rockIntent = new Intent(MainActivity.this, ElectronicActivity.class);
                startActivity(rockIntent);
            }
        });
    }
}

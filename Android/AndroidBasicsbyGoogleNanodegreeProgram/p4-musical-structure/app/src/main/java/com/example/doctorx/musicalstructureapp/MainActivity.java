package com.example.doctorx.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view that show the Electronic category
        ImageView electronic = findViewById(R.id.electronic);
        electronic.setOnClickListener(this);

        // Find the view for Pop
        ImageView pop = findViewById(R.id.pop);
        pop.setOnClickListener(this);

        // Find the view for Hip Hop
        ImageView hipHop = findViewById(R.id.hip_hop);
        hipHop.setOnClickListener(this);

        // Find the view for Rock
        ImageView rock = findViewById(R.id.rock);
        rock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.electronic:
                Intent electronicIntent = new Intent(MainActivity.this, ElectronicActivity.class);
                startActivity(electronicIntent);

            case R.id.pop:
                Intent popIntent = new Intent(MainActivity.this, PopActivity.class);
                startActivity(popIntent);

            case R.id.hip_hop:
                Intent hipIntent = new Intent(MainActivity.this, HipHopActivity.class);
                startActivity(hipIntent);

            case R.id.rock:
                Intent rockIntent = new Intent(MainActivity.this, RockActivity.class);
                startActivity(rockIntent);
        }
    }
}

package com.example.doctorx.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int zGoals = 0;
    int zFouls = 0;
    int aGoals = 0;
    int aFouls = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setzGoals(View v) {
        zGoals += 1;
        TextView textGoal = findViewById(R.id.z_goals);
        textGoal.setText(String.valueOf(zGoals));
    }

    public void setzFouls(View v) {
        zFouls += 1;
        TextView textFoul = findViewById(R.id.z_fouls);
        textFoul.setText(String.valueOf(zFouls));
    }

    public void setaGoals(View v) {

    }

    public void setaFouls(View v) {

    }
}

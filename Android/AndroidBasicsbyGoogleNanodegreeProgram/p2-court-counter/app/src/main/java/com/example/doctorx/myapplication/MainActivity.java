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
    TextView textGoal,textGoal2, textFoul, textWin, textWin1, textWin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setzGoals(View v) {
        zGoals += 1;
        textGoal = findViewById(R.id.z_goals);
        textGoal.setText(String.valueOf(zGoals));
        teamWin(v);
    }

    public void setzFouls(View v) {
        zFouls += 1;
        textFoul = findViewById(R.id.z_fouls);
        textFoul.setText(String.valueOf(zFouls));
    }

    public void setaGoals(View v) {
        aGoals += 1;
        textGoal = findViewById(R.id.a_goals);
        textGoal.setText(String.valueOf(aGoals));
        teamWin(v);
    }

    public void setaFouls(View v) {
        aFouls += 1;
        textFoul = findViewById(R.id.a_fouls);
        textFoul.setText(String.valueOf(aFouls));
    }

    public void teamWin(View v) {
        if (zGoals > aGoals) {
            textWin = findViewById(R.id.z_win);
            textWin.setText(R.string.win);
        } else if (zGoals < aGoals) {
            textWin = findViewById(R.id.a_win);
            textWin.setText(R.string.win);
        } else {
            textWin1 = findViewById(R.id.a_win);
            textWin2 = findViewById(R.id.z_win);
            textWin1.setText("--");
            textWin2.setText("--");
        }
    }

    public void reset(View v){
        zFouls = 0;
        aFouls = 0;
        zGoals = 0;
        aGoals = 0;
        textWin1 = findViewById(R.id.a_win);
        textWin2 = findViewById(R.id.z_win);
        textWin1.setText("--");
        textWin2.setText("--");
        textGoal = findViewById(R.id.z_goals);
        textGoal2 = findViewById(R.id.a_goals);
        textGoal.setText(String.valueOf(aGoals));
        textGoal.setText(String.valueOf(zGoals));
        textFoul = findViewById(R.id.z_fouls);
        textFoul.setText(String.valueOf(zFouls));
        textFoul = findViewById(R.id.a_fouls);
        textFoul.setText(String.valueOf(aFouls));
    }
}

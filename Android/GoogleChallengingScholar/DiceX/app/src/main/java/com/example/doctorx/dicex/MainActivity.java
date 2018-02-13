package com.example.doctorx.dicex;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Field to hold the result of the Game
    TextView rollResult;

    // Field to hold the score
    int score;

    // Field to hold instance of random class
    Random rand;

    // int to hold out dice number/value
    int die1, die2;

    // ArrayList to hold all three dice values
    ArrayList<Integer> dice;

    // ArrayList to hold all three images
    ArrayList<ImageView> diceImageView;

    // Field to hold total text
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(view);
            }
        });

        // Set initial score
        score = 0;

        // Link activity of Java to layout
        rollResult = findViewById(R.id.rollResult);
        total = findViewById(R.id.totalDice);
        // Create greeting toast
        Toast.makeText(getApplicationContext(), "Welcome to my Game\n\t\t\t\t\t\t\0DiceX", Toast.LENGTH_SHORT).show();

        // initialize the random number generator
        rand = new Random();

        // Create ArrayList container for the diceValues
        dice = new ArrayList<>();

        ImageView die1Image = findViewById(R.id.die1Image);
        ImageView die2Image = findViewById(R.id.die2Image);

        diceImageView = new ArrayList<>();
        diceImageView.add(die1Image);
        diceImageView.add(die2Image);
    }

    // The method gets called when button clicked
    public void rollDice(View v) {
        // Roll Dice
        die1 = rand.nextInt(6) + 1;
        die2 = rand.nextInt(6) + 1;

        // Set die values into ArrayList
        dice.clear();
        dice.add(die1);
        dice.add(die2);

        // Loop to go all the dice images and set every thing up
        for (int dieOfSet = 0; dieOfSet < 2; dieOfSet++) {
            String imageName = "die_" + dice.get(dieOfSet) + ".png";

            try {
                InputStream stream = getAssets().open(imageName);
                Drawable drawable = Drawable.createFromStream(stream, null);
                diceImageView.get(dieOfSet).setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Build msg with the result
        String msg = "";

        if (die1 == die2) {
            msg = "Double of " + die1;
        }

        // Update the app to dispaly the msg
        rollResult.setText(msg);
        total.setText("Total: " + (die1 + die2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

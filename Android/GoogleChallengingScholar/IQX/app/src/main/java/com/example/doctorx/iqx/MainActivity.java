package com.example.doctorx.iqx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score;
    RadioButton rb, rb2, rb3, rb4, rb5;
    TextView textView;
    EditText name;
    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void checkResult (View v) {
        score = 0;
        rb = findViewById(R.id.ans1);
        rb2 = findViewById(R.id.ans2);
        rb3 = findViewById(R.id.ans3);
        rb4 = findViewById(R.id.ans4);
        rb5 = findViewById(R.id.ans5);

        if (rb.isChecked()) {
            score += 10;
             ans = "You Answered Question 1 Correctly";
        } else {
             ans = "You Answered Question 1 Wrongly";
        }

        if (rb2.isChecked()) {
            score += 10;
             ans += "\nYou Answered Question 2 Correctly";
        } else {
             ans += "\nYou Answered Question 2 Wrongly";
        }

        if (rb3.isChecked()) {
            score += 10;
             ans += "\nYou Answered Question 3 Correctly";
        } else {
             ans += "\nYou Answered Question 3 Wrongly";
        }

        if (rb4.isChecked()) {
            score += 10;
             ans += "\nYou Answered Question 4 Correctly";
        } else {
             ans += "\nYou Answered Question 4 Wrongly";
        }

        if (rb5.isChecked()) {
            score += 10;
             ans += "\nYou Answered Question 5 Correctly";
        } else {
             ans += "\nYou Answered Question 5 Wrongly";
        }

        name = findViewById(R.id.name);
        String name1 = name.getText().toString();
        textView = findViewById(R.id.resultText);
        textView.setText("\nHi " + name1 + "," + "\n" + ans + "\nYour Total Score is: " + score + "/50");
    }
}

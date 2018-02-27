package com.example.doctorx.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int score;
    private RadioButton rb, rb2, rb3, rb4;
    private TextView textView;
    private EditText name;
    private String ans;

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


        name = findViewById(R.id.name);
        String name1 = name.getText().toString();
        textView = findViewById(R.id.resultText);
        textView.setText("\nHi " + name1 + "," + "\n" + ans + "\nYour Total Score is: " + score + "/50");
    }

    // TODO: finish the checkbuttons.
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.two:
                if (checked)
                score += 10/3;
                break;
            case R.id.seven:
                if (checked)
                    score+= 10/3;
        }
    }
}

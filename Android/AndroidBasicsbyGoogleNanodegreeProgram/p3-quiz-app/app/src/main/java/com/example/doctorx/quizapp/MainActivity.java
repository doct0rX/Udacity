package com.example.doctorx.quizapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @SuppressLint("SetTextI18n")
    public void checkResult (View v) {
        int score = 0;
        final RadioButton rb = findViewById(R.id.ans1);
        final RadioButton rb2 = findViewById(R.id.ans2);
        final RadioButton rb3 = findViewById(R.id.ans3);
        final RadioButton rb4 = findViewById(R.id.ans4);
        EditText qSix = findViewById(R.id.qSix);

        String ans;
        if (rb.isChecked()) {
            score += 10;
            ans = getString(R.string.rb);
        } else {
            ans = getString(R.string.rb_else);
        }

        if (rb2.isChecked()) {
            score += 10;
            ans += getString(R.string.rb1);
        } else {
            ans += getString(R.string.rb1_else);
        }

        if (rb3.isChecked()) {
            score += 10;
            ans += getString(R.string.rb3);
        } else {
            ans += getString(R.string.rb3_else);
        }

        if (rb4.isChecked()) {
            score += 10;
            ans += getString(R.string.rb4);
        } else {
            ans += getString(R.string.rb4_else);
        }


        // Check Buttons
        final CheckBox cb1 = findViewById(R.id.cb_two);
        final CheckBox cb2 = findViewById(R.id.cb_eleven);
        final CheckBox cb3 = findViewById(R.id.cb_seven);
        final CheckBox cb4 = findViewById(R.id.cb_one);
        final CheckBox cb0 = findViewById(R.id.cb_zero);

        if (cb1.isChecked()) {
            score += 10/2;
        } else {
            ans += "\n 2 is a Prime Number";
        }
        if (cb2.isChecked()) {
            score += 10/2;
        } else {
            ans += "\n 11 is a prime Number";
        }

        if (cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb0.isChecked()) {
            ans += getString(R.string.q_five_correct);
        } else if (cb3.isChecked() || cb4.isChecked() || cb0.isChecked()){
            ans += getString(R.string.q_five_wrong);
            score -= 10/2;
        }


        // For EditText Field for Question 6
        if (qSix.getText().toString().equals(getString(R.string.scientist_name))) {
            score += 10;
            ans += getString(R.string.q_six_correct);
        } else {
            ans += getString(R.string.q_six_wrong);
        }


        EditText name = findViewById(R.id.name);
        String name1 = name.getText().toString();
        TextView textView = findViewById(R.id.resultText);
        textView.setText("\nHi " + name1 + "," + "\n" + ans + getString(R.string.submit_text_view) + score + "/60");

        // Toast for showing the result and checking the correct answer
        if (score != 60) {
            Toast.makeText(MainActivity.this, getString(R.string.toast_fail) + score + getString(R.string.toast_fail2), LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, getString(R.string.toast_success) + score + getString(R.string.toast_success2), LENGTH_LONG).show();
        }


        // check the correct answers
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Radio Buttons
                rb.setChecked(true);
                rb2.setChecked(true);
                rb3.setChecked(true);
                rb4.setChecked(true);

                // Check Buttons
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(false);
                cb4.setChecked(false);
                cb0.setChecked(false);
            }
        });
    }
}

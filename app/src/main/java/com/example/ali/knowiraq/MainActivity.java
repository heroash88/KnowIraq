package com.example.ali.knowiraq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "How much do you know about Iraq?", Toast.LENGTH_LONG).show();
    }


    public void submitAnswers(View view) {
        EditText names = findViewById(R.id.name);
        String playerName = names.getText().toString();

        RadioButton q1a3checked = findViewById(R.id.q1a3);
        boolean correctQ1 = q1a3checked.isChecked();

        RadioButton q2a2checked = findViewById(R.id.q2a2);
        boolean correctQ2 = q2a2checked.isChecked();

        RadioButton q3a2checked = findViewById(R.id.q3a2);
        boolean correctQ3 = q3a2checked.isChecked();

        RadioButton q4a1checked = findViewById(R.id.q4a1);
        boolean correctQ4 = q4a1checked.isChecked();

        RadioButton q5a3checked = findViewById(R.id.q5a3);
        boolean correctQ5 = q5a3checked.isChecked();


        int scores = calculateScore(correctQ1, correctQ2, correctQ3, correctQ4, correctQ5);
        String scoreMessage = createSummary(scores, correctQ1, correctQ2, playerName);
        displayMessage(scoreMessage);
    }

    private int calculateScore(boolean q1a3checked, boolean q2a2checked, boolean q3a2checked, boolean q4a1checked, boolean q5a3checked) {
        scores = 0;

        if (q1a3checked) {
            scores = scores + 1;
        }
        if (q2a2checked) {
            scores = scores + 1;
        }
        if (q3a2checked) {
            scores = scores + 1;
        }
        if (q4a1checked) {
            scores = scores + 1;
        }
        if (q5a3checked) {
            scores = scores + 1;
        }

        return scores;
    }

    private String createSummary(int scores, boolean q1a3checked, boolean q2a2checked, String playerName) {
        String scoreMessage = playerName + " answered \n";
        scoreMessage += scores + " out 5" + " questions correctly";
        return scoreMessage;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.score_summary);
        orderSummaryTextView.setText(message);
        scoreAnalysis();

    }

    private void scoreAnalysis() {

        if (scores == 5) {
            Toast.makeText(this, "Great job! You know Iraq", Toast.LENGTH_LONG).show();

        } else if (scores < 3) {
            Toast.makeText(this, "Well, you need to study more about the land of the two rivers. Click the questions to learn more", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You've done good, click the questions to learn more", Toast.LENGTH_LONG).show();
        }

    }

}
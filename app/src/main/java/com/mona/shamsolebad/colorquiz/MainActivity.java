package com.mona.shamsolebad.colorquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity";
    private int score = 0;
    private Button leftButt;
    private Button rightButt;
    private TextView questionTV;
    private TextView scoreTV;
    private boolean isrightAnswer;

    private void generateQuestion() {
        Question question = new Question();
        leftButt.setBackgroundColor(question.getLeftColor());
        rightButt.setBackgroundColor(question.getRightColor());
        questionTV.setText(question.getQuestionLabel());
        isrightAnswer = question.isRightanswer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTV = findViewById(R.id.scoreTV);

        scoreTV.setText("Score: " + score);
        leftButt = findViewById(R.id.leftBtn);
        rightButt = findViewById(R.id.rightBtn);
        questionTV = findViewById(R.id.questionTV);
        generateQuestion();
    }

    public void buttonTapped(View view) {
        // Log.d(LOG_TAG, "Left Button is Tapped");
        Button btn = (Button) view;
        TextView scoreTV = findViewById(R.id.scoreTV);
        if (btn.getId() == R.id.leftBtn) {
            if (isrightAnswer) {
                score--;
                toast("Wrong");

            } else {
                score++;
                toast("Right");
            }



        } else {
            if (isrightAnswer) {
                score++;
                toast("Right");

            } else {
                score--;
                toast("Wrong");
            }


        }
        scoreTV.setText("Score: " + score);
        generateQuestion();
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

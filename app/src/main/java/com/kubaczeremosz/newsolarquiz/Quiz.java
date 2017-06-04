package com.kubaczeremosz.newsolarquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    private int currentQuestion=MainMenu.variables.getCurrentQuestion();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (MainMenu.variables.getCurrentQuestion() % 3 == 1 || MainMenu.variables.getCurrentQuestion() == 1) {
            setContentView(R.layout.activity_quiz_one_correct);
        }
        if (MainMenu.variables.getCurrentQuestion() % 3 == 2 || MainMenu.variables.getCurrentQuestion() == 2) {
            setContentView(R.layout.activity_quiz_three_correct);
        }
        if (MainMenu.variables.getCurrentQuestion() % 3 == 0 || MainMenu.variables.getCurrentQuestion() == 3) {
            setContentView(R.layout.activity_quiz_write_down);
        }


        MainMenu.variables.setCurrentQuestionText(MainMenu.questions.get(currentQuestion - 1));
        //Setting current question
        final TextView questionNumber = (TextView) findViewById(R.id.questionNumber);
        questionNumber.setText("" + currentQuestion);
        final TextView questionText = (TextView) findViewById(R.id.questionTXT);
        questionText.setText(MainMenu.variables.getCurrentQuestionText());
        final TextView numberOfQuestions = (TextView) findViewById(R.id.numberOfQuestions);
        numberOfQuestions.setText("/  " + MainMenu.questions.size());

        // Setting "answer" button logic
        final Button nextRound = (Button) findViewById(R.id.nextRound);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainMenu.variables.setCurrentQuestion(currentQuestion+1);
                Intent intent = new Intent(Quiz.this, Quiz.class);
                startActivity(intent);
            }
        });
    }

}

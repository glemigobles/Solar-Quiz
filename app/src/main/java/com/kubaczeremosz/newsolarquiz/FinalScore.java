package com.kubaczeremosz.newsolarquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        int numberOfQuestions=getIntent().getIntExtra("QUESTIONS", MainMenu.questions.size());
        int points = getIntent().getIntExtra("POINTS", MainMenu.variables.points);
        String playerName= getIntent().getStringExtra("NAME");

        TextView name = (TextView) findViewById(R.id.playerName);
        name.setText(playerName+"!");

        TextView score = (TextView) findViewById(R.id.score);
        score.setText("" + points);

        TextView scorePercent = (TextView) findViewById(R.id.scorePercent);
        scorePercent.setText(setScorePercent(points,numberOfQuestions) + " %");

        TextView congrats = (TextView) findViewById(R.id.congrats);

        MainMenu.variables.getCurrentQuestion();

        if (setScorePercent(points,numberOfQuestions) > 50) {
            congrats.setText("Congratulation! your score is :");
            if (setScorePercent(points,numberOfQuestions) == 100) {
                congrats.setText("Perfect!!! your score is :");
            }
        } else {
            congrats.setText("It Could  be better! your score is :");
        }

        final Button nextRound = (Button) findViewById(R.id.nextRound);

        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearing lists
                for (int i = 0; i < MainMenu.globalAnswerList.size(); i++) {
                    MainMenu.globalAnswerList.get(i).PlayerAnswer1 = null;
                    MainMenu.globalAnswerList.get(i).PlayerAnswer2 = null;
                    MainMenu.globalAnswerList.get(i).PlayerAnswer3 = null;
                }
                MainMenu.globalAnswerList.clear();
                MainMenu.questions.clear();
                //quit to main
                Intent intent = new Intent(FinalScore.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
    public int setScorePercent(int points, int questionsNumber) {
        if (questionsNumber != 0) {
            double score = ((double) points / (double) questionsNumber) * 100;
            return (int) score;
        } else {
            return 0;
        }
    }
}

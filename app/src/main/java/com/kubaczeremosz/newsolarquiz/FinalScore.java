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

        TextView score = (TextView) findViewById(R.id.score);
        score.setText("" + MainMenu.variables.points);

        TextView scorePercent = (TextView) findViewById(R.id.scorePercent);
        scorePercent.setText(MainMenu.variables.setScorePercent() + " %");

        TextView congrats = (TextView) findViewById(R.id.congrats);

        if (MainMenu.variables.setScorePercent() > 50) {
            congrats.setText("Congratulation! your score is :");
            if (MainMenu.variables.setScorePercent() == 100) {
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
}

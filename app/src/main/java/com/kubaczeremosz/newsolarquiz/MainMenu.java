package com.kubaczeremosz.newsolarquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainMenu extends AppCompatActivity {

    private static final String STATE_NAME = "name";
    private String name;

    //declaring new static VariableContainer object
    public static VariableContainer variables = new VariableContainer();

    //static list of questions <String>
    static public ArrayList<String> questions = new ArrayList<String>();

    //static list of answer objects <Answers>
    static public ArrayList<Answers> globalAnswerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        if (savedInstanceState != null) {
            name = savedInstanceState.getString(STATE_NAME);
            final EditText playername = (EditText) findViewById(R.id.playerName);
            playername.setText(name);

        }

        variables.points = 0;
        variables.addQuestions(questions);
        variables.addAnswers(globalAnswerList);

        //edit text field
        final EditText playername = (EditText) findViewById(R.id.playerName);

        //button "start quiz"
        Button start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                variables.setPlayerName(playername.getText().toString());

                if (TextUtils.isEmpty(variables.getPlayerName())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Type Player name first!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    variables.setCurrentQuestion(1);
                    Intent intent = new Intent(MainMenu.this, Quiz.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_NAME, name);
    }

}

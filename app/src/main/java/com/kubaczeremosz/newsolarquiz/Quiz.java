package com.kubaczeremosz.newsolarquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private int currentQuestion = MainMenu.variables.getCurrentQuestion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (MainMenu.variables.getCurrentQuestion() % 3 == 1 || MainMenu.variables.getCurrentQuestion() == 1) {
            setContentView(R.layout.activity_quiz_one_correct);

            //setting answers to radio buttons
            final RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton1);
            final RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
            final RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);

            radio1.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(0));
            radio2.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(1));
            radio3.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(2));
        }
        if (MainMenu.variables.getCurrentQuestion() % 3 == 2 || MainMenu.variables.getCurrentQuestion() == 2) {
            setContentView(R.layout.activity_quiz_three_correct);

            //setting answers to checkBoxes
            CheckBox box1 = (CheckBox) findViewById(R.id.checkBox1);
            CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
            CheckBox box3 = (CheckBox) findViewById(R.id.checkBox3);
            CheckBox box4 = (CheckBox) findViewById(R.id.checkBox4);
            CheckBox box5 = (CheckBox) findViewById(R.id.checkBox5);
            CheckBox box6 = (CheckBox) findViewById(R.id.checkBox6);

            box1.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(0));
            box2.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(1));
            box3.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(2));
            box4.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(3));
            box5.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(4));
            box6.setText(MainMenu.globalAnswerList.get(currentQuestion - 1).answerList.get(5));
        }
        if (MainMenu.variables.getCurrentQuestion() % 3 == 0 || MainMenu.variables.getCurrentQuestion() == 3) {
            setContentView(R.layout.activity_quiz_write_down);
        }

        //Setting current question
        MainMenu.variables.setCurrentQuestionText(MainMenu.questions.get(currentQuestion - 1));
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

                // first checking Answer
                checkAnswer();
                //changing question if checked
                if (MainMenu.variables.questionChecked) {
                    if (currentQuestion == MainMenu.questions.size()) {
                                Intent intent = new Intent(Quiz.this, FinalScore.class);
                                intent.putExtra("POINTS",MainMenu.variables.points);
                                intent.putExtra("NAME",MainMenu.variables.getPlayerName());
                                intent.putExtra("QUESTIONS",MainMenu.questions.size());
                                startActivity(intent);
                    }
                    MainMenu.variables.setCurrentQuestion(currentQuestion + 1);
                    Intent intent = new Intent(Quiz.this, Quiz.class);
                    startActivity(intent);
                }

            }
        });
    }

    public void checkAnswer() {

        if (checkingAnswerType(1)) {
            getCheckedAnswer();

            //checking if answer is checked
            if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {

                MainMenu.variables.setQuestionChecked(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Check Your answer First! ", Toast.LENGTH_SHORT);
                toast.getGravity();
                toast.show();
            } else {
                //checking if answer is correct
                MainMenu.variables.setQuestionChecked(true);

                if ((MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1).equals(MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1)) {

                    MainMenu.variables.points++;
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    String message = "Incorrect Answer! You should check: " + MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1;
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
            }

        }

        if (checkingAnswerType(2)) {
            getCheckedAnswer();

            //checking if answers are checked
            if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null
                    || MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null
                    || MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {

                MainMenu.variables.setQuestionChecked(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Check 3 answers! ", Toast.LENGTH_SHORT);
                toast.getGravity();
                toast.show();
            } else {
                //checking if answers are correct
                MainMenu.variables.setQuestionChecked(true);

                if ((MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == (MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1)) &&
                        (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == (MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer2)) &&
                        (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == (MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer3))) {

                    MainMenu.variables.points++;
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    String message = "Incorrect Answer! You should check: " + MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1
                            + ", " + MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer2
                            + ", " + MainMenu.globalAnswerList.get(currentQuestion - 1).CorrectAnswer3;
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
            }

        }

        if (checkingAnswerType(3)) {
            getCheckedAnswer();

            //checking if answer is wrote
            if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1.equals("")) {

                MainMenu.variables.setQuestionChecked(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Write down Your answer! ", Toast.LENGTH_SHORT);
                toast.getGravity();
                toast.show();
            } else {
                //checking if answer is correct
                MainMenu.variables.setQuestionChecked(true);

                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1.equals(MainMenu.globalAnswerList.get(currentQuestion - 1).Answer1)) {
                    MainMenu.variables.points++;
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    String message = "Incorrect Answer! You should write down: " + MainMenu.globalAnswerList.get(currentQuestion - 1).Answer1;
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
            }

        }


    }

    public void getCheckedAnswer() {

        if (MainMenu.variables.getCurrentQuestion() % 3 == 1 || MainMenu.variables.getCurrentQuestion() == 1) {

            final RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton1);
            final RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
            final RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);

            if (radio1.isChecked()) {
                MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = radio1.getText().toString();
            }
            if (radio2.isChecked()) {
                MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = radio2.getText().toString();
            }
            if (radio3.isChecked()) {
                MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = radio3.getText().toString();
            }
        }
        if (MainMenu.variables.getCurrentQuestion() % 3 == 2 || MainMenu.variables.getCurrentQuestion() == 2) {

            CheckBox box1 = (CheckBox) findViewById(R.id.checkBox1);
            CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
            CheckBox box3 = (CheckBox) findViewById(R.id.checkBox3);
            CheckBox box4 = (CheckBox) findViewById(R.id.checkBox4);
            CheckBox box5 = (CheckBox) findViewById(R.id.checkBox5);
            CheckBox box6 = (CheckBox) findViewById(R.id.checkBox6);


            if (box1.isChecked()) {
                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box1.getText().toString();

                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box1.getText().toString();
                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box1.getText().toString();
                }
            }
            if (box2.isChecked()) {
                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box2.getText().toString();

                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box2.getText().toString();
                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box2.getText().toString();
                }
            }
            if (box3.isChecked()) {
                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box3.getText().toString();

                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box3.getText().toString();
                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box3.getText().toString();
                }
            }
            if (box4.isChecked()) {
                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box4.getText().toString();

                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box4.getText().toString();
                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box4.getText().toString();
                }
            }
            if (box5.isChecked()) {
                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box5.getText().toString();

                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box5.getText().toString();
                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box5.getText().toString();
                }
            }
            if (box6.isChecked()) {
                if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box6.getText().toString();

                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box6.getText().toString();
                } else if (MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {
                    MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box6.getText().toString();
                }
            }
        }
        if (MainMenu.variables.getCurrentQuestion() % 3 == 0 || MainMenu.variables.getCurrentQuestion() == 3) {

            int currentQuestion = MainMenu.variables.getCurrentQuestion();
            EditText text = (EditText) findViewById(R.id.writeDown);
            String answer = text.getText().toString();
            MainMenu.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = answer;
        }
    }
    boolean checkingAnswerType(int type) {

        if (type == currentQuestion || (currentQuestion - type) % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

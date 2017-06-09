package com.kubaczeremosz.newsolarquiz;

import java.util.ArrayList;

public class Answers {
    String Answer1;
    String Answer2;
    String Answer3;
    String Answer4;
    String Answer5;
    String Answer6;
    String CorrectAnswer1;
    String CorrectAnswer2;
    String CorrectAnswer3;
    String PlayerAnswer1;
    String PlayerAnswer2;
    String PlayerAnswer3;

    ArrayList<String> answerList = new ArrayList<>();

    //3 types of constructors of Answer object

    public Answers(String answer1, String answer2, String answer3, String correctAnswer1) {
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        CorrectAnswer1 = correctAnswer1;
        answerList.add(0, this.Answer1);
        answerList.add(1, this.Answer2);
        answerList.add(2, this.Answer3);
    }

    public Answers(String answer1) {
        Answer1 = answer1;
        answerList.add(0, this.Answer1);
    }

    public Answers(String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String correctAnswer1, String correctAnswer2, String correctAnswer3) {
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        Answer4 = answer4;
        Answer5 = answer5;
        Answer6 = answer6;
        CorrectAnswer1 = correctAnswer1;
        CorrectAnswer2 = correctAnswer2;
        CorrectAnswer3 = correctAnswer3;
        answerList.add(0, this.Answer1);
        answerList.add(1, this.Answer2);
        answerList.add(2, this.Answer3);
        answerList.add(3, this.Answer4);
        answerList.add(4, this.Answer5);
        answerList.add(5, this.Answer6);
    }
}

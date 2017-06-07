package com.kubaczeremosz.newsolarquiz;

import java.util.ArrayList;

public class VariableContainer {

    String playerName;
    int currentQuestion;
    String currentQuestionText;
    int points = 0;
    boolean questionChecked;

    //Questions
    void addQuestions(ArrayList list) {
        list.add(0, "Which one is the biggest natural satellite of Jupiter: ");
        list.add(1, "Three brightest planets on Earth sky are:");
        list.add(2, "Smallest Planet in Solar System is:");
        list.add(3, "How long is distance from Sun to Earth?");
        list.add(4, "Check three natural satellites of Saturn");
        list.add(5, "Write year of first human landing on Moon");
        list.add(6, "Which planet of Solar System is called 'Earth Twin'? ");
    }

    //Answers (in order : Radio, Checkbox, EditText....)
    static Answers answers1 = new Answers("Ganymede", "Moon", "Kalypso", "Ganymede");
    static Answers answers2 = new Answers("Saturn", "Mars", "Jupiter", "Mercury", "Venus", "Pluto", "Mars", "Jupiter", "Venus");
    static Answers answers3 = new Answers("Mercury");
    static Answers answers4 = new Answers("10 light seconds", "8 light minutes", "48 light seconds", "8 light minutes");
    static Answers answers5 = new Answers("Titan", "Europa", "Kalypso", "Rea", "Japet", "Oberon", "Titan", "Rea", "Japet");
    static Answers answers6 = new Answers("1969");
    static Answers answers7 = new Answers("Mars", "Mercury", "Venus", "Venus");

    void addAnswers(ArrayList list) {
        list.add(0, answers1);
        list.add(1, answers2);
        list.add(2, answers3);
        list.add(3, answers4);
        list.add(4, answers5);
        list.add(5, answers6);
        list.add(6, answers7);
    }

    public String getCurrentQuestionText() {
        return currentQuestionText;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void setCurrentQuestionText(String currentQuestionText) {
        this.currentQuestionText = currentQuestionText;
    }

    public void setQuestionChecked(boolean questionChecked) {
        this.questionChecked = questionChecked;
    }

    public int setScorePercent() {
        if (MainMenu.questions.size() != 0) {
            double score = ((double) points / (double) MainMenu.questions.size()) * 100;
            return (int) score;
        } else {
            return 0;
        }
    }

}

package me.lusy.mathdragon;

import java.util.Arrays;

public class MathsGame {

    private NumberGenerator question = new NumberGenerator("add");
    private int[] answers;
    private int correctAnswers = 0;
    private int questionsAnswered = 0;

    public MathsGame() {
        answers = new int[]{question.getAnswer(), question.getIncorrectA(), question.getIncorrectB()};
        Arrays.sort(answers);
    }

    public String getQuestion() {
        return "What is " + question.getNumberA() + " + " + question.getSecondNumber() + "?";
    }

    public String correctAnswer(String selection) {
        //Marks question as marked
        questionsAnswered++;
        if (Integer.parseInt(selection) == question.getAnswer()) {
            //Marks questions as correct and advises user that their answer was right
            correctAnswers++;
            return "Yes, that's correct!";
        } else {
            //Advises user of correct answer
            return "Sorry, but the answer was " + question.getAnswer();
        }
    }

    public String answerAsString(int answerNo) {
        return "" + answers[answerNo];
    }


/***********************************
 GETTERS
 *******************************/

    public String getQuestionsAnswered() { return "" + questionsAnswered; }

    public String getcorrectAnswers() { return "" + correctAnswers; }

}


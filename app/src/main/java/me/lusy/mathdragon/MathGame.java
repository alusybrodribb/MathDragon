package me.lusy.mathdragon;

import java.util.Arrays;
import java.util.Random;

public class MathGame {

    private NumberGenerator question = new NumberGenerator("add");
    private int[] answers;
    private int correctAnswers = 0;
    private int questionsAnswered = 0;

    public void run() {
        //Randomly selects between addition, subtraction, multiplication and division questions,
        // then uses number generator to generate base nos for question, correct answer and two incorrect answers
        Random random = new Random();
        int questionType = random.nextInt(4);
        switch(questionType) {
            case 0:
                question = new NumberGenerator("add");
                break;
            case 1:
                question = new NumberGenerator("sub");
                break;
            case 2:
                question = new NumberGenerator("mul");
                break;
            case 3:
                question = new NumberGenerator("div");
                break;
        }
        answers = new int[]{question.getAnswer(), question.getIncorrectA(), question.getIncorrectB()};
        Arrays.sort(answers);
    }

    public String getQuestion() {
        //Generates questions based on numbers generated
        return "What is " + question.getFirstNumber() + " " + question.getFunction() + " " + question.getSecondNumber() + "?";
    }


    public String correctAnswer(String selection) {
        //Marks question as answered
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

/***********************************
 GETTERS
 *******************************/


    public String answerAsString(int answerNo) {
    return "" + answers[answerNo];
}

    public String getQuestionsAnswered() { return "" + questionsAnswered; }

    public String getCorrectAnswers() { return "" + correctAnswers; }


}


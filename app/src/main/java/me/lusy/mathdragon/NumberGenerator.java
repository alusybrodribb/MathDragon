package me.lusy.mathdragon;

import java.util.Random;

public class NumberGenerator {


    Random random = new Random();
    private int numberA;
    private int numberB;
    private int sum;
    private int product = numberA * numberB;
    private int incorrectA;
    private int incorrectB;
    private int answer;
    private int secondNumber;

    public NumberGenerator(String questionType) {
        //includes code for future improvements where app includes subtraction, multiplication and division questions

        switch (questionType) {
            case "add":
                addSubNumbers();
                firstIncorrect(sum);
                secondIncorrect(sum);
                answer = sum;
                secondNumber = numberB;
                break;
            case "sub":
                addSubNumbers();
                firstIncorrect(numberB);
                secondIncorrect(numberB);
                answer = numberB;
                secondNumber = sum;
                break;
            case "mult":
                multDivNumbers();
                firstIncorrect(product);
                secondIncorrect(product);
                answer = product;
                secondNumber = numberB;
                break;
            case "div":
                multDivNumbers();
                firstIncorrect(numberB);
                secondIncorrect(numberB);
                answer = numberB;
                secondNumber = product;
        }
    }

    private void addSubNumbers() {
        //Creates two random numbers to use as base for addition & subtraction questions
        numberA = random.nextInt(100)+1;
        numberB = random.nextInt(100)+1;
        sum = numberA + numberB;
    }

    private void multDivNumbers() {
        //Creates two random numbers to use as base for multiplication & division questions
        //Numbers are from 1-12 so users are only practicing up to their 12 times tables
        numberA = random.nextInt(12)+1;
        numberB = random.nextInt(12)+1;
        product = numberA * numberB;
    }


    public int incorrectDifferenceGenerator(int answer) {
        //Generates two random incorrect numbers taht
        int difference;
        if (answer > 10) {
            difference = random.nextInt(5) + 1;
        } else {
            difference = random.nextInt(3) + 1;
        }
        boolean positive = random.nextBoolean();
        if (positive) {
            return difference;
        } else {
            difference = -difference;
            return difference;
        }
    }

    public void firstIncorrect(int answer) {
        //Generates first incorrect guess within range of correct number
        int difference = incorrectDifferenceGenerator(answer);
        incorrectA = answer + difference;
    }

    public void secondIncorrect(int answer) {
        //generates second incorrect guess within range of either correct number or 1st incorrect guess
        //This means correct answer is (almost) equally likely to be the lowest, middle or highest number provided
        int difference = incorrectDifferenceGenerator(answer);
        int baseNumber = random.nextInt(3);
        if (baseNumber == 0) {
            incorrectB = answer + difference;
        } else {
            incorrectB = incorrectA + difference;
            if (incorrectB == answer) {
                incorrectB += 1;
            }
        }
    }

    /***********************************
    GETTERS
     *********************************/

    public int getNumberA() {
        return numberA;
    }

    public int getSecondNumber() {return secondNumber; }

    public int getAnswer() {
        return answer;
    }


    public int getIncorrectA() {
        return incorrectA;
    }

    public int getIncorrectB() {
        return incorrectB;
    }

}

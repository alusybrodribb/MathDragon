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
    private int firstNumber;
    private int secondNumber;
    private String function;

    public NumberGenerator(String questionType) {
        //Generates numbers for addition, multiplication, subtraction and division questions
        switch (questionType) {
            case "add":
                addSubNumbers();
                firstIncorrect(sum);
                secondIncorrect(sum);
                answer = sum;
                firstNumber = numberA;
                secondNumber = numberB;
                function = "+";
                break;
            case "sub":
                addSubNumbers();
                firstIncorrect(numberB);
                secondIncorrect(numberB);
                answer = numberB;
                firstNumber = sum;
                secondNumber = numberA;
                function = "-";
                break;
            case "mul":
                multDivNumbers();
                firstIncorrect(product);
                secondIncorrect(product);
                answer = product;
                firstNumber = numberA;
                secondNumber = numberB;
                function = "x";
                break;
            case "div":
                multDivNumbers();
                firstIncorrect(numberB);
                secondIncorrect(numberB);
                answer = numberA;
                firstNumber = product;
                secondNumber = numberB;
                function = "/";
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
        //generates second incorrect guess within range of either correct number (2/3 chance) or 1st incorrect guess (1/3 chance)
        //This means correct answer is (almost) equally likely to be the lowest, middle or highest number provided
        do {
            int difference = incorrectDifferenceGenerator(answer);
            int baseNumber = random.nextInt(3);
            if (baseNumber == 0) {
                incorrectB = incorrectA + difference;
            } else {
                incorrectB = answer + difference;

            }
        } while (incorrectB == incorrectA || incorrectB == answer);
    }

    /***********************************
    GETTERS
     *********************************/

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {return secondNumber; }

    public int getAnswer() {
        return answer;
    }

    public String getFunction() { return function; }

    public int getIncorrectA() {
        return incorrectA;
    }

    public int getIncorrectB() {
        return incorrectB;
    }

}

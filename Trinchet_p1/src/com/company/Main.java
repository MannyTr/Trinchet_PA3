package com.company;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    private static final int ERROR = -10000000;

    public static void correctAnswerOutput(int res){

        switch(res)
        {
            case 0:
            {
                System.out.println("Very good!\n");
                break;
            }
            case 1:
            {
                System.out.println("Awesome!\n");
                break;
            }
            case 2:
            {
                System.out.println("Good job!\n");
                break;
            }
            case 3:
            {
                System.out.println("Keep up the great work!\n");
                break;
            }
        }


    }

    public static void wrongAnswerOutput(int res){

        switch(res)
        {
            case 0:
            {
                System.out.println("Incorrect, please try again.\n");
                break;
            }
            case 1:
            {
                System.out.println("Wrong, try again.\n");
                break;
            }
            case 2:
            {
                System.out.println("Don't give up!\n");
                break;
            }
            case 3:
            {
                System.out.println("No, keep trying!\n");
                break;
            }
        }

    }

    public static int MultQuestion(Scanner s, int x, int y){
        double userAnswer;
        int output;
        SecureRandom rand = new SecureRandom();
        output = rand.nextInt(4);

        System.out.printf("How much is %d times %d?\n > ", x, y);
        userAnswer = s.nextDouble();

        if (isEquals(userAnswer, (x * y)))
        {
            correctAnswerOutput(output);
            return 1;
        }
        else
        {
            wrongAnswerOutput(output);
            return 0;
        }
    }

    public static int AddQuestion(Scanner s, int x, int y){
        double userAnswer;
        int output;
        SecureRandom rand = new SecureRandom();
        output = rand.nextInt(4);

        System.out.printf("How much is %d plus %d?\n > ", x, y);
        userAnswer = s.nextDouble();

        if (isEquals(userAnswer, (x + y)))
        {
            correctAnswerOutput(output);
            return 1;
        }
        else
        {
            wrongAnswerOutput(output);
            return 0;
        }
    }

    public static int SubtQuestion(Scanner s, int x, int y){
        double userAnswer;
        int output;
        SecureRandom rand = new SecureRandom();
        output = rand.nextInt(4);

        System.out.printf("How much is %d minus %d?\n > ", x, y);
        userAnswer = s.nextDouble();

        if (isEquals(userAnswer, (x - y)))
        {
            correctAnswerOutput(output);
            return 1;
        }
        else
        {
            wrongAnswerOutput(output);
            return 0;
        }
    }

    public static int DivQuestion(Scanner s, int x, int y, int diff){
        double userAnswer;
        int output;
        SecureRandom rand = new SecureRandom();
        output = rand.nextInt(4);

        while (y == 0)
        {
            x = getRandom(diff);
            y = getRandom(diff);
        }

        System.out.printf("How much is %d divided by %d?\n > ", x, y);
        userAnswer = s.nextDouble();

        if (isEquals(userAnswer, ((double)x / y)))
        {
            correctAnswerOutput(output);
            return 1;
        }
        else
        {
            wrongAnswerOutput(output);
            return 0;
        }

    }

    public static int WildCardQuestion(Scanner s, int x, int y, int diff){
        int res;
        SecureRandom rand = new SecureRandom();

        res = rand.nextInt(4) + 1;

        switch (res)
        {
            case 1:
            {
                return AddQuestion(s, x, y);
            }

            case 2:
            {
                return MultQuestion(s, x, y);
            }

            case 3:
            {
                return SubtQuestion(s, x, y);
            }

            case 4:
            {
                return DivQuestion(s, x, y, diff);
            }

            default:
            {
                System.out.println("Something went wrong, please try again!");
                return ERROR;
            }
        }
    }

    public static int Question (Scanner s, int x, int y, int arith, int diff){

        switch (arith)
        {
            case 1:
            {
                return AddQuestion(s, x, y);
            }

            case 2:
            {
                return MultQuestion(s, x, y);
            }

            case 3:
            {
                return SubtQuestion(s, x, y);
            }

            case 4:
            {
                return DivQuestion(s, x, y, diff);
            }

            case 5:
            {
                return WildCardQuestion(s, x, y, diff);
            }

            default:
            {
                System.out.println("Something went wrong, please try again!");
                return ERROR;
            }
        }
    }

    public static boolean isEquals (double x, double y){
        boolean res;

        if (Math.abs(x - y) < 0.01)
            res = true;
        else
            res = false;

        return res;
    }

    public static int getRandom (int x){
        int res = 0;
        SecureRandom rand = new SecureRandom();

        switch (x)
        {
            case 1:
            {
                res = rand.nextInt(10);
                break;
            }

            case 2:
            {
                res = rand.nextInt(100);
                break;
            }

            case 3:
            {
                res = rand.nextInt(1000);
                break;
            }
            case 4:
            {
                res = rand.nextInt(10000);
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2, diff, arith;
        double total = 0.0;

        System.out.print("Please enter difficulty level from 1-4\n >");
        diff = s.nextInt();

        while (diff > 4 || diff < 1)
        {
            System.out.print("Invalid entry, please try again\n >");
            diff = s.nextInt();
        }

        System.out.println("Please enter type of arithmetic problem to study:");
        System.out.println("1 - Addition only");
        System.out.println("2 - Multiplication only");
        System.out.println("3 - Subtraction only");
        System.out.println("4 - Division only (Round to the second digit for these!)");
        System.out.print("5 - A mix of all of these types\n >");
        arith = s.nextInt();

        while (arith > 5 || arith < 1)
        {
            System.out.print("Invalid entry, please try again\n >");
            arith = s.nextInt();
        }

        for (int i = 0; i < 10; i++)
        {
            num1 = getRandom(diff);
            num2 = getRandom(diff);
            System.out.printf("Question %d:\n", i + 1);
            total += Question(s, num1, num2, arith, diff);
        }

        System.out.println("Your score was " + (total / 10) * 100 + "%");
        if ((total / 10) >= .75)
            System.out.println("Congratulations, you can move on to the next level!");
        else
            System.out.println("Please ask your teacher for extra help");
    }
}

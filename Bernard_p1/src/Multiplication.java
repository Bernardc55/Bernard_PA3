import java.security.*;
import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args){
        //declaring all variables needed
        Scanner scnr = new Scanner(System.in);
        final int count = 10;
        int difficulty, numRight, numWrong, problemType;
        double input, ans, percentRight;
        boolean cont = true;
        //loops for all students
        while(cont){
            //resets the number of right and wrong answers
            numRight = 0;
            numWrong = 0;

            //obtains the users difficulty level
            do{
                System.out.println("Please choose a difficulty level (1-4)");
                difficulty = scnr.nextInt();
            }while(difficulty < 1 || difficulty > 4);

            //obtains the user's problem type
            do{
                System.out.println("Please choose a problem type to practice (1-5)");
                problemType = scnr.nextInt();
            }while(problemType < 1 || problemType > 5);

            //asks math questions count times, count is 10 by default
            for(int i = 0; i < count; i++){

                ans = question(difficulty, problemType);
                input = scnr.nextDouble();

                //finds if the answer is close enough to the input and records if it is right or wrong
                if(Math.abs(ans-input) < 0.0001){
                    positiveResponse();
                    numRight++;
                }
                else{
                    negativeResponse();
                    numWrong++;
                }
            }

            //finds the percent of right answers in decimal
            percentRight = (double)numRight/(double)count;

            System.out.println("You got " + numRight + " questions right and " + numWrong + " questions wrong!");
            //gives appropriate response
            if(percentRight > 0.75){
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            else{
                System.out.println("Please ask your teacher for extra help.");
            }
            System.out.println("Would you like to begin a new session? Press 1 for Yes, or anything else for No");
            input = scnr.nextInt();
            cont = input == 1;
        }


    }

    //Generates and asks a math question of a given difficulty and type, returns the answer to the question
    public static double question(int difficulty, int problemType){
        SecureRandom secRandGen = new SecureRandom();
        int num1 = 0, num2 = 0;

        //this tree creates the 2 numbers based on the given difficulty
        switch(difficulty) {
            case 1:
                num1 = secRandGen.nextInt(10);
                num2 = secRandGen.nextInt(10);
                break;
            case 2:
                num1 = secRandGen.nextInt(100);
                num2 = secRandGen.nextInt(100);
                break;
            case 3:
                num1 = secRandGen.nextInt(1000);
                num2 = secRandGen.nextInt(1000);
                break;
            case 4:
                num1 = secRandGen.nextInt(10000);
                num2 = secRandGen.nextInt(10000);
                break;
        }

        //this tree asks the type of question based on the provided information, if the given number is 5, it generates a number between 1-4 for this question
        while(true){
            switch(problemType){
                case 1:
                    System.out.println("How much is " + num1 + " plus " + num2 + "?");
                    return num1 + num2;
                case 2:
                    System.out.println("How much is " + num1 + " times " + num2 + "?");
                    return num1 * num2;
                case 3:
                    System.out.println("How much is " + num1 + " minus " + num2 + "?");
                    return num1 - num2;
                case 4:
                    System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                    return (double)num1 / (double)num2;
                default:
                    problemType = secRandGen.nextInt(4)+1;
            }
        }
    }

    //Generates a value between 1 and 4 and prints a positive response based on the generated number
    public static void positiveResponse(){
        SecureRandom secRandGen = new SecureRandom();
        int caseNum = secRandGen.nextInt(4) + 1;
        switch(caseNum){
            case 1:
                System.out.println("Very Good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
            default:
                System.out.println("Something broke, but you did great!");
                break;
        }
    }

    //Generates a value between 1 and 4 and prints a negative response based on the generated number
    public static void negativeResponse(){
        SecureRandom secRandGen = new SecureRandom();
        int caseNum = secRandGen.nextInt(4) + 1;
        switch(caseNum){
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don’t give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
            default:
                System.out.println("Something broke, and you're wrong");
                break;
        }
    }
}

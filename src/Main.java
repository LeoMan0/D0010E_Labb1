import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Getting input from the terminal
        Scanner chooseTaskToRun = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        int userInt;

        //Making
        while (true) {
            System.out.println("Enter what task to run");
            int taskToRun = chooseTaskToRun.nextInt();

            //Making so that the program only asks for an int if it needs one to run the task
            if (taskToRun==4 || taskToRun==6){
                userInt = 1;
            }
            else {
                System.out.println("enter the int");
                userInt = userInput.nextInt();
            }

            //Doing the stuff if the input is accepted
            if (userInt > 0){
                // Here is we print the stuff for task 1 and 2
                switch (taskToRun){
                    case 1:
                        runTask1(userInt);
                        break;
                    case 2:
                        runTask2(userInt);
                        break;
                    case 3:
                        runTask3(userInt);
                        break;
                    case 4:
                        runTask4or6(4);
                        break;
                    case 6:
                        runTask4or6(6);
                        break;
                    default:
                        System.out.println("Not a task can be run here");

                }

            }
            else if (userInt == 0) {
                System.out.println("Loop is closed zero was given");
                break;
            }
            else {
                userInput.nextLine();
                System.out.println("Is less then zero error");
            }

        }


    }



    public static void runTask1(int userInt) {
        System.out.println("Number out  for f1 is: " + f1(userInt));
    }

    public static void runTask2(int userInt){
        System.out.println("Number out  for f1 is: " + f1(userInt));
        System.out.println("Number our for f2 is: " + f2(userInt));
        System.out.println("Number out for f4 is: " + f4(userInt));
        System.out.println("Number out for f8 is: " + f8(userInt));
        System.out.println("Number out for f16 is: " + f16(userInt));
        System.out.println("Number out for f32 is: " + f32(userInt));
    }

    public static void runTask3(int userInt) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter amount of steps");
        int userSteps = userInput.nextInt();
        System.out.println("Number out is:" + iterateF(userSteps, userInt));
    }

    public static void runTask4or6(int taskToRun){

        for (int i=1; i <= 15; i++ ){
            if (taskToRun==4) {
                System.out.println(intsToString(i, iterLifeLength(i)));
            }
            else {
                System.out.println(intsToString(i, recLifeLength(i)));
            }
        }
    }


    //Task 1 method
    public static int f1(int numberIn){
        int numberOut;

        if (numberIn == 1){
            numberOut = 1;
        }
        else if (numberIn % 2 == 0){
            numberOut = numberIn/2;
        }
        else {
            numberOut = 3*numberIn + 1;
        }

        return numberOut;
    }



    //Task 2 methods:

    public static int f2(int a0) {
        // f2(a0) is equivalent to f1(f1(a0))
        return f1(f1(a0));
    }

    public static int f4(int a0) {
        // f4(a0) is equivalent to f2(f2(a0))
        return f2(f2(a0));
    }

    public static int f8(int a0) {
        // f8(a0) is equivalent to f4(f4(a0))
        return f4(f4(a0));
    }

    public static int f16(int a0) {
        // f16(a0) is equivalent to f8(f8(a0))
        return f8(f8(a0));
    }

    public static int f32(int a0) {
        // f32(a0) is equivalent to f16(f16(a0))
        return f16(f16(a0));
    }


    // Task 3 method
    public static int iterateF(int a0, int n){
        int iterateFOut = n;

        for (int i = 0; i < a0; i++){
            iterateFOut=f1(iterateFOut);

        }

        return iterateFOut;
    }



    //Task 4 method
    public static int iterLifeLength(int a0){
        int lifeLength=0;

        while (a0 != 1){
            a0 = f1(a0);
            lifeLength++;
        }
        return lifeLength;
    }

    public static String intsToString(int numberIn, int lifeLengthOfNumberIn){
        return ("The life length of " + numberIn + " is " + lifeLengthOfNumberIn + ".");

    }

    //Task 5 method
    public static int recLifeLength(int a0) {
        if (a0 == 1) {
            return 0; // Base case: life length of 1 is 0
        } else {
            return 1 + recLifeLength(f1(a0));
        }
    }

}
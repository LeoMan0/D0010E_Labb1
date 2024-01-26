import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Getting input from the terminal
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a int");

        //Making
        while (true) {

            int userInt=userInput.nextInt();


            //Doing the stuff if the input is accepted
            if (userInt > 0){
                // Here is we print the stuff for task 1 and 2
                System.out.println("Number in is:  " + userInt);
                System.out.println("Number out  for f1 is: " + f1(userInt));
                System.out.println("Number our for f2 is: " + f2(userInt));
                System.out.println("Number out for f4 is: " + f4(userInt));
                System.out.println("Number out for f8 is: " + f8(userInt));
                System.out.println("Number out for f16 is: " + f16(userInt));
                System.out.println("Number out for f32 is: " + f32(userInt));

                //Printing task 3 unclear what more to do
                System.out.println("Number out for iterateF(a4,userInt) is:" + iterateF(1, userInt));

                //Task 4 sout.
                System.out.println(intsToString(userInt, iterLifeLength(userInt)));


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

        //Task 4 part 3 AKA numbers from 1 to 15 prints
        for (int i=1; i <= 15; i++ ){
            System.out.println(intsToString(i,iterLifeLength(i)));
            System.out.println(intsToString(i,recLifeLength(i)));
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

    //Task 2 methods:as
    //Surely I did all this by hand.
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
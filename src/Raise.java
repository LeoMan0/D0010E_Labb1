public class Raise {
    // Here is the answer to task 10 in text.
    // The expontent why I did like one test and also thats just how math works I would kill myself (in game) if I had to calculate 2^100000 by hand
    // but if I had to do 100000^2 I would be fine.
    //graf bild
    // recRaiseOne n=k linear
    // recRaiseOne n = floor(log_2(k))+2



    public static void main(String[] args) {
        // Test the recRaiseHalf method
        double base = 1.0001;
        int exponent=4000;


        for (int i = 0; i < 15 ; i++) {
            numberOfCalls=0;
            System.out.println("Calls for recRaiseHalf("+ base + ", "+ (exponent + i) + ") = " + recRaiseHalf(base, exponent + i) + "is: " + numberOfCalls);
            numberOfCalls=0;
            System.out.println("Calls for recRaiseOne("+ base + ", "+ (exponent + i) + ") = " + recRaiseOne(base, exponent + i) + "is: " + numberOfCalls);

        }


    }

    static int numberOfCalls;
    //Here in this function we floor k/2 by using it as an int.
    public static double recRaiseHalf(double x, int k){
        numberOfCalls++;
        if (k == 0) {
            return 1;
        }
        else if(k % 2 == 0){
            double xHalf = recRaiseHalf(x, k/2);
            return xHalf * xHalf;
        }
        else {
            double xHalf = recRaiseHalf(x, k/2);
            return x * xHalf * xHalf;
        }
    }

    public static double recRaiseOne(double x, int k) {
        numberOfCalls++;
        if (k==0) {
            return 1.0;
        } else {
            return x * recRaiseOne (x, k-1);
        }
    }
}

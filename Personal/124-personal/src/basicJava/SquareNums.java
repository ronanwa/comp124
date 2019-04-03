package basicJava;
import java.util.Scanner;

public class SquareNums {
    public static void main(String[] arg) {
        double cog = calc();
        while(cog%4!=0){
            cog=calc();
        }
    }

    private static double calc(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a whole number:");
        int input = reader.nextInt();
        double x = Math.pow(input, 2);
        System.out.println(input + " squared equals " + x);
        return x;
    }
}

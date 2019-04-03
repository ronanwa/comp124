package basicJava;
import java.util.Scanner;

public class SentinelDrills {
    public static void main(String[] args){
        Scanner reader=new Scanner(System.in);
        System.out.println("Welcome to CompoundInterest!\n");
        System.out.println("What is your principal amount? ");
        double principal=reader.nextDouble();
        System.out.println("How many years will this account be actively compounding? ");
        double duration=reader.nextDouble();
        System.out.println("What is the interest rate?");
        double rate=reader.nextDouble();
        for(int i=1; i<=duration; i++){
            double futureAmount=principal*Math.pow(1+(rate/100.0),i);
            System.out.println("Your amount is "+futureAmount+" dollars.");
        }


    }
}

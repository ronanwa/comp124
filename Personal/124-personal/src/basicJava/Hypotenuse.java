package basicJava;

import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) {
        int sideA, sideB;
        double hypotenuse;
        Scanner scan = new Scanner(System.in);
        System.out.println("What are the two sides of the triangle?");
        sideA = scan.nextInt();
        sideB = scan.nextInt();
        hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        System.out.println("Hypotenuse: " + hypotenuse);
    }
}
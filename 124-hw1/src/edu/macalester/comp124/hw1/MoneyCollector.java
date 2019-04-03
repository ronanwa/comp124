package edu.macalester.comp124.hw1;
import java.util.Scanner;

public class MoneyCollector {
    public static void main(String[] arg){
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter an amount: ");
    float amount = reader.nextFloat();
    moneyCalculator(amount);
    }

    private static void moneyCalculator(float amount){

//      TEN DOLLAR BILLS
        float remainder = amount%10;
        int tBills=(int)(amount-remainder)/10;
        if (tBills==1){
            System.out.println(tBills+" ten dollar bill.");
        } else {
            System.out.println(tBills+" ten dollar bills.");
        }

//      FIVE DOLLAR BILLS
        float remainderTwo = remainder%5;
        int fBills = (int)(remainder-remainderTwo)/5;
        if (fBills==1){
            System.out.println(fBills+" five dollar bill.");
        } else {
            System.out.println(fBills+" five dollar bills.");
        }

//      ONE DOLLAR BILLS
        float remainderThree = remainderTwo%1;
        int oBills = (int)(remainderTwo-remainderThree)/1;
        if (oBills==1){
            System.out.println(oBills+" one dollar bill.");
        } else {
            System.out.println(oBills+" one dollar bills.");
        }

//      QUARTERS
        double remainderFour = remainderThree%.25;
        double quarters = (remainderThree-remainderFour)/.25;
        if (quarters==1){
            System.out.println((int)quarters+" quarter.");
        } else {
            System.out.println((int)quarters+" quarters.");
        }

//      DIMES
        double remainderFive = remainderFour%.1;
        double dimes = (remainderFour-remainderFive)/.1;
        if (dimes==1){
            System.out.println((int)dimes+" dime.");
        } else {
            System.out.println((int)dimes+" dimes.");
        }

//      NICKELS
        double remainderSix = remainderFive%.05;
        double nickels = (remainderFive-remainderSix)/.05;
        if (nickels>0){
            System.out.println((int)nickels+" nickel.");
        } else {
            System.out.println((int)nickels+" nickels.");
        }

//      PENNIES
        double remainderSeven = remainderSix%.01;
        if (remainderSeven<.01 && remainderSeven>.007) {
            double pennies = ((remainderSix - remainderSeven) / .01) + 1;
            if (pennies==1){
                System.out.println((int)pennies+" penny.");
            } else {
                System.out.println((int)pennies+" pennies.");
            }
        } else {
            double pennies = (remainderSix - remainderSeven)/.01;
            if (pennies==1){
                System.out.println((int)pennies+" penny.");
            } else {
                System.out.println((int)pennies+" pennies.");
            }

        }
    }
}


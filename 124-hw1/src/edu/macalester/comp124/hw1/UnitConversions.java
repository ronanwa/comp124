package edu.macalester.comp124.hw1;

import java.util.Scanner;

/**
 * Unit Conversions for humorous units of measurement.
 *
 * Original Author: Bret Jackson
 *
 * Acknowledgements:
 *   The Sheppy unit can be found on:
 *   https://en.wikipedia.org/wiki/List_of_humorous_units_of_measurement#Sheppey
 *
 *   The original idea for this assignment was by Paul Cantrell.
 *   Bret Jackson converted to the Sheppy, and Libby Shoop added this header.
 *
 */
public class UnitConversions {
    public static void main(String[] arg){
        Scanner reader = new Scanner(System.in);
        boolean answer=true;
        do {
//          SHEPPEYS & MILES
            System.out.println("Which unit would you like to convert?\n1: Sheppeys to miles\n2: Miles to sheppeys");
            int decision=reader.nextInt();
            if (decision==1){
                System.out.println("Enter a number of sheppeys to convert into miles: ");
                double sheppey = reader.nextDouble();
                System.out.println(sheppey+" sheppey(s) is equal to "+sheppeyToMiles(sheppey)+" mile(s).\n");
            } else if (decision==2){
                System.out.println("Enter a number of miles to convert into sheppeys: ");
                double mile = reader.nextDouble();
                System.out.println(mile+" mile(s) is equal to "+milesToSheppey(mile)+" sheppey(s).\n");
            } else {
                System.out.println("Oops, enter 1 or 2 next time.\n");
            }
//            Tried very hard to get the loop to work based on user's input :(2

//            System.out.println("Would you like to continue?\n1: Yes\n2: No");
//            String answerTwo = reader.next();
//            if (answerTwo=="y" || answerTwo=="Y" || answerTwo=="yes" || answerTwo=="Yes"){
//                boolean answer=true;
//            } else {
//                boolean answer=false;
//            }


//          FAHRENHEIT & CELSIUS
            System.out.println("Which unit would you like to convert?\n1: Fahrenheit to celsius\n2: Celsius to fahrenheit");
            int temperatureDecision=reader.nextInt();
            if (temperatureDecision==1){
                System.out.println("Enter a number of degree in fahrenheit to convert to celsius: ");
                double fahrenheit = reader.nextDouble();
                System.out.println(fahrenheit+" degree(s) fahrenheit converts to "+fahrenheitToCelsius(fahrenheit)+" degree(s) celsius.\n");
            } else if (temperatureDecision==2){
                System.out.println("Enter a number of degrees in celsius to convert to fahrenheit: ");
                double celsius = reader.nextDouble();
                System.out.println(celsius+" degree(s) celsius converts to "+celsiusToFahrenheit(celsius)+" degree(s) fahrenheit.\n");
            }else {
                System.out.println("Oops, enter 1 or 2 next time.\n");
            }

        } while (answer==true);


    }

//  SHEPPEY & MILES
    public static double sheppeyToMiles(double sheppey) {
        return sheppey*7/8;
    }

    public static double milesToSheppey(double miles) {
        return miles*8/7;
    }

//  FAHRENHEIT & CELSIUS
    public static double fahrenheitToCelsius(double fahrenheit){
        return ((fahrenheit-32)*5)/9;
    }

    public static double celsiusToFahrenheit(double celsius){
        return ((celsius*9)/5)+32;
    }
}

package stackActivity;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeUtils {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String choice, s, revS;
        do{
            System.out.print("Enter a phrase: ");
            s = reader.nextLine();
            revS = reverse(s);
            System.out.println(revS);
            if(isPalindromeReverse(s))
                System.out.println("Palindrome!");
            else
                System.out.println("Better luck next time");
            System.out.print("Go again? (y/n)");
            choice = reader.nextLine();
        } while (!choice.equals("n"));
    }

    public static boolean isPalindromeReverse(String phrase){
        String rev = reverse(phrase);
        if (rev.equals(phrase))
            return true;
        else
            return false;

    }

    public static String reverse(String phrase){
        // iterate through every character in the string
        // push each character onto the stack
        // create new string
        // pop character from stack and add to new string
        // return new string


        Stack<Character> stack = new Stack<Character>();
//        Student newStudent = new Student("Harry Potter", 1334568);
        for (int i=0; i<phrase.length(); i++){
            stack.push(phrase.charAt(i));
        }
        StringBuilder reversePhrase = new StringBuilder();
        for(int i=0; i<phrase.length();i++){
            reversePhrase.append(stack.pop());
        }

        return reversePhrase.toString();
    }

}

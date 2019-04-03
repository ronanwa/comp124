package basicJava;
import java.util.Scanner;

public class chessBoard {
    public static void main(String[] args){
        int row;
        String col;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter row: ");
        row=reader.nextInt();
        System.out.println("Enter column: ");
        col=reader.next();
        int column = col.charAt(0)-'a'+1; // convert from string to character to number to integer and add one for column
        System.out.println(column);
        if ((row+column)%2==0){
            System.out.println("Square is black");
        } else {
            System.out.println("Square is white");
        }


    }
}

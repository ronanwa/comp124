package arrayPractice;

import java.util.Scanner;

public class ArrayManipulation {

    private Scanner reader = new Scanner(System.in);
//    private int[] array1D = new int[10];
    private int n;
    private int[][] magicSquare;
    private int sum=0;

    public static void main(String[] args){
        ArrayManipulation example = new ArrayManipulation();
    }

    public ArrayManipulation(){
//        input10Ints();
//        int max = findMaxIndex();
//        int min = findMinIndex();
//        System.out.println("Min Value: " + array1D[min]);
//        System.out.println("Min Index: " + min);
//        System.out.println("Max Value: " + array1D[max]);
//        System.out.println("Max Index: " + max);
//        print1Darray();
//        swap(array1D[min],array1D[max]);
//        System.out.println("\n");
//        print1Darray();
        inputMagicSquare();

    }

    public void inputMagicSquare(){
        System.out.println("Enter a size for the magic square: ");
        n = reader.nextInt();
        magicSquare = new int[n][n];
        System.out.println("Enter "+n*n+" integers to populate the magic square.");
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++)
                magicSquare[i][j] = reader.nextInt();
        }
        checkMagicSquare();
        System.out.println("CHECK");
        printMagicSquare(magicSquare);
    }

    public void printMagicSquare(int[][] magicSquare){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                System.out.println(magicSquare[i][j]+" ");
            System.out.println();
        }
    }

    public void checkMagicSquare(){
        System.out.println("CHECK");
        int sum = 0;
        for(int i=0; i<magicSquare.length; i++){
            sum+=magicSquare[0][i]; //sum of first row
        }
        System.out.println("CHECK");
        if(checkRow() && checkCol() && checkDiag())
            System.out.println("You have a magic square!");
        else
            System.out.println("You do not have a magic square.");
    }

    public boolean checkRow(){
        int[] rowSum= new int[magicSquare.length-1];
        for(int i=1; i<magicSquare.length; i++){
            for(int j=0; j<magicSquare.length; i++){
                rowSum[i-1] += magicSquare[i][j]; //sums up row i
            }
        }
        for(int i=0; i<rowSum.length; i++){
            if(rowSum[i] != sum){
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(){
        int[] colSum= new int[magicSquare.length-1];
        for(int i=0; i<magicSquare.length; i++){
            for(int j=0; j<magicSquare.length; i++){
                colSum[i] += magicSquare[j][i]; //sums up row i
            }
        }
        for(int i=0; i<colSum.length; i++){
            if(colSum[i] != sum){
                return false;
            }
        }
        return true;
    }

    public boolean checkDiag(){
        int leftDiag=0, rightDiag=0;
        for(int i=0; i<magicSquare.length; i++){
            leftDiag += magicSquare[i][i];
            rightDiag += magicSquare[i][magicSquare.length-1-i];
        }
        if(leftDiag == sum && rightDiag == sum)
            return true;
        else
            return false;
    }




//    public void input10Ints(){
//        System.out.println("Enter 10 Integers: ");
//        for (int i=0; i<10; i++){
//            array1D[i] = reader.nextInt();
//        }
//    }
//
//    public int findMaxIndex(){
//        int maxIndex = 0;
//        for (int i=0; i<10; i++){
//            if (array1D[maxIndex] < array1D[i])
//                maxIndex = i;
//        }
//        return maxIndex;
//    }
//
//    public int findMinIndex(){
//        int minIndex = 0;
//        for (int i=0; i<10; i++){
//            if (array1D[minIndex] > array1D[i])
//                minIndex = i;
//        }
//        return minIndex;
//    }
//
//    public void swap(int min, int max){
//        int temp = array1D[max];
//        array1D[max] = array1D[min];
//        array1D[min] = temp;
//    }
//
//    public void print1Darray(){
//        for (int num: array1D)
//            System.out.println(num);
//    }

}

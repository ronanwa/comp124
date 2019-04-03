package basicJava;

public class TimeConverter {
    public static void main(String[] args){
        int hours, min, sec, total_sec;
        java.util.Scanner reader = new java.util.Scanner(System.in);
        System.out.println("Enter number of hours: ");
        hours = reader.nextInt();
        System.out.println("Enter number of minutes: ");
        min = reader.nextInt();
        System.out.println("Enter number of seconds: ");
        sec = reader.nextInt();
        total_sec = sec+60*min+3600*hours;
        System.out.println("Total seconds is: "+total_sec);
    }
}

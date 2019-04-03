package basicJava;

public class BasicStuff {
    public static void main(String[] args) {
        int age=18;
        System.out.println("I am "+age+"  years old!");
        double value=6/3;
        double value2=6/4;
        System.out.println("Value 1: "+value);
        System.out.println("Value 2: "+value2);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE);

        int hours=1600;
        System.out.println("Number of Hours: "+hours);
        int days=hours/24;
        System.out.println("Number of Days: "+days);
        int weeks=days/7;
        System.out.println("Number of Weeks: "+weeks);

        int h=5;
        int r=2;
        double area=Math.PI*Math.pow(r,2)*h/3;
        double volume=Math.PI*Math.pow(r,2)+Math.PI*r*Math.sqrt(Math.pow(r,2)+Math.pow(h,2));
        System.out.println("Surface Area: "+area);
        System.out.println("Volume: "+volume);



    }
}
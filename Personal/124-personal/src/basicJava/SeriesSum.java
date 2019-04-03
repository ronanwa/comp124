package basicJava;

public class SeriesSum {
    public static void main(String[] arg){
        double sum=0;
        for (double i=2;i<=10;i++){
            sum=sum+(1/i);
        }
        System.out.println("Sum: "+sum);
    }
}

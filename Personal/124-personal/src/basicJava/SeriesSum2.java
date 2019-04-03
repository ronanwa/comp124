package basicJava;

public class SeriesSum2 {
    public static void main(String[] arg){
        double x=0;
        double i=2;
        while (x<=2.0){
            x+=1/i;
            i+=1;
        }
        System.out.println("Made it when x equals "+x);
    }
}

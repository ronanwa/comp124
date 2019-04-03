package basicJava;

public class DoNDrills {
    public static void main(String[] args){
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
        System.out.println("First loop complete.");
        for(int i=0; i<11; i++){
            System.out.println(i);
        }
        System.out.println("Second loop complete.");
        for(int i=10; i>=0; i--){
            System.out.println(i);
        }
        System.out.println("Third loop complete.");
        int product=1;
        for(int i=32; i>=1;i/=2){
            System.out.println(i);
        }
        System.out.println("Fourth loop complete.");
        for(int i=1; i<=25; i++){
            System.out.println(Math.pow(i,2));
        }
        System.out.println("Fifth loop complete.");
    }
}

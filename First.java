import java.util.Random;
import java.util.Scanner;

public class First{
    public static void main (String[] args){
        int a = 0;
        int b = 8;
        double M = Math.cbrt(8);
        for (int n = 50; n <= 5000; n+=50){
            double srednia = 0;
            for (int k = 0; k < 50; k++){
                Points[] points = new Points[n];
                int ilePodWykresem = 0;
                Random random = new Random();
                for (int i = 0; i < n; i++){
                    points[i] = new Points(random.nextDouble()*(b - a) + a, random.nextDouble()*M);
                    if(points[i].y <= Math.cbrt(points[i].x)){
                        ilePodWykresem++;
                    }
                }
                double poleProstokata = (b-a)*M;
                double result = ilePodWykresem* poleProstokata/n;
                srednia += result;
            }
            srednia /= 50;
            System.out.println("dla n = " + n+ "mamy " + srednia);
        }
    }
}

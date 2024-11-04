import java.util.Random;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        int ilePodWykresem = 0;
        double a = 0.0;
        double b = Math.PI;
        double M = Math.sin(b/2);
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Ile puntków wygenerować?");
        int n = scanner.nextInt();
        Points points[] = new Points[n];
        for (int i = 0; i<n; i++){
            points[i] = new Points(rand.nextDouble()*b, rand.nextDouble()*M);
            if(points[i].y < Math.sin(points[i].x)){
                ilePodWykresem++;
            }
        }
        double poleProstokata = (b-a)*M;
        double result = ilePodWykresem*poleProstokata/n;
        System.out.println(result);
        scanner.close();
    }
}
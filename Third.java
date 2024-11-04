import java.util.Random;
import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        int ilePodWykresem = 0;
        double a = 0.0;
        double b = 1;
        double M = 27.0/64;
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Ile puntków wygenerować?");
        int n = scanner.nextInt();
        Points points[] = new Points[n];
        for (int i = 0; i<n; i++){
            points[i] = new Points(rand.nextDouble()*b, rand.nextDouble()*M);
            if(points[i].y < Math.pow((1-points[i].x), 3)*4*points[i].x){
                ilePodWykresem++;
            }
        }
        double poleProstokata = (b-a)*M;
        double result = ilePodWykresem*poleProstokata/n;
        System.out.println(result);
        scanner.close();
    }
}
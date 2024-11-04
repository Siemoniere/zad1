import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Points {
    double x;
    double y;

    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class First {
    public static void main(String[] args) {
        int a = 0;
        int b = 8;
        double M = Math.cbrt(8);
        StringBuilder csvData = new StringBuilder();
        csvData.append("n,Result,Type\n");

        for (int n = 50; n <= 5000; n += 50) {
            double srednia = 0;

            for (int k = 0; k < 50; k++) {
                Points[] points = new Points[n];
                int ilePodWykresem = 0;
                Random random = new Random();

                for (int i = 0; i < n; i++) {
                    points[i] = new Points(random.nextDouble() * (b - a) + a, random.nextDouble() * M);
                    if (points[i].y <= Math.cbrt(points[i].x)) {
                        ilePodWykresem++;
                    }
                }

                double poleProstokata = (b - a) * M;
                double result = ilePodWykresem * poleProstokata / n;
                srednia += result;

                // Zapisanie pojedynczego wyniku `result` dla każdej iteracji `k`
                csvData.append(n).append(",").append(result).append(",Single\n");
            }

            // Obliczenie średniej dla danego `n`
            srednia /= 50;
            // Zapisanie średniej jako oddzielny punkt
            csvData.append(n).append(",").append(srednia).append(",Average\n");

            System.out.println("dla n = " + n + " mamy średnią " + srednia);
        }

        // Zapis do pliku CSV
        try (FileWriter fileWriter = new FileWriter("monte_carlo_results_with_individuals.csv")) {
            fileWriter.write(csvData.toString());
            System.out.println("Wyniki zapisane do pliku monte_carlo_results_with_individuals.csv");
        } catch (IOException e) {
            System.out.println("Błąd przy zapisie do pliku CSV: " + e.getMessage());
        }
    }
}

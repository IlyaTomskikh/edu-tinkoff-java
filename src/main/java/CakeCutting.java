import java.util.Scanner;

public class CakeCutting {
    public static void main(String[] args) {
        System.out.printf("%.6f\n", cut());
    }

    private static double cut() {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort();
        double[] xs = new double[n], ys = new double[n];
        for (short i = 0; i < n; ++i) {
            xs[i] = scanner.nextShort();   //x_i
            ys[i] = scanner.nextShort();   //y_i
        }
        double sum = 0;
        for (short i = 0; i < n - 1; ++i) sum += xs[i] * ys[i + 1] - xs[i + 1] * ys[i];
        final double A = sum / 2;
        sum = 0;
        for (short i = 0; i < n - 1; ++i) sum += (xs[i] + xs[i + 1]) * (xs[i] * ys[i + 1] - xs[i + 1] * ys[i]);
        return sum / (6.0D * A);
    }
}

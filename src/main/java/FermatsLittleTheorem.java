import java.util.Scanner;

public class FermatsLittleTheorem {
    public static void main(String[] args) {
        System.out.println(countModSum());
    }

    private static long modInverse(long a, long mod) {
        long divident = 1L;
        while (divident % a != 0) divident += mod;
        return divident / a;
    }

    private static long countModSum() {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong(), r = scanner.nextLong(), p = scanner.nextLong(), sum = 0L;
        for (; l <= r; ++l) {
            sum += modInverse(l, p);
            while (sum >= p) sum -= p;
        }
        return sum;
    }
}

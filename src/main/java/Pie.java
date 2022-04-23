import java.util.Scanner;

public class Pie {
    public static void main(String[] args) {
        System.out.println(Cutting());
    }
    public static long Cutting() {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        long k = 0L;
        while (number != 0L) {
            number >>= k;
            ++k;
        }
        return k;
    }
}

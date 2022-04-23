import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class IncreaseSum {
    public static void main(String[] args) {
        System.out.println(count());
    }
    private static long power(int a, int pow) {
        switch (pow) {
            case 0: return 1;
            case 1: return a;
            default: return a * power(a, pow - 1);
        }
    }
    private static long profit(int number) {
        return power(10,("" + number).length() - 1) * ('9' - ("" + number).charAt(0));
    }
    private static void reverseArray(long[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            array[i] ^= array[array.length - 1 - i];
            array[array.length - 1 - i] ^= array[i];
            array[i] ^= array[array.length - 1 - i];
        }
    }
    public static long count() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; ++i) numbers[i] = scanner.nextInt();
        long[] profits = new long[n];
        for (int i = 0; i < n; ++i) profits[i] = profit(numbers[i]);
        Arrays.sort(profits);
        reverseArray(profits);
        return LongStream.of(profits).limit(k).sum();
    }
}

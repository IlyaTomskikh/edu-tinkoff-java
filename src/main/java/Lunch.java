import java.util.Scanner;

public class Lunch {
    public static void main(String[] args) {
        System.out.println(countPrice());
    }

    private static short findFirstMaxIx(short[] elements, short from) {
        short maxIx = from;
        ++from;
        for (short i = from; i < elements.length; ++i) if (elements[i] > elements[maxIx]) maxIx = i;
        return maxIx;
    }

    private static short countPrice() {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort();
        short[] prices = new short[n];
        for (int i = 0; i < n; ++i) prices[i] = scanner.nextShort();
        short fullPrice = 0, ticket = 0;
        for (short i = 0; i < n; ++i) {
            if (ticket >= 100) {
                ticket = 0;
                short ix = findFirstMaxIx(prices, i);
                prices[ix] = 0;
            }
            ticket += prices[i];
            fullPrice += prices[i];
        }

        return fullPrice;
    }
}

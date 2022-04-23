import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        System.out.println(countLadders());
    }
    private static int findMax(short[] shorts) {
        return shorts[shorts.length - 1];
    }
    private static int findMin(short[] shorts) {
        return shorts[0];
    }
    private static int minOfTwo(int a, int b) {
        return a < b ? a : b;
    }
    public static int countLadders() {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort(), t = scanner.nextShort();
        short[] employees = new short[n];
        for (int i = 0; i < n; ++i) employees[i] = scanner.nextShort();
        short highPriorIx = (short) (scanner.nextShort() - 1), highPrior = employees[highPriorIx];
        int max = findMax(employees), min = findMin(employees), dif = max - min;
        return t >= highPrior ? dif : minOfTwo(dif + max - highPrior, dif + highPrior - min);
    }
}
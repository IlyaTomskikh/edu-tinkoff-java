import java.util.Scanner;

public class PETask {
    public static void main(String[] args) {
        System.out.println(exchange());
    }

    private static String exchange() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; ++i) students[i] = scanner.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (students[i] % 2 != (i + 1) % 2 && answer.toString().equals("")) {
                for (int j = i + 1; j < n; ++j) {
                    if (students[j] % 2 != (j + 1) % 2 && i % 2 == j % 2) return "-1 -1";
                    if (students[j] % 2 != (j + 1) % 2 && i % 2 != j % 2 && answer.toString().equals("")) {
                        answer.append(i + 1).append(" ").append(j + 1);
                        students[i] ^= students[j];
                        students[j] ^= students[i];
                        students[i] ^= students[j];
                    }
                    else if (students[j] % 2 != (j + 1) % 2 && i % 2 != j % 2 && !answer.toString().equals("")) return "-1 -1";
                }
            }
            else if (students[i] % 2 != (i + 1) % 2 && !answer.toString().equals("")) return "-1 -1";
        }
        if (answer.toString().equals("")) return "-1 -1";
        return answer.toString();
    }
}

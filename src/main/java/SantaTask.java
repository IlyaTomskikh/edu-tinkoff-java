import java.util.Scanner;

public class SantaTask {
    public static void main(String[] args) {
        System.out.println(exchange());
    }

    private static String exchange() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] students = new int[n];    //студент i дарит подарок студенту students[i]
        for (int i = 0; i < n; ++i) students[i] = scanner.nextInt() - 1;
        int[] tab = new int[n]; //tab[i] -> число полученных подарков у студента students[i]
        for (int i = 0; i < n; ++i) ++tab[students[i]];
        int k = 0;
        while (k < n && k != students[k]) ++k;
        if (k == n) return "-1 -1";
        int p = 0;
        while (p < n && tab[p] != 0) ++p;
        if (p < n) students[k] = p;
        else return "-1 -1";
        int i = 0;
        while (i < n && i != students[i]) ++i;
        if (i == n) return (k + 1) + " " + (p + 1);
        return "-1 -1";
    }

}

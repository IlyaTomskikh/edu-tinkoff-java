import java.util.Scanner;

public class Mobile {
    public static void main(String[] args) {
        System.out.println(Spending());
    }

    public static short Spending() {
        var scanner = new Scanner(System.in);

        var values = new short[4];

        /*
         * values[0] == A - абонентская плата
         * values[1] == B - получает МБ интернета за А денег
         * values[2] == C - стоимость 1 МБ сверх тарифа
         * values[3] == D - сколько потратит МБ
         * */

        for (var i = 0; i < 4; ++i) values[i] = scanner.nextShort();
        if (values[3] <= values[1]) return values[0];
        values[0] += (values[3] - values[1]) * values[2];
        return values[0];
    }
}

import java.util.Scanner;

public class MeetingRoom {
    public static void main(String[] args) {
       System.out.println(matchingPoint());
    }

    private static String matchingPoint() {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble(), y = scanner.nextDouble();
        double[] plan = new double[8];
        int i = 0;
        while (i < 8) {
            //xs are in 0 - (0, 0), 2 - (X, 0), 4 - (X, Y), 6 - (0, Y)
            plan[i] = scanner.nextDouble(); //x_i
            ++i;
            //ys are in 1, 3, 5, 7
            plan[i] = scanner.nextDouble(); //y_i
            ++i;
        }
        double xMid = x / 2, yMid = y / 2;
        double lower = Math.sqrt(Math.pow(plan[2] - plan[0], 2) + Math.pow(plan[3] - plan[1], 2));
        double xMidPlan = lower / 2;
        double k = xMid / xMidPlan;
        double side = Math.sqrt(Math.pow(plan[5] - plan[3], 2) + Math.pow(plan[4] - plan[2], 2));
        double yMidPlan = side / 2;
        return "";
    }
}

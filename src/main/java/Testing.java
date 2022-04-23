import java.util.ArrayList;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        System.out.println(count());
    }
    private static ArrayList<Long> generate() {
        ArrayList<Long> nums = new ArrayList<>();
        int i = 0;
        for (; i < 9; ++i) nums.add((long) (i + 1));
        while(true) {
            nums.add(nums.get(i - 9) * 10 + nums.get(i % 9));
            if (nums.get(i) < 0) {
                nums.remove(i);
                break;
            }
            ++i;
        }
        return nums;
    }
    public static long count() {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong(), r = scanner.nextLong(), counter = 0L;
        ArrayList<Long> nums = generate();
        for (long num: nums) {
            if (num >= l && num <= r) ++counter;
            if (num > r) break;
        }
        return counter;
    }
}

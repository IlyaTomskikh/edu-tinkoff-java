import java.util.*;

public class Coins {
    public static void main(String[] args) {
        System.out.println(countSums());
    }

    private static HashMap<Long, HashMap<Long, Long>> getDP(Map<Long, Long> weights, long maxWeight, long lastAdded) {
        HashMap<Long, HashMap<Long, Long>> map = new HashMap<>();
        for (long i = 0L; i < lastAdded; ++i) {
            HashMap<Long, Long> tmp = new HashMap<>();
            for (long j = 0L; j < maxWeight + 1; ++j) tmp.put(j, 0L);
            map.put(i, tmp);
        }

        for (long k = 0L; k < lastAdded; ++k)
            for (long s = 0L; s <= maxWeight; ++s)
                if (k == 0L || s == 0L) map.get(k).put(s, 1L);
                else if (s >= weights.get(k - 1L))
                    map.get(k).put(s, Math.max(map.get(k - 1L).get(s), map.get(k - 1L).get(s - weights.get(k - 1L)) + weights.get(k - 1L)));
                else map.get(k).put(s, map.get(k - 1L).get(s));
        return map;
    }

    private static boolean match(HashMap<Long, Long> map, long val) {
        return map.containsValue(val);
    }

    private static long isSolvable(HashMap<Long, HashMap<Long, Long>> dp, long maxWeight, long lastAdded) {
        long res = 0L;
        Map<Long, Long> map = new HashMap<>();
        for (long i = 1L; i <= maxWeight; ++i) map.put(i, i);
        for (long i = 0L; i < lastAdded; ++i)
            for (long j = 1L; j <= maxWeight; ++j)
                if (match(dp.get(i), map.get(j))) {
                    ++res;
                    map.put(j, -1L);
                }
        return res;
    }

    private static long countSums() {
        //solve backpack problem maxWeight times (for 1..maxWeight)
        Scanner scanner = new Scanner(System.in);
        final long maxWeight = scanner.nextLong();
        long[] weights = new long[3];
        for (byte i = 0; i < 3; ++i) weights[i] = scanner.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        long[] counters = new long[3];
        for (byte i = 0; i < 3; ++i) counters[i] = maxWeight / weights[i];
        long ix = 0L;
        for (byte i = 0; i < 3; ++i)
            while (counters[i] >= 0) {
                map.put(ix, weights[i]);
                ++ix;
                --counters[i];
            }
        return isSolvable(getDP(map, maxWeight, ix), maxWeight, ix);
    }
}

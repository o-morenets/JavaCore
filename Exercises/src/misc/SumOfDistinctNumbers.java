package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 12.01.2026
 * Luxoft interview
 *
 * Input : A[] = {1, 5, 3, 8, 1}
 *         B[] = {5, 4, 6, 7}
 * Output : 28
 * 3 + 4 + 7 + 6 + 8 = 28
 *
 * Input : A[] = {1, 5, 3, 8}
 *         B[] = {5, 1, 8, 3}
 * Output : 0
 */
public class SumOfDistinctNumbers {

    static int sumOfDistinctNumbers(int[] a, int[] b) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : a) {
            Integer count = freq.get(num);
            if (count == null) count = 0;
            freq.put(num, count + 1);
        }

        for (int num : b) {
            Integer count = freq.get(num);
            if (count == null) count = 0;
            freq.put(num, count + 1);
        }

        return freq.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .sum();
    }

    static void main() {
        System.out.println(sumOfDistinctNumbers(new int[]{1, 5, 3, 8, 1}, new int[]{5, 4, 6, 7})); // 28
        System.out.println(sumOfDistinctNumbers(new int[]{1, 5, 3, 8}, new int[]{5, 1, 8, 3})); // 0
    }
}

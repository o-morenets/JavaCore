package misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Interview task
 * Luxoft
 * 30/04/2026 12:00 - 13:00
 */
public class Task {

    /**
     * An array contains numbers. Find the smallest duplicated number in the array. Write java method to find this duplicate.
     * The method should return the duplicated number
     * Example [2, 7, -5, 14, 7, 0, 14, 2, 3]
     * Returns: 2
     */
    private static Integer getSmallestDuplicate(int[] input) {
        // Write your code here

        Set<Integer> set = new HashSet<>();
        Integer minDuplicate = null;

        for (int num : input) {
            if (!set.add(num)) {
                if (minDuplicate == null || num < minDuplicate) {
                    minDuplicate = num;
                }
            }
        }

        return minDuplicate;
    }

    public static void main(String[] args) {
        int[] input = {8, 2, 7, -5, 14, 7, 0, 3};
        System.out.println(getSmallestDuplicate(input)); // 7

        input = new int[]{2, 7, -5, 14, 7, 0, 14, 2, 3};
        System.out.println(getSmallestDuplicate(input)); // 2
    }

}

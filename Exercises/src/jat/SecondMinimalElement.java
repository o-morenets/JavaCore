package jat;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SecondMinimalElement {

    public static void main(String[] args) {
        int[] nums = {2, 5, 2, 8, 1, 2, 9, 1};

        try {
            System.out.println("Second Minimal Element: " + findSecondMinimal(nums));
            System.out.println("Second Minimal Element: " + findSecondMinimal(new int[]{1, 1, 1, 1, 1}));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Second Minimal Element (Java 8): " + findSecondMinimalJava8(nums));
            System.out.println("Second Minimal Element (Java 8): " + findSecondMinimalJava8(new int[]{1, 1, 1, 1, 1}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int findSecondMinimal(int[] nums) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("Array should contain at least two elements");
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2 && num != min1) {
                min2 = num;
            }
        }

        if (min2 == Integer.MAX_VALUE) {
            throw new NoSuchElementException("Array has no second minimal element");
        }

        return min2;
    }

    private static int findSecondMinimalJava8(int[] nums) {
        return Arrays.stream(nums).distinct().sorted().skip(1).findFirst().orElseThrow(NoSuchElementException::new);
    }
}

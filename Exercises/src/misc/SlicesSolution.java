package misc;

public class SlicesSolution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, -1, 5, 4, -1, 6, 2, 3})); // 17 (correct)
    }

    public static int solution(int[] a) {
        if (a == null || a.length < 3) {
            throw new IllegalArgumentException();
        }
        if (a.length == 3) {
            return 0;
        }
        int[] max_sum_end = new int[a.length];
        for (int i = 1; i < a.length - 1; i++) {
            max_sum_end[i] = Math.max(0, max_sum_end[i - 1] + a[i]);
        }
        int[] max_sum_start = new int[a.length];
        for (int i = a.length - 2; i > 0; i--) {
            max_sum_start[i] = Math.max(0, max_sum_start[i + 1] + a[i]);
        }
        int maxValue = 0;
        for (int i = 1; i < a.length - 1; i++) {
            maxValue = Math.max(maxValue, max_sum_end[i - 1] + max_sum_start[i + 1]);
        }
        return maxValue;
    }
}

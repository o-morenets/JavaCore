package misc;

/**
 * 24.02.2026
 * HCLTech
 * Notepad live coding
 * Implement BinarySearch and run in console
 */
public class BinarySearch {

    public static int search(int value, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    static void main(String[] args) {
        int[] arr = new int[]{-99, -45, -34, -5, 0, 1, 10, 45, 67, 100};
        int res = search(10, arr);
        System.out.println(res);
    }
}
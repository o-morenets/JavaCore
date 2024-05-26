package _00_algorithms.sorting;

/**
 * Created by user on 08.10.2014.
 */
public class ArrayUtils {

    public static void fillArrayRandom(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }
    }

    public static int[] duplicateArray(int[] arr) {
        int[] resArray = new int[arr.length];
        System.arraycopy(arr, 0, resArray, 0, arr.length);
        return resArray;
    }

    public static boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}

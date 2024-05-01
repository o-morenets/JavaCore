package stackOverflow.insertionSort;

import java.util.Arrays;

public class forSort {

    public static void forSort(int arr[]) {
        label1:
        for (int j = 1; j < arr.length;) {
            int key = arr[j];
            for (int i = j - 1; i > -1; i--) {
                if (i == 0 && arr[i] > key) {
                    arr[i + 1] = arr[i];
                    arr[i] = key;
                    j++;
                    continue label1;
                }
                if (arr[i] > key) {
                    arr[i + 1] = arr[i];
                } else {
                    arr[i + 1] = key;
                    j++;
                    continue label1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {54, 6, 59, 35, 4};
        forSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

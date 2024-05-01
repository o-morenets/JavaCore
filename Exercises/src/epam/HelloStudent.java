package epam;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

// Produces runtime error (main class not found)
public class HelloStudent {

    public static void main(String[] args) {

        System.out.println("------------------------------ Bubble Sort ------------------------------");

        int[] array = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(-10, 10)).limit(10).toArray();
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("------------------------------ Merge Sorted ------------------------------");

        int[] input1 = new Random().ints(ThreadLocalRandom.current().nextInt(10), -10, 10).sorted().toArray();
        System.out.println(Arrays.toString(input1));
        int[] input2 = new Random().ints(ThreadLocalRandom.current().nextInt(10), -10, 10).sorted().toArray();
        System.out.println(Arrays.toString(input2));
        int[] sorted = mergeSorted(input1, input2);
        System.out.println(Arrays.toString(sorted));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
//                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // [1, 2, 4, 6, 7]
    // [3, 7, 9]
    private static int[] mergeSorted(int[] input1, int[] input2) {
        int i = 0;
        int j = 0;
        int[] outArray = new int[input1.length + input2.length];

        while (i < input1.length && j < input2.length) {
            if (input1[i] < input2[j]) {
                outArray[i + j] = input1[i++];
            } else {
                outArray[i + j] = input2[j++];
            }
        }

        while (i < input1.length) {
            outArray[i + j] = input1[i++];
        }

        while (j < input2.length) {
            outArray[i + j] = input2[j++];
        }

        return outArray;
    }

}

package epam._2019_05_07_test_external_course;

import java.util.Arrays;

public class Q {

    public static void main(String[] args) {
        System.out.println("------------------- x ^ y >>> 2");
        int x = 40;
        int y = x >>> 2;
        System.out.println(x ^ y); // 34 (34)

        System.out.println("-------------------Insertion sort");
        Integer[] array = {2, 5, 1, 3, 4};
        insertionSort(array); // numSwaps = 4 (4)

        System.out.println("------------------ <<");
        String s = "Hello World";
        long l = 99;
        double d = 1.11;
        int i = -1;
        int j = 0;
//        j = j << s;
        j = i << j; // (*)
//        j = i << d;
//        j = l << i; // (*) result is long but j is an int

        System.out.println("---------------- 1.5e-1");
        double a = 0.15;
        double b = 1.5e-1;
        System.out.println(a = b); // 0.15 (0.15)

        System.out.println("----------------- short -32768");
        short sh = -32768;
        sh -= 1;
        System.out.println("sh = " + sh); // 32767 (0)
    }

    public static <E extends Comparable<? super E>> void insertionSort(E[] theArray) {
        int numSwaps = 0;
        for (int unsorted = 1; unsorted < theArray.length; ++unsorted) {
            E nextItem = theArray[unsorted];
            int loc = unsorted;

            while ((loc > 0) && (theArray[loc-1].compareTo(nextItem) > 0)) {
                theArray[loc] = theArray[loc-1];
                loc--;
                numSwaps++;
            }
            theArray[loc] = nextItem;
            System.out.println(Arrays.toString(theArray));
        }
        System.out.println("numSwaps = " + numSwaps);
    }
}

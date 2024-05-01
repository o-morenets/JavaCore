package epam;

import java.util.Arrays;

public class EPAM {

	/**
	 * 27/09/2016 - epam.EPAM test What will return this function?
	 * My answer is: 5
	 * 
	 * @param x
	 * @return
	 */
	static int f(int x) {
		int i = 0;
		int p = 1;
		while (x / 10 > 0) {
			x = x - (x % p);
			p *= 10;
			i++;
		}
		return i;
	}

	/**
	 * 27/09/2016 - epam.EPAM test Write the method that removes all given numbers from array
	 * 
	 * @param arr
	 * @param num
	 * @return resulting array. Its size must be less than source array's size
	 */
	static int[] removeNumbers(int[] arr, int num) {
		int[] temp = new int[arr.length];
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != num) {
				temp[count] = arr[i]; // error was in this line: temp[i] = arr[i];
				count++;
			}
		}

		int[] res = new int[count];
		for (int i = 0; i < count; i++) {
			res[i] = temp[i];
		}
		return res;
	}

	/**
	 * 27/09/2016 - epam.EPAM test Write the method that removes all given numbers from array
	 * ... using streams
	 * 
	 * @param arr
	 * @param num
	 * @return
	 */
	static int[] removeNumbers_Java8(int[] arr, int num) {
		return Arrays.stream(arr)
				.filter(n -> n != num)
				.toArray();
	}

	/**
	 * TESTS
	 * @param args
	 */
    public static void main(String[] args) {
    	System.out.println(f(3425));

		int[] arr = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 4 };
		System.out.println(Arrays.toString(removeNumbers(arr, 4)));
		System.out.println(Arrays.toString(removeNumbers_Java8(arr, 4)));
		
        System.out.println("Welcome".trim() == "Welcome".trim());
        System.out.println(12 >> 2);
        System.out.println(128 >> 1);
        System.out.println(128 >>> 1);
    }

}

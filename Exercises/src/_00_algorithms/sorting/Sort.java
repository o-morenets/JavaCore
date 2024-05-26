package _00_algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by user on 08.10.2014.
 */
public class Sort {

	// Bubble Sort
	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}

	// Bubble Sort (optimized)
	public void bubbleSortOptimized(int[] arr) {
		boolean swapped;
		int i = 0;
		do {
			swapped = false;
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
					swapped = true;
				}
			}
			i++;
		} while (swapped);
	}

	// Selection Sort
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int indexOfMin = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[indexOfMin]) {
					indexOfMin = j;
				}
			}
			int tmp = arr[indexOfMin];
			arr[indexOfMin] = arr[i];
			arr[i] = tmp;
		}
	}

	// Insertion Sort
	public void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j--];
			}
			arr[j + 1] = temp;
		}
	}

	/**
	 * Gnome sort
	 */
	void gnomeSort(int[] arr) {
		int i = 1;
		while (i < arr.length) {
			if (i == 0 || arr[i - 1] <= arr[i]) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
				i--;
			}
		}
	}

	/**
	 * Bogo sort
	 */
	public void bogoSort(int[] arr) {
		while (!isInOrder(arr)) {
			shuffle(arr);
		}
	}

	private boolean isInOrder(int[] arr) {
		int length = arr.length - 1;
		for (int i = 0; i < length; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private void shuffle(int[] arr) {
		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			int swapPosition = random.nextInt(arr.length);
			int temp = arr[i];
			arr[i] = arr[swapPosition];
			arr[swapPosition] = temp;
		}
	}

	/**
	 * Quick Sort
	 */
	Random rand = new Random();

	public void quickSort(int[] arr) {
		doQuickSort(arr, 0, arr.length - 1);
	}

	private void doQuickSort(int[] array, int left, int right) {
		int i = left;
		int j = right;
		int x = array[left + rand.nextInt(right - left + 1)];
		while (i <= j) {
			while (array[i] < x) {
				i++;
			}
			while (array[j] > x) {
				j--;
			}
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j) {
			doQuickSort(array, left, j);
		}
		if (i < right) {
			doQuickSort(array, i, right);
		}
	}

	/**
	 * Merge Sort
	 * http://codereview.stackexchange.com/questions/64711/merge-sort-an-integer-array
	 */
	public void mergeSort(int[] arr) {
		int size = arr.length;
		if (size < 2) {
			return;
		}

		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];

		System.arraycopy(arr, 0, left, 0, mid);

		System.arraycopy(arr, mid, right, 0, size - mid);

		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}

	// Merges two sorted arrays
	private void merge(int[] left, int[] right, int[] arr) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < leftSize) {
			arr[k++] = left[i++];
		}

		while (j < rightSize) {
			arr[k++] = right[j++];
		}
	}

	// ===========================================================================================================

	public static void main(String[] args) {
		Sort sort = new Sort();

		System.out.println("Bubble sort random int[]");
		int[] arr0 = new int[50];
		ArrayUtils.fillArrayRandom(arr0);
		System.out.println(Arrays.toString(arr0));
		sort.bubbleSort(arr0);
		System.out.println(Arrays.toString(arr0));
		if (!ArrayUtils.isArraySorted(arr0)) {
			System.out.println("Array wasn't sorted!");
		}
		System.out.println();
		// ///////////////////////////////////////////////////////////////

		System.out.println("Bubble sort (optimized) random int[]");
		int[] arr1 = new int[50];
		ArrayUtils.fillArrayRandom(arr1);
		System.out.println(Arrays.toString(arr1));
		sort.bubbleSortOptimized(arr1);
		System.out.println(Arrays.toString(arr1));
		if (!ArrayUtils.isArraySorted(arr1)) {
			System.out.println("Array wasn't sorted!");
		}
		System.out.println();
		// ///////////////////////////////////////////////////////////////

		System.out.println("Selection sort random int[]");
		int arr2[] = new int[50];
		ArrayUtils.fillArrayRandom(arr2);
		System.out.println(Arrays.toString(arr2));
		sort.selectionSort(arr2);
		System.out.println(Arrays.toString(arr2));
		if (!ArrayUtils.isArraySorted(arr2)) {
			System.out.println("Array wasn't sorted!");
		}
		System.out.println();
		// ///////////////////////////////////////////////////////////////

		System.out.println("Insertion sort random int[]");
		int arr3[] = new int[50];
		ArrayUtils.fillArrayRandom(arr3);
		System.out.println(Arrays.toString(arr3));
		sort.insertionSort(arr3);
		System.out.println(Arrays.toString(arr3));
		if (!ArrayUtils.isArraySorted(arr3)) {
			System.out.println("Array wasn't sorted!");
		}
		System.out.println();
		// ///////////////////////////////////////////////////////////////

		System.out.println("Quick sort random int[]");
		int arr4[] = new int[50];
		ArrayUtils.fillArrayRandom(arr4);
		System.out.println(Arrays.toString(arr4));
		sort.quickSort(arr4);
		System.out.println(Arrays.toString(arr4));
		if (!ArrayUtils.isArraySorted(arr4)) {
			System.out.println("Array wasn't sorted!");
		}
		System.out.println();
		// ///////////////////////////////////////////////////////////////

		System.out.println("Merge sort random int[]");
		int arr5[] = new int[50];
		ArrayUtils.fillArrayRandom(arr5);
		System.out.println(Arrays.toString(arr5));
		sort.mergeSort(arr5);
		System.out.println(Arrays.toString(arr5));
		if (!ArrayUtils.isArraySorted(arr5)) {
			System.out.println("Array wasn't sorted!");
		}
		System.out.println();
		// ///////////////////////////////////////////////////////////////

		int[] a0 = new int[100_000];
		int[] a1, a2, a3, a4, a5;
		long start, finish;

		ArrayUtils.fillArrayRandom(a0);
		a1 = ArrayUtils.duplicateArray(a0);
		a2 = ArrayUtils.duplicateArray(a0);
		a3 = ArrayUtils.duplicateArray(a0);
		a4 = ArrayUtils.duplicateArray(a0);
		a5 = ArrayUtils.duplicateArray(a0);

		System.out.println("Calculating time for bubbleSort (100_000 numbers)...");
		start = System.currentTimeMillis();
		sort.bubbleSort(a0);
		finish = System.currentTimeMillis();
		System.out.println((finish - start) + " ms");
		if (!ArrayUtils.isArraySorted(a0)) {
			System.out.println("Array wasn't sorted!");
		}

		System.out.println("Calculating time for bubbleSort (optimized) (100_000 numbers)...");
		start = System.currentTimeMillis();
		sort.bubbleSortOptimized(a1);
		finish = System.currentTimeMillis();
		System.out.println((finish - start) + " ms");
		if (!ArrayUtils.isArraySorted(a1)) {
			System.out.println("Array wasn't sorted!");
		}

		System.out.println("Calculating time for selectionSort (100_000 numbers)...");
		start = System.currentTimeMillis();
		sort.selectionSort(a2);
		finish = System.currentTimeMillis();
		System.out.println((finish - start) + " ms");
		if (!ArrayUtils.isArraySorted(a2)) {
			System.out.println("Array wasn't sorted!");
		}

		System.out.println("Calculating time for insertionSort (100_000 numbers)...");
		start = System.currentTimeMillis();
		sort.insertionSort(a3);
		finish = System.currentTimeMillis();
		System.out.println((finish - start) + " ms");
		if (!ArrayUtils.isArraySorted(a3)) {
			System.out.println("Array wasn't sorted!");
		}

		System.out.println("Calculating time for Quick Sort (100_000 numbers)...");
		start = System.currentTimeMillis();
		sort.quickSort(a4);
		finish = System.currentTimeMillis();
		System.out.println((finish - start) + " ms");
		if (!ArrayUtils.isArraySorted(a4)) {
			System.out.println("Array wasn't sorted!");
		}

		System.out.println("Calculating time for Merge Sort (100_000 numbers)...");
		start = System.currentTimeMillis();
		sort.mergeSort(a5);
		finish = System.currentTimeMillis();
		System.out.println((finish - start) + " ms");
		if (!ArrayUtils.isArraySorted(a5)) {
			System.out.println("Array wasn't sorted!");
		}

		// ///////////////////////////////////////////////////////////////

		int[] arrGnome = { 5, 2, 6, 4, 9, 1, 8, 7, 9, 3, 4, 5, 9, 3, 5, 1, 2, 9, 7, 5, 6, 0, 3, 4, 8 };
		System.out.println("Gnome sort...");
		System.out.println(Arrays.toString(arrGnome));
		sort.gnomeSort(arrGnome);
		System.out.println(Arrays.toString(arrGnome));

		int[] arrBogo = { 5, 2, 6, 4, 9, 1, 8, 7, 9, 3, 5, 8, 7 };
		System.out.println("Wait a minute... Bogo sort processes " + arrBogo.length + " elements more than 3 mins...");
		System.out.println(Arrays.toString(arrBogo));
		sort.bogoSort(arrBogo);
		System.out.println(Arrays.toString(arrBogo));
	}
}

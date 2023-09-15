import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] arr = {0, 2312, -987, 5, 2, 4, 6, 1, -23, 0, 0, 0, -34, -43, -34, 234, 54, 4, 2, 0, 6, 6, 3, 4, 1, 6, 34};
//		new Sort().insertionSort(arr);
		new Sort().bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int j;
			for (j = i; j > 0; j--) {
				if (arr[j - 1] > current) {
					arr[j] = arr[j - 1];
				} else {
					break;
				}
			}
			arr[j] = current;
		}
	}

	private void bubbleSort(int[] arr) {
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
}

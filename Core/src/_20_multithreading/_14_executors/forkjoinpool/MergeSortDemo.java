package _20_multithreading._14_executors.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MergeSortDemo {

	public static void main(String[] args) {
		int[] arr = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(-1000, 1000)).limit(1000).toArray();
		System.out.println(Arrays.toString(arr));
		ForkJoinPool.commonPool().invoke(new MergeSortTask(arr));
		System.out.println(Arrays.toString(arr));
	}
}

class MergeSortTask extends RecursiveAction {

	int[] arr;
	int n;

	public MergeSortTask(int[] arr) {
		this.arr = arr;
		this.n = arr.length;
	}

	@Override
	protected void compute() {
		if (arr.length == 1) {
			return;
		}
		int[] left = Arrays.copyOfRange(arr, 0, n / 2);
		int[] right = Arrays.copyOfRange(arr, n / 2, n);
		MergeSortTask leftTask = new MergeSortTask(left);
		MergeSortTask rightTask = new MergeSortTask(right);
		leftTask.fork();
		rightTask.compute();
		leftTask.join();
		merge(arr, left, right);

	}

	private void merge(int[] arr, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[i + j] = left[i++];
			} else {
				arr[i + j] = right[j++];
			}
		}
		System.arraycopy(left, i, arr, i + j, left.length - i);
		System.arraycopy(right, j, arr, i + j, right.length - j);
	}
}

package _20_multithreading.runnablevscallable.callable;

import java.util.concurrent.*;

/**
 * https://www.baeldung.com/java-runnable-callable
 */
public class FactorialTask implements Callable<Integer> {

	int number;

	public FactorialTask(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws InvalidParameterException {
		if (number < 0) {
			throw new InvalidParameterException("Number should be positive");
		}

		int fact = 1;
		// ...
		for (int count = number; count > 1; count--) {
			fact = fact * count;
		}

		return fact;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
			FactorialTask task = new FactorialTask(5); // try to pass negative value here
			Future<Integer> future = executorService.submit(task);
			Integer result = future.get();
			System.out.println(result);
		} catch (Exception ex) {
			System.out.println("Exception");
		}
	}
}
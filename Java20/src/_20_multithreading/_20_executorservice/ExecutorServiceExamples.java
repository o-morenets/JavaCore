package _20_multithreading._20_executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExamples {

	private static Runnable initRunnable() {
		Runnable runnableTask = () -> {
			System.out.println("Runnable starts...");
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Runnable finished.");
		};
		return runnableTask;
	}

	private static Callable<String> initCallable(int num) {
		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task #" + num + " execution";
		};
		return callableTask;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		Runnable runnableTask = initRunnable();

		Callable<String> callableTask = initCallable(10);

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(initCallable(1));
		callableTasks.add(initCallable(2));
		callableTasks.add(initCallable(3));

		// create a thread pool with 10 threads:
		ExecutorService executorService =
				new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
						new LinkedBlockingQueue<Runnable>());
		// or
//		ExecutorService executor = Executors.newFixedThreadPool(10);

		// The execute() method is void and doesn't give any possibility to get the result of a task’s execution or to check the task’s status (is it running):
		executorService.execute(runnableTask);

		// submit() submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future:
		Future<String> future = executorService.submit(callableTask);
		System.out.println("Single Callable result: " + future.get());

		// invokeAny() assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result
		// of a successful execution of one task (if there was a successful execution):
		String result = executorService.invokeAny(callableTasks);
		System.out.println("Any Callable's result: " + result);

		// invokeAll() assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result
		// of all task executions in the form of a list of objects of type Future:
		List<Future<String>> futures = executorService.invokeAll(callableTasks);
		System.out.println("All results: " + futures);

		List<Runnable> notExecutedTasks = executorService.shutdownNow();
		System.out.println("notExecutedTasks = " + notExecutedTasks);
	}
}

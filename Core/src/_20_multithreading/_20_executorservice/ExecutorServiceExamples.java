package _20_multithreading._20_executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServiceExamples {

	private static Runnable initRunnableTask() {
        return () -> {
			System.out.println("Runnable starts...");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runnable finished.");
		};
	}

	private static Callable<String> initCallableTask(int num) {
        return () -> {
			System.out.println("Callable task #" + num + " is running...");
			TimeUnit.SECONDS.sleep(2);
			return "Task #" + num + " result";
		};
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		Runnable runnableTask = initRunnableTask();

		Callable<String> callableTask = initCallableTask(0);

		List<Callable<String>> callableTasks = IntStream.rangeClosed(1, 10).mapToObj(ExecutorServiceExamples::initCallableTask).collect(Collectors.toList());

		// create a thread pool:
		ExecutorService executorService =
				new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

		// or
//		executorService = Executors.newSingleThreadExecutor();
//		executorService = Executors.newFixedThreadPool(10);
//		executorService = Executors.newCachedThreadPool();
//		executorService = Executors.newScheduledThreadPool(5);
//		executorService = Executors.newSingleThreadScheduledExecutor();
//		executorService = Executors.newThreadPerTaskExecutor(Thread::new);
//		executorService = Executors.newVirtualThreadPerTaskExecutor();
//		executorService = Executors.newWorkStealingPool();

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
		printFuturesResults(futures);

		boolean termination = executorService.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println(termination);

		List<Runnable> notExecutedTasks = executorService.shutdownNow();
		System.out.println("notExecutedTasks = " + notExecutedTasks);
	}

	private static void printFuturesResults(List<Future<String>> futures) {
		futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
	}
}

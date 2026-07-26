package _20_multithreading._14_executors.executorservice;

import _20_multithreading._14_executors.utils.ExecutorUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServiceExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Single Runnable task:
        Runnable singleRunnableTask = ExecutorUtils.initRunnableTask();

        // Single Callable task:
        Callable<String> singleCallableTask = ExecutorUtils.initCallableTask(0);

        // Multiple Callable tasks:
        List<Callable<String>> callableTasks = IntStream.rangeClosed(1, 10)
                .mapToObj(ExecutorUtils::initCallableTask)
                .collect(Collectors.toList());

        // create a thread pool:
        ExecutorService executorService = new ThreadPoolExecutor(
                2, // core pool size - the number of threads that will always be alive
                5, // max pool size - the maximum number of threads that can be alive at the same time
                0L, // keep-alive time - when the number of threads is greater than the core,
                TimeUnit.MILLISECONDS, // time unit of keep-alive time
                new LinkedBlockingQueue<>(10) // queue of tasks - if the queue is full and max pool size is reached,
                    // the new tasks will wait in the queue, and RejectionException will be thrown when new tasks are submitted
        );

        // or
//		executorService = Executors.newFixedThreadPool(10);
//		executorService = Executors.newSingleThreadExecutor();
//		executorService = Executors.newCachedThreadPool();
//		executorService = Executors.newScheduledThreadPool(5);
//		executorService = Executors.newSingleThreadScheduledExecutor();
//		executorService = Executors.newThreadPerTaskExecutor(Thread::new);
//		executorService = Executors.newVirtualThreadPerTaskExecutor();
//		executorService = Executors.newWorkStealingPool();

        try {

            // The execute() method is void and doesn't give any possibility to get the result of a task’s execution
            // or to check the task’s status (is it running):
            executorService.execute(singleRunnableTask);


            // submit() submits a Runnable or a Callable task to an ExecutorService and returns a result of type Future<>:
            Future<?> runnableTaskFuture = executorService.submit(singleRunnableTask);
            Future<String> callableTaskFuture = executorService.submit(singleCallableTask);

            // blocks and returns null or Exception for Runnable tasks
            try {
                System.out.println("Single Runnable result: " + runnableTaskFuture.get());
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception in Runnable: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.err.println("Execution exception in Runnable: " + e.getCause());
            }

            // get() blocks this thread until `callable` finishes and returns the result (throws exception if any)
            try {
                System.out.println("Single Callable result: " + callableTaskFuture.get());
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception in Callable: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw e;
            } catch (ExecutionException e) {
                System.err.println("Execution exception in Callable: " + e.getCause());
            }


            // invokeAny() executes all given tasks, returning the result of one that has completed successfully
            // (i.e., without throwing an exception), if any do.
            // Upon normal or exceptional return, tasks that have not completed are canceled (interrupted if possible)
            String result = executorService.invokeAny(callableTasks);
            System.out.println("Any Callable's result: " + result);


            // invokeAll() assigns a collection of tasks to an ExecutorService, causing each to run,
            // and returns the result of all task executions in the form of a list of objects of type Future:
            List<Future<String>> futures = executorService.invokeAll(callableTasks);

            System.out.println("All tasks are done. All Future's: ");
            futures.forEach(System.out::println); // ...[Completed normally/exceptionally...]

            System.out.println("All callable results:");
            printFutureResults(futures); // get all results (throws exception if any)
        } finally {
            System.out.println("SHUTDOWN...");
            executorService.shutdown(); // JVM will not finish when no shutdown() is called!
        }
    }

    private static void printFutureResults(List<Future<String>> futures) {
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (ExecutionException e) {
                System.err.println("Task failed: " + e.getCause());
            }
        }
    }
}

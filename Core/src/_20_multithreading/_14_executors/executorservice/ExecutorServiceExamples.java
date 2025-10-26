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
                new LinkedBlockingQueue<>() // queue of tasks - if the queue is full and max pool size is reached,
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

            // blocks and returns null for Runnable tasks
            System.out.println("Single Runnable result: " + runnableTaskFuture.get());

            // get() blocks this thread until `callable` finishes and returns the result (throws exception if any)
            try {
                System.out.println("Single Callable result: " + callableTaskFuture.get());
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception in Callable: " + e.getMessage());
                throw e;
            } catch (ExecutionException e) {
                System.out.println("Execution exception in Callable: " + e.getMessage());
            }


            // invokeAny() executes all given tasks, returning the result of one that has completed successfully
            // (i.e., without throwing an exception), if any do.
            // Upon normal or exceptional return, tasks that have not completed are cancelled (interrupted if possible)
            String result = executorService.invokeAny(callableTasks);
            System.out.println("Any Callable's result: " + result);


            // invokeAll() assigns a collection of tasks to an ExecutorService, causing each to run,
            // and returns the result of all task executions in the form of a list of objects of type Future:
            List<Future<String>> futures = executorService.invokeAll(callableTasks);

            System.out.println("All tasks are done. All Future's: ");
            futures.forEach(System.out::println); // ...[Completed normally/exceptionally...]

            System.out.println("All callable results:");
            printFuturesResults(futures); // get all results (throws exception if any)
            // ================= at this point, all tasks are done (get method was called) =================

            System.out.println("============================================================================");

            // ================= New tasks need to be submitted again:
            IntStream.rangeClosed(1, 10)
                    .mapToObj(ExecutorUtils::initCallableTask)
                    .forEach(executorService::submit);

            // shutDown() initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
            // Invocation has no additional effect if already shut down.
            // This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that
            System.out.println("Shutting down executor service... ");
            executorService.shutdown();
        } catch (InterruptedException e) {
            System.out.println("Caught InterruptedException");
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("Caught ExecutionException");
            throw new RuntimeException(e);
        } finally {

            // awaitTermination() blocks until all tasks have completed execution after a shutdown request,
            // or the timeout occurs, or the current thread is interrupted, whichever happens first.
            System.out.println("Waiting for termination... ");
            boolean termination = executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println(termination ? "Executor terminated" : "Timeout elapsed before termination");

            // shutDownNow() initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
            System.out.println("FORCE SHUT DOWN executor service!");
            List<Runnable> notExecutedTasks = executorService.shutdownNow();
            String notExecutedTasksStr = notExecutedTasks.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n", "\n", ""));
            System.out.println("Not Executed Tasks = " + notExecutedTasksStr);
        }
    }

    private static void printFuturesResults(List<Future<String>> futures) {
        futures.forEach(f -> {
            try {
                System.out.println(f.get()); // here get() will show the exception if any
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}

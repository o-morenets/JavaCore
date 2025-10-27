package _20_multithreading._14_executors.executorservice;

import _20_multithreading._14_executors.utils.ExecutorUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShutdownExample {

    static void main() {
        // create a thread pool:
        ExecutorService executorService = new ThreadPoolExecutor(
                2, // core pool size - the number of threads that will always be alive
                5, // max pool size - the maximum number of threads that can be alive at the same time
                0L, // keep-alive time - when the number of threads is greater than the core,
                TimeUnit.MILLISECONDS, // time unit of keep-alive time
                new LinkedBlockingQueue<>() // queue of tasks - if the queue is full and max pool size is reached,
                // the new tasks will wait in the queue, and RejectionException will be thrown when new tasks are submitted
        );

        try {
            IntStream.rangeClosed(1, 10)
                    .mapToObj(ExecutorUtils::initCallableTask)
                    .forEach(executorService::submit);

            System.out.println("Submitted 10 new tasks.");

            // shutDown() initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
            // Invocation has no additional effect if already shut down.
            // This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that
            System.out.println("Shutting down executor service... ");
            executorService.shutdown();
        } finally {

            // awaitTermination() blocks until all tasks have completed execution after a shutdown request,
            // or the timeout occurs, or the current thread is interrupted, whichever happens first.
            System.out.println("Waiting 2 SECONDS for termination... ");
            boolean termination = false;
            try {
                termination = executorService.awaitTermination(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
}

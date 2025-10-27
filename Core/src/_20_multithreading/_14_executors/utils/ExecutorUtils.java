package _20_multithreading._14_executors.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ExecutorUtils {

    public static Runnable initRunnableTask() {
        return () -> {
            System.out.println("\tRunnable task starts:");

            for (int i = 0; i < 3; i++) {
                try {
                    System.out.printf("\tRunnable task is running step %d...%n", i + 1);
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException("\tRunnable task interrupted", e);
                }
            }

            System.out.println("\tRunnable task finished.");
        };
    }

    public static Callable<String> initCallableTask(int num) {
        return () -> {
            System.out.println("\t\tCallable task #" + num + " starts in thread " + Thread.currentThread().getName());

            for (int i = 0; i < 3; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.printf("\t\tCallable task #%d detected interrupt before step %d, exiting...%n", num, i + 1);

                    return "Callable task #" + num + " result (interrupted on step" + (i + 1) + ")";
                }

                if (ThreadLocalRandom.current().nextInt(10) < 2) {
                    System.out.println("\t\tCallable task #" + num + " throws EXCEPTION on step " + (i + 1) +
                            ", releasing " + Thread.currentThread().getName());
                    throw new RuntimeException("Callable task #" + num + " throws EXCEPTION on step " + (i + 1));
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    System.out.printf("\t\tCallable task #%d is running step ...%d... in thread %s%n",
                            num, i + 1, Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.printf("\t\tCallable task #%d interrupted during sleep at step %d%n", num, i + 1);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Callable task #" + num + " interrupted", e);
                }
            }

            System.out.println("\t\tCallable task #" + num + " FINISHED on thread " + Thread.currentThread().getName());

            return "Callable task #" + num + " result (finished)";
        };
    }
}

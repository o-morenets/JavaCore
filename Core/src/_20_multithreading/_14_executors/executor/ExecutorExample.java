package _20_multithreading._14_executors.executor;

import _20_multithreading._14_executors.utils.ExecutorUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        // Single Runnable task:
        Runnable singleRunnableTask = ExecutorUtils.initRunnableTask();

        // Executor has only one execute() method, which accepts a Runnable:
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            executor.execute(singleRunnableTask);
        }
        System.out.println("Main thread ended");
    }
}

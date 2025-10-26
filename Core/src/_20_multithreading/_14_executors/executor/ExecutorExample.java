package _20_multithreading._14_executors.executor;

import _20_multithreading._14_executors.utils.ExecutorUtils;

import java.util.concurrent.Executor;

public class ExecutorExample {

    public static void main(String[] args) {

        // Single Runnable task:
        Runnable singleRunnableTask = ExecutorUtils.initRunnableTask();

        // Executor has only one execute() method, which accepts a Runnable:
        Executor executor = Runnable::run;
        executor.execute(singleRunnableTask);
    }
}

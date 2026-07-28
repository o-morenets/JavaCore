package _20_multithreading._09_deadlock_livelock_starvation.starvation;

import java.util.concurrent.Semaphore;

public class SemaphoreStarvation {

    private static final Semaphore semaphore = new Semaphore(1, false);

    private static void work() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " acquired");

            Thread.sleep(5);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {

        Thread greedy = new Thread(() -> {
            while (true) {
                work();
            }
        }, "Greedy");

        Thread victim1 = new Thread(() -> {
            while (true) {
                work();
            }
        }, "Victim-1");

        Thread victim2 = new Thread(() -> {
            while (true) {
                work();
            }
        }, "Victim-2");

        greedy.start();
        victim1.start();
        victim2.start();
    }
}
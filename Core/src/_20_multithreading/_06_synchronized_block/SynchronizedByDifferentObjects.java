package _20_multithreading._06_synchronized_block;

import java.util.concurrent.TimeUnit;

class Logic {

    final Object o1 = new Object();
    final Object o2 = new Object();

    void produce() {
        synchronized (o1) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    void consume() {
        synchronized (o2) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class SynchronizedByDifferentObjects {

    public static void main(String[] args) {

        Logic logic = new Logic();
        new Thread(logic::produce).start();
        new Thread(logic::consume).start();
    }
}

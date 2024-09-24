package _18_collections._03_set;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * https://www.youtube.com/watch?v=nUYOGkh9XqE
 */
public class SynchronousQueueExample {

    static SynchronousQueue<Integer> queue = new SynchronousQueue<>();

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int rndInt = ThreadLocalRandom.current().nextInt(100);
                    System.out.println("Produced: " + rndInt);
                    queue.put(rndInt);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Consumed: " + queue.take());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}

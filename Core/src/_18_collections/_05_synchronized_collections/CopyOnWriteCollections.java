package _18_collections._05_synchronized_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * https://youtu.be/-yQeYo32Lt4
 */
public class CopyOnWriteCollections {

    public static final int LIST_SIZE = 100_000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Normal List - not synchronized
        List<Integer> normalList = new ArrayList<>();
        IntStream.range(0, LIST_SIZE).forEach(normalList::add);
        checkList(normalList);

        // Synchronized List - read and write synchronized
        List<Integer> synchronizedList = Collections.synchronizedList(normalList); // already filled
        checkList(synchronizedList);

        // CopyOnWriteArrayList - read NOT synchronized, write - synchronized
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        IntStream.range(0, LIST_SIZE).forEach(copyOnWriteArrayList::add);
        checkList(copyOnWriteArrayList);
    }

    /**
     * Read different parts of list in 2 parallel threads
     */
    private static void checkList(List<Integer> list) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Future<Long> f1;
        Future<Long> f2;
        try (ExecutorService ex = Executors.newFixedThreadPool(2)) {
            f1 = ex.submit(new ListRunner(list, 0, list.size() / 2, latch));
            f2 = ex.submit(new ListRunner(list, list.size() / 2, list.size(), latch));
            latch.countDown();
        }
        System.out.println("Thread 1:" + f1.get() / 1000);
        System.out.println("Thread 2:" + f2.get() / 1000);

        TimeUnit.SECONDS.sleep(2);
    }

    private static class ListRunner implements Callable<Long> {
        private final List<Integer> list;
        private final int start;
        private final int end;
        private final CountDownLatch latch;

        private ListRunner(List<Integer> list, int start, int end, CountDownLatch latch) {
            this.list = list;
            this.start = start;
            this.end = end;
            this.latch = latch;
        }

        @Override
        public Long call() throws Exception {
            latch.await();

            long startTime = System.nanoTime();

            for (int i = start; i < end; i++) {
                list.get(i);
            }

            long finishTime = System.nanoTime();
            System.out.println(Thread.currentThread().getName() + " finished");

            return finishTime - startTime;
        }
    }
}

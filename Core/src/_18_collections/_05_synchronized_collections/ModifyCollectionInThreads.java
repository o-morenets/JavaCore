package _18_collections._05_synchronized_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Simultaneously add elements to the normal collections and synchronized collection
 */
public class ModifyCollectionInThreads {

    public static void main(String[] args) throws InterruptedException {
        final int numThreads = 20;
        final int numElementsPerThread = 1000;

        List<Integer> list = new LinkedList<>();
        concurrentWriteList(list, numThreads, numElementsPerThread);
        System.out.println("Non-synchronized list size = " + list.size()); // unpredictable size

        System.out.println("----------------------------------------------------------");
        List<Integer> synchronizedlist = Collections.synchronizedList(new ArrayList<>());
        concurrentWriteList(synchronizedlist, numThreads, numElementsPerThread);
        System.out.println("Synchronized list size = " + synchronizedlist.size()); // exact 2000
    }

    private static void concurrentWriteList(List<Integer> list, int numThreads, int numElementsPerThread) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numThreads);

        for (int n = 0; n < numThreads; n++) {
            new Thread(() -> {
                try {
                    startSignal.await();

                    for (int i = 0; i < numElementsPerThread; i++) {
                        list.add(i);
                    }

                    doneSignal.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        startSignal.countDown();
        doneSignal.await();
    }
}

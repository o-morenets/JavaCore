package _18_collections._05_synchronized_collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Example of how Collections.synchronizedList(list) does NOT prevent from ConcurrentModificationException
 */
public class IteratorOverSynchronizedCollection {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        // Collections.synchronizedList makes all List's methods synchronized but not iterator()
        List<Integer> synchronizedlist = Collections.synchronizedList(list);

        processCollection(list); // ConcurrentModificationException
        processCollection(synchronizedlist); // also ConcurrentModificationException !!!
    }

    private static void processCollection(List<Integer> list) throws InterruptedException {
        new Thread(() -> {
            for (Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
                System.out.println("value = " + itr.next());
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(2000);
        list.add(99); // ConcurrentModificationException here
    }
}

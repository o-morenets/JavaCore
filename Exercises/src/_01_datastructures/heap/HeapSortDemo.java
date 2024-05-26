package _01_datastructures.heap;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class HeapSortDemo {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = MaxHeap.of(1, 2, 5, 10, 20, 100, 200, 500, 10, 5);
        System.out.println(maxHeap);
        System.out.println("-------------------");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + ": ");
            System.out.println(maxHeap + " (" + maxHeap.size() + ")");
        }
        System.out.println("-------------------");


        sortMethod(1_000_000);

//        sortedHeap(1_000_000);
    }

    private static void sortMethod(int size) {
        List<Long> list = LongStream.generate(() -> ThreadLocalRandom.current().nextLong(size))
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
        Collection<Long> sorted = MaxHeap.heapSort(list);
        System.out.println(sorted);
    }

    private static void sortedHeap(int size) {
        MaxHeap<Integer> integerMaxHeap = new MaxHeap<>(size);
//        Arrays.asList(1, 2, 5, 10, 20, 100, 200, 500, 10, 5)
        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(size))
                .limit(size)
                .boxed()
                .forEach(integerMaxHeap::add);
        System.out.println(integerMaxHeap.sorted());
    }
}

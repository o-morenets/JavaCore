package _18_collections._02_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 % 2 == 0 ? -1 : 1);

        for (int i = 5; i > 0; i--) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

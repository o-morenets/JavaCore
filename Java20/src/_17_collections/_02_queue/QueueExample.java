package _17_collections._02_queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Integer> integerQueue = new LinkedList<>(Arrays.asList(4, -2, 0, 94, -23));
		for (Iterator<Integer> itr = integerQueue.iterator(); itr.hasNext(); ) {
			Integer i = itr.next();
			if (i < 0) {
				itr.remove();
			}
		}
		System.out.println("integerQueue = " + integerQueue);
	}
}

package _20_multithreading._06_synchronized_block;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccessToList {

	public static void main(String[] args) throws InterruptedException {
		final List<String> myList = new ArrayList<>();
		Thread threadHello = getThread(myList, "HELLO");
		Thread threadHi = getThread(myList, "hi");

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Adding Goodbye...");
		myList.add("Goodbye"); // we CAN access and modify myList from other Thread which DOESN'T acquire monitor on it
		System.out.println("Goodbye added.");

		threadHello.join();
		threadHi.join();

		System.out.println(myList); // [Hello, Goodbye, hi] - "Goodbye" was added, but "hi" was added when first thread ended
	}

	private static Thread getThread(List<String> myList, String element) {
		Thread thread = new Thread(() -> {
			System.out.println("Thread " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
			synchronized (myList) {
				System.out.printf("Adding '%s'...%n", element);
				myList.add(element);
				System.out.printf("'%s' added.%n", element);
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
		});

		thread.start();
		return thread;
	}
}

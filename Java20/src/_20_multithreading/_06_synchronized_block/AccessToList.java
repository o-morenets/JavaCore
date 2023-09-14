package _20_multithreading._06_synchronized_block;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccessToList {

	public static void main(String[] args) throws InterruptedException {
		final List<String> myList = new ArrayList<>();
		Thread thread = getThread(myList);

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Adding Goodbye...");
		myList.add("Goodbye"); // we CAN access nd modify myList from other Thread
		System.out.println("Goodbye added.");

		thread.join();

		System.out.println(myList); // [Hello, Goodbye] - "Goodbye" was added
	}

	private static Thread getThread(List<String> myList) {
		Thread thread = new Thread(() -> {
			System.out.println("Thread " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
			synchronized (myList) {
				System.out.println("Adding Hello...");
				myList.add("Hello");
				System.out.println("Hello added.");
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

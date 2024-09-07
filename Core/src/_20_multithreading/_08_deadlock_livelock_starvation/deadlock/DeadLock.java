package _20_multithreading._08_deadlock_livelock_starvation.deadlock;

import java.util.concurrent.TimeUnit;

public class DeadLock {

	private static final Object o1 = new Object();
	private static final Object o2 = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			synchronized (o1) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		}, "Thread 1");
		t1.start();
		System.out.println(t1.getName() + ": " + t1.getState());

		Thread t2 = new Thread(() -> {
			synchronized (o2) {
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		}, "Thread 2");
		t2.start();
		System.out.println(t2.getName() + ": " + t2.getState());

		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(t1.getName() + ": " + t1.getState());
			System.out.println(t2.getName() + ": " + t2.getState());
		}
	}
}

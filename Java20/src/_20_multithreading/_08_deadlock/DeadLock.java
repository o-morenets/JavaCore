package _20_multithreading._08_deadlock;

public class DeadLock {

	private static final Object o1 = new Object();
	private static final Object o2 = new Object();

	public static void main(String[] args) {

		new Thread(() -> {
			synchronized (o1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		}, "Thread 1").start();

		new Thread(() -> {
			synchronized (o2) {
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		}, "Thread 2").start();
	}
}

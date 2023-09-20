package _20_multithreading._01_sleep;

/**
 * Created by user on 15.10.2014.
 */
public class SleepDemo implements Runnable {

	private static int numbers;
	private final int seconds;
	private final int number;

	public SleepDemo(int seconds) {
		this.seconds = seconds;
		number = setNumber();
	}

	public static int setNumber() {
		return ++numbers;
	}

	public static void main(String[] args) {
		Runnable thread1 = new SleepDemo(5);
		new Thread(thread1).start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(new SleepDemo(10)).start();

		System.out.println("Main thread has finished.");
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < this.seconds; i++) {
				Thread.sleep(1000);
				System.out.println("Second #" + i + " of executing thread nr. " + this.number);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

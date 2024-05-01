package _20_multithreading._11_interrupt;

public class IsInterruptedVsInterrupted {
	public static void main(String[] args) {
		// Check if the main thread is interrupted
		System.out.println("#1:" + Thread.interrupted()); // false

		// Now interrupt the main thread
		Thread mainThread = Thread.currentThread();
		mainThread.interrupt();

		// Check if it has been interrupted
		System.out.println("#2:" + mainThread.isInterrupted()); // true

		// Check if it has been interrupted
		System.out.println("#3:" + mainThread.isInterrupted()); // true

		System.out.println("#4:" + Thread.interrupted()); // true

		System.out.println("#5:" + mainThread.isInterrupted()); // false
	}
}
package jat;

import java.util.concurrent.TimeUnit;

public class PingPong {

	public static void main(String[] args) throws InterruptedException {
		new PingPongThread("ping");
		PingPongThread pongThread = new PingPongThread("PONG");

		TimeUnit.SECONDS.sleep(5);
		pongThread.getThread().interrupt();
	}
}

class PingPongThread implements Runnable {

	private Thread thread = new Thread(this);
	private String name;
	private static final Object lock = new Object();

	public PingPongThread(String name) {
		this.name = name;
		this.thread.start();
	}

	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (!thread.isInterrupted()) {
				System.out.println(name);
				lock.notify();

				try {
					lock.wait(1000);
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					System.out.println(name + " was interrupted");
					thread.interrupt();
				}
			}
		}
	}
}

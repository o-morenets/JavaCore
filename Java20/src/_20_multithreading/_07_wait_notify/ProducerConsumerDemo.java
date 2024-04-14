package _20_multithreading._07_wait_notify;

import java.util.concurrent.ThreadLocalRandom;

class Q {

	int number;
	boolean isValueSet;

	synchronized void put(int n) {
		while (isValueSet) {
			try {
				System.out.println("Producer waits...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		number = n;
		isValueSet = true;
		System.out.println("Produced: " + n);
		notify();
	}

	synchronized int get() {
		while (!isValueSet) {
			try {
				System.out.println("Consumer waits...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		isValueSet = false;
		System.out.println("Consumed: " + number);
		notify();
		return number;
	}
}

class Producer implements Runnable {

	Q q;
	Thread t;

	public Producer(Q q) {
		this.q = q;
		this.t = new Thread(this);
		this.t.start();
	}

	@Override
	public void run() {
		int i = 0;

		while (true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable {

	Q q;
	Thread t;

	public Consumer(Q q) {
		this.q = q;
		this.t = new Thread(this);
		this.t.start();
	}

	@Override
	public void run() {
		while (true) {
			q.get();
		}
	}
}

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Ctrl+C to stop");
	}
}

package _20_multithreading._08_deadlock_livelock_starvation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LiveLockExample {

	private final Lock lock1 = new ReentrantLock(true);
	private final Lock lock2 = new ReentrantLock(true);

	public static void main(String[] args) {
		LiveLockExample liveLock = new LiveLockExample();
		new Thread(liveLock::operation1, "T1").start();
		new Thread(liveLock::operation2, "T2").start();
	}

	public void operation1() {
		while (true) {
			tryLock(lock1, 50);
			System.out.println("lock1 acquired, trying to acquire lock2.");
			try {
				sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			try {
				if (tryLock(lock2)) {
					System.out.println("lock2 acquired.");
				} else {
					System.out.println("cannot acquire lock2, releasing lock1.");
					lock1.unlock();
					continue;
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			System.out.println("executing first operation.");
			break;
		}
		lock2.unlock();
		lock1.unlock();
	}

	public void operation2() {
		while (true) {
			tryLock(lock2, 50);
			System.out.println("lock2 acquired, trying to acquire lock1.");
			try {
				sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			try {
				if (tryLock(lock1)) {
					System.out.println("lock1 acquired.");
				} else {
					System.out.println("cannot acquire lock1, releasing lock2.");
					lock2.unlock();
					continue;
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			System.out.println("executing second operation.");
			break;
		}
		lock1.unlock();
		lock2.unlock();
	}


	// helper methods
	private boolean tryLock(Lock lock) throws InterruptedException {
		return tryLock(lock, 50);
	}

	private boolean tryLock(Lock lock, int millis) {
		try {
			return lock.tryLock(millis, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
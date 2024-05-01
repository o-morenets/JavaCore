package _20_multithreading._19_runnablevscallable.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EventLoggingTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Message");
	}

	public void executeTask() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new EventLoggingTask());
		executorService.shutdown();
	}

	public static void main(String[] args) {
		new Thread(new EventLoggingTask()).start();
	}
}
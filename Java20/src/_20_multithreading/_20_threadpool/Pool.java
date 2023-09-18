package _20_multithreading._20_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Pool {

	public static void main(String[] args) {
//		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//		executor.submit(() -> {
//			Thread.sleep(1000);
//			return null;
//		});
//		executor.submit(() -> {
//			Thread.sleep(1000);
//			return null;
//		});
//		executor.submit(() -> {
//			Thread.sleep(1000);
//			return null;
//		});

		new Thread().start();
	}
}

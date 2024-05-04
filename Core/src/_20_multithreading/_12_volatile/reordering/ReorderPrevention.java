package _20_multithreading._12_volatile.reordering;

/**
 * Prevent reordering using volatile
 */
public class ReorderPrevention {
	private volatile int a = 2;
	private boolean flg = false;

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("i = " + i);
			ReorderPrevention reorderExample = new ReorderPrevention();
			Thread thread1 = new Thread(reorderExample::method1);
			Thread thread2 = new Thread(reorderExample::method2);
			thread1.start();
			thread2.start();
		}
	}

	public void method1() {
		a = 1;
		flg = true;
	}

	public void method2() {
		if (flg) {
			System.out.println("\ta = " + a);
		}
	}
}
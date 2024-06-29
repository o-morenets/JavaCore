package _15_exceptions._05_finally;

public class FinallyDemo {

	static void procA() {
		try {
			System.out.println("In procA()"); // 1
			throw new RuntimeException("Demo"); // 3
		} finally {
			System.out.println("finally in procA()"); // 2
		}
	}

	static void procB() {
		try {
			System.out.println("In procB()"); // 5
			return;
		} finally {
			System.out.println("finally in procB()"); // 6
		}
	}

	static void procC() {
		try {
			System.out.println("In procC()"); // 7
		} finally {
			System.out.println("finally in procC()"); // 8
		}
	}

	public static void main(String[] args) {
		try {
			procA();
		} catch (Exception e) {
			System.out.println("Exception was caught: " + e); // 4
		}
		procB();
		procC();
	}
}

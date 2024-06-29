package _15_exceptions._05_finally;

public class TryReturnFinallyReturn {

	// The finally-block can "override" throw/return using another throw/return

	public static void main(String[] args) {
		System.err.println(f());
	}

	// this method must return a value either from try or finally OR System.exit() OR throw an Exception
	public static int f() {
		try {
			System.out.println("try...");
//			return 0;
			// or
//			throw new RuntimeException();
		} finally {
			System.out.println("finally...");
			return 1;
			// or
//			throw new RuntimeException();
		}
		// or
//		throw new RuntimeException();
	}

	// >> 1
}

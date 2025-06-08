package _15_exceptions._06_nested_try_catch_finally;

public class NoException {

	// Nested try-catch-finally without any exception

	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			try {
				System.err.print(" 1");
				// NOTHING
				System.err.print(" 2");
			} catch (RuntimeException e) {
				System.err.print(" 3"); // NOT entered – no exception
			} finally {
				System.err.print(" 4"); // always entered
			}
			System.err.print(" 5");     // entered – execution proceeds normally
		} catch (Exception e) {
			System.err.print(" 6");     // NOT entered – no exception
		} finally {
			System.err.print(" 7");     // always entered
		}
		System.err.print(" 8");         // entered – execution proceeds normally
	}

	// >> 0 1 2 4 5 7 8
}

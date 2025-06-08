package _15_exceptions._06_nested_try_catch_finally;

public class ExceptionCaughtByOuterCatch {

	// Nested try-catch-finally with an exception that is CAUGHT BY THE OUTER catch

	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			try {
				System.err.print(" 1");
				if (true) {
					throw new Exception();
				}
				System.err.print(" 2");
			} catch (RuntimeException e) {
				System.err.print(" 3"); // NOT entered – there is an exception, but of the WRONG TYPE
			} finally {
				System.err.print(" 4"); // always entered
			}
			System.err.print(" 5");     // not entered – execution is NOT normal
		} catch (Exception e) {
			System.err.print(" 6");     // ENTERED – there is a matching exception
		} finally {
			System.err.print(" 7");     // always entered
		}
		System.err.print(" 8");         // entered – execution is ALREADY normal
	}

	// >> 0 1 4 6 7 8
}

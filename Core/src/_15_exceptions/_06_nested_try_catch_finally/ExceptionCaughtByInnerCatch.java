package _15_exceptions._06_nested_try_catch_finally;

public class ExceptionCaughtByInnerCatch {

	// Nested try-catch-finally with an exception that is CAUGHT BY THE INNER catch

	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			try {
				System.err.print(" 1");
				if (true) {
					throw new RuntimeException();
				}
				System.err.print(" 2");
			} catch (RuntimeException e) {
				System.err.print(" 3"); // WE ENTER HERE – there is an exception
			} finally {
				System.err.print(" 4"); // always executed
			}
			System.err.print(" 5");     // executed – execution is already back to normal
		} catch (Exception e) {
			System.err.print(" 6");     // not executed – no exception, it was ALREADY caught
		} finally {
			System.err.print(" 7");     // always executed
		}
		System.err.print(" 8");         // executed – execution is already back to normal
	}

	// >> 0 1 3 4 5 7 8
}

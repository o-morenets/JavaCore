package _15_exceptions._06_nested_try_catch_finally;

public class ExceptionNotCaught {

	// Nested try-catch-finally with an exception that NO ONE WILL CATCH

	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			try {
				System.err.print(" 1");
				if (true) {
					throw new Error();
				}
				System.err.print(" 2");
			} catch (RuntimeException e) {
				System.err.print(" 3"); // NOT entered – there is an exception, but of the WRONG TYPE
			} finally {
				System.err.print(" 4"); // always entered
			}
			System.err.print(" 5");     // NOT entered – execution is NOT normal
		} catch (Exception e) {
			System.err.print(" 6");     // NOT entered – there is an exception, but of the WRONG TYPE
		} finally {
			System.err.print(" 7");     // always entered
		}
		System.err.print(" 8");         // NOT entered – execution is NOT normal
	}

	// >> 0 1 4 7Exception in thread "main" java.lang.Error
}

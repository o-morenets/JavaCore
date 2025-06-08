package _15_exceptions._03_multiple_catches;

public class AppMultipleNoCatch {

	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			if (true) {
				throw new RuntimeException();
			}
			System.err.print(" 1");
		} catch (RuntimeException e) {	// caught RuntimeException
			System.err.print(" 2");
			if (true) {
				throw new Error();
			} // and threw a new Error
		} catch (Error e) { // although there is a catch for Error "below", we do not reach it
			System.err.print(" 3");
		}
		System.err.println(" 4");
	}

	// >> 0 2
	// >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error

	// Note: we did not print “3” even though an Error was thrown and there is a catch for Error below.
	// But the important point is that a catch applies exclusively to the try block, not to other catch blocks.
}

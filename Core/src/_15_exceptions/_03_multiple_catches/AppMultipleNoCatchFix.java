package _15_exceptions._03_multiple_catches;

public class AppMultipleNoCatchFix {

	public static void main(String[] args) {
		try {
			System.err.print(" 0");
			if (true) {
				throw new RuntimeException();
			}
			System.err.print(" 1");
		} catch (RuntimeException e) { // caught RuntimeException
			System.err.print(" 2.1");
			try {
				System.err.print(" 2.2");
				if (true) {
					throw new Error();
				} // and threw a new Error
				System.err.print(" 2.3");
			} catch (Throwable t) {            // caught Error
				System.err.print(" 2.4");
			}
			System.err.print(" 2.5");
		} catch (Error e) { // although there is a catch for Error "below", we do not reach it
			System.err.print(" 3");
		}
		System.err.println(" 4");
	}

	// >> 0 2.1 2.2 2.4 2.5 4
}

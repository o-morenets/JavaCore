package _15_exceptions._13_unchecked;

public class ThrowsRTE {

	// Calling a method that "declares" an unchecked exception does not impose any obligations on us.

	public static void main(String[] args) {
		f();
	}

	public static void f() throws RuntimeException {
	}
}

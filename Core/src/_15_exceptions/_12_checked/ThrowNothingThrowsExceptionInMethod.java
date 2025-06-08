package _15_exceptions._12_checked;

// Even if we declare to throw something that doesn't actually happen — everyone must still be prepared

public class ThrowNothingThrowsExceptionInMethod {

	public static void main(String[] args) {
//        f(); // compilation error here
	}

	public static void f() throws Exception {
	}
}

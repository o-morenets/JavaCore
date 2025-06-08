package _15_exceptions._12_checked;

public class ThrowButNotHandle {

	// We cannot throw without declaring it

	public static void main(String[] args) {
//        throw new Exception(); // here is a compilation error
	}

	// >> COMPILATION ERROR: unhandled exception: java.lang.Exception
}

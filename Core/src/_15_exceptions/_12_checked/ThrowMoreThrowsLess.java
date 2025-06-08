package _15_exceptions._12_checked;

// We cannot throw more, but declare less

import java.io.IOException;

public class ThrowMoreThrowsLess {

	public static void main(String[] args) throws IOException {
//        throw new Exception(); // compilation error here
	}

	// >> COMPILATION ERROR: unhandled exception: java.lang.Exception
}

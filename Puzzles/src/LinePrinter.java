public class LinePrinter {
	public static void main(String[] args) {
		// When uncomment block comment, it won't compile
/*
// Note: \u000A is Unicode representation of linefeed (LF)
*/
		char c = 0x000A;
		System.out.println(c);
	}
}
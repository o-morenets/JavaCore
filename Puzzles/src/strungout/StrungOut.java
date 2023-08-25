package strungout;

public class StrungOut {
	public static void main(String[] args) { // Wrong signature of main method, because uses OUR own class String
		String s = new String("Hello world");
		System.out.println(s);
	}
}

class String {
	private final java.lang.String s;

	public String(java.lang.String s) {
		this.s = s;
	}

	public java.lang.String toString() {
		return s;
	}
}
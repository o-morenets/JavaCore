public class BigDelight {
	public static void main(String[] args) {
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			if (b == 0x90) // 0x90 (decimal 144) is of type int here, so when comparing, b will be cast to an int. But range of b is -128..127 and never reaches 144
				System.out.print("Joy!"); // won't print ever
		}
	}
}
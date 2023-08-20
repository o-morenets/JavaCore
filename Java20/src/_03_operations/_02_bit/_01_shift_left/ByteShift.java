package _03_operations._02_bit._01_shift_left;

public class ByteShift {

	public static void main(String[] args) {
		byte a = 64; // 01000000
		byte b;
		int i;

		i = a << 2; // 00000000 00000000 00000001 00000000 == 256 (int)
		b = (byte) (a << 2); // 00000000 00000000 00000001 [00000000] == 0

		System.out.println("a = " + a); // 64
		System.out.println("i = " + i); // 256
		System.out.println("b = " + b); // 0
	}
}

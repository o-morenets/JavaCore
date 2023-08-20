package _03_operations._02_bit._01_shift_left;

public class MultByTwo {

	public static void main(String[] args) {
		int i;
		int num = 0xffffffe; // 00001111 11111111 11111111 11111110
		System.out.println("num = " + num); // 268435454

		// step 0: 00011111 11111111 11111111 11111100 // 536870908
		// step 1: 00111111 11111111 11111111 11111000 // 1073741816
		// step 2: 01111111 11111111 11111111 11110000 // 2147483632
		// step 3: 11111111 11111111 11111111 11100000 // -32
		for (i = 0; i < 4; i++) {
			num <<= 1;
			System.out.println(num);
		}
	}
}

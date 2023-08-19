package _03_operations._02_bit._03_shift_right_unsigned;

public class ByteUShift {

	public static void main(String[] args) {
		char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		byte b = (byte) 0xf1; // 1111 0001
		byte c = (byte) (b >> 4); // 1111 1111
		byte d = (byte) (b >>> 4);
		byte e = (byte) ((b & 0xff) >> 4);
		
		System.out.println("b = 0x" +               hex[(b >> 4) & 0x0f] + hex[b & 0x0f]); // b = 0xf1
		System.out.println("b >> 4 = 0x" +          hex[(c >> 4) & 0x0f] + hex[c & 0x0f]); // b >> 4 = 0xff
		System.out.println("b >>> 4 = 0x" +         hex[(d >> 4) & 0x0f] + hex[d & 0x0f]); // b >>> 4 = 0xff
		System.out.println("(b & 0xff) >> 4 = 0x" + hex[(e >> 4) & 0x0f] + hex[e & 0x0f]); // (b & 0xff) >> 4 = 0x0f
	}
	
}

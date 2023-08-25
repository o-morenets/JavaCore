public class BigDelight {
	public static void main(String[] args) {
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			if (b == 0x90) // 0x90 (decimal 144) is of type int here, so when comparing, b will be cast to an int. But range of b is -128..126 and never reaches 144
				System.out.print("Joy!"); // won't print ever
		}
	}
	// Fix: if ((b & 0xff) == 0x90) - to consider b as unsigned (it will break byte range into two sub-ranges: 128..255 and 0..126)
	// or: if (b == (byte)0x09) // (byte)0x09 == -112 which is in the range of byte type
}
package _00_types._00_integers;

/**
 * Print all binary byte values
 * Created by Oleksii on 21.07.2017.
 */
public class ByteRangeToBinaryString {

    public static void main(String[] args) {

        byte b = -128;
//        for (b = -128; b <= 127; b++) { // can not use for loop (next after 127 is -128 and loop will never stop)
        while (b <= 127) {
            System.out.println(b + ":\t" + Integer.toBinaryString((b & 0xff) + 0x100).substring(1));
            // as Integer.toBinaryString() accepts int as argument, we should take only last byte
            // (b & 0xff) - consider only last byte
            // also, Integer.toBinaryString() trims leading zeroes, so we add 0x100 (which is 0b1_00000000) and take substring without this "leading" 1
            if (b++ == 127)
                break;
        }
        // after break b == -128 (again)
        System.out.println("b = " + b); // b = -128
    }
}

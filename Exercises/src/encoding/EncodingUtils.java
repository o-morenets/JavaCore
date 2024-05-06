package encoding;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;

public class EncodingUtils {

    public static final String SECRET_KEY =
            "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970"; // QE5jUmZValhuMnI1dTh4L0E/RChHK0tiUGRTZ1ZrWXA=

    public static final String ANOTHER_HEX_KEY =
            "49276d206b696c6c696eeb20796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f"; // SSdtIGtpbGxpbusgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hybw==

    public static final int NUM_BYTES_PER_PACK = 3;
    public static final int NUM_OUTPUT_BITS = 6;
    public static final int NUM_INPUT_BITS = 8;
    public static final String BASE_64_ALPHABET = "ABCDEFGHIJKLMNOPQRTSUVWXYZabcdefghijklmnopqrtsuvwxyz0123456789+/";

    public static void main(String[] args) {
        System.out.println(Base64.getEncoder().encodeToString(new BigInteger(SECRET_KEY, 16).toByteArray()));
        System.out.println(hexStringToBase64(SECRET_KEY));

        System.out.println(Base64.getEncoder().encodeToString(new BigInteger(ANOTHER_HEX_KEY, 16).toByteArray()));
        System.out.println(hexStringToBase64(ANOTHER_HEX_KEY));

        System.out.println("qw== : " + hexStringToBase64("ab"));
        System.out.println("q80= : " + hexStringToBase64("abcd"));
        System.out.println("q83v : " + hexStringToBase64("abcdef"));
    }

    private static String hexStringToBase64(String hexString) {
        return bytesToBase64(hexDigitsToBytes(hexString));
    }

    private static byte[] hexDigitsToBytes(String hexString) {
        if (hexString.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected even number of characters.");
        }

        byte[] byteArray = new byte[hexString.length() / 2];

        for (int i = 0; i < hexString.length(); i += 2) {
            byte b1 = hexCharToByte(hexString.charAt(i));
            byte b2 = hexCharToByte(hexString.charAt(i + 1));
            byteArray[i / 2] = (byte) (b1 << 4 | b2);
        }

        return byteArray;
    }

    private static byte hexCharToByte(char c) {
        final String hexChars = "0123456789ABCDEF";
        int index = hexChars.indexOf(Character.toUpperCase(c));

        if (index < 0) {
            throw new IllegalArgumentException("Hex numbers allowed only.");
        }

        return (byte) index;
    }

    private static String bytesToBase64(byte[] hexBytes) {
        int count = 0;
        byte[] threeBytesArray = new byte[NUM_BYTES_PER_PACK];
        StringBuilder sb = new StringBuilder();

        for (byte hexByte : hexBytes) {
            threeBytesArray[count % NUM_BYTES_PER_PACK] = hexByte;

            if (++count % NUM_BYTES_PER_PACK == 0) {
                sb.append(processBytes(threeBytesArray, NUM_BYTES_PER_PACK));
                Arrays.fill(threeBytesArray, (byte) 0);
            }
        }

        if (count % NUM_BYTES_PER_PACK != 0) {
            sb.append(processBytes(threeBytesArray, count % NUM_BYTES_PER_PACK));
        }

        return sb.toString();
    }

    private static String processBytes(byte[] threeBytesArray, int numBytes) {
        int res = 0;
        int i;
        for (i = 0; i < numBytes; i++) {
            res <<= NUM_INPUT_BITS;
            res |= threeBytesArray[i] & 0xff;
        }
        for (int j = 0; j < NUM_BYTES_PER_PACK - i; j++) {
            res <<= NUM_INPUT_BITS;
        }
        return convertToFourCharacterString(res, numBytes);
    }

    private static String convertToFourCharacterString(int bytesInInt, int numInBytes) {
        int numOutBytes = (int) Math.ceil(numInBytes * ((double) NUM_INPUT_BITS) / NUM_OUTPUT_BITS);
        int mask = 0b111111_000000_000000_000000;
        int resultShift = NUM_BYTES_PER_PACK * NUM_OUTPUT_BITS;
        StringBuilder sbResult = new StringBuilder("====");

        for (int i = 0; i < numOutBytes; i++) {
            sbResult.setCharAt(i, idxToChar((bytesInInt & mask) >> resultShift));
            mask >>= NUM_OUTPUT_BITS;
            resultShift -= NUM_OUTPUT_BITS;
        }

        return sbResult.toString();
    }

    private static char idxToChar(int idx) {

        // A..Z
        if (idx >= BASE_64_ALPHABET.indexOf('A') && idx <= BASE_64_ALPHABET.indexOf('Z')) {
            return (char) ('A' + idx - BASE_64_ALPHABET.indexOf('A'));
        }

        // a..z
        if (idx >= BASE_64_ALPHABET.indexOf('a') && idx <= BASE_64_ALPHABET.indexOf('z')) {
            return (char) ('a' + idx - BASE_64_ALPHABET.indexOf('a'));
        }

        // 0..9
        if (idx >= BASE_64_ALPHABET.indexOf('0') && idx <= BASE_64_ALPHABET.indexOf('9')) {
            return (char) ('0' + idx - BASE_64_ALPHABET.indexOf('0'));
        }

        // +
        if (idx == BASE_64_ALPHABET.indexOf('+')) {
            return '+';
        }

        // /
        if (idx == BASE_64_ALPHABET.indexOf('/')) {
            return '/';
        }

        return 0;
    }
}

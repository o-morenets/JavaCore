
package stackOverflow.doubleToShort;

public class Main {
    public static void main(String[] args) {
        double x = 389889877779.89;

        long l = Double.doubleToRawLongBits(x);
        System.out.println(l);
        String s = Long.toBinaryString(l);
        System.out.println(s);

        System.out.println((short)x);
    }
}

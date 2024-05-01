package misc;

public class Misc {

    public static void main(String[] args) {

        System.out.println("While");
        whileTest();

        System.out.println("unaryOps");
        unaryOps();

        System.out.println("forLoops");
        forLoops();

        System.out.println("x | (x - 1)");
        clearRightmostBit();

        System.out.println(">>>");
        shift();

        System.out.println("x+++y");
        int x = 1;
        int y = 1;
        System.out.println(x+++y); // 2
        x = 1;
        y = 1;
        System.out.println(x+ ++y); // 3
        x = 1;
        y = 1;
        System.out.println(x++ +y); // 2

        x = 11;
        x = ++x- --x+--x-x+++--x;
    }

    private static void shift() {
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 >>> 2));
    }

    private static void clearRightmostBit() {
        int x = 32; // 0b111111
        System.out.println(x | (x - 1)); // 63 - wrong

        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.toBinaryString(i));
            System.out.println(Integer.toBinaryString(i - 1));
            System.out.println(Integer.toBinaryString(i | (i - 1)));
            System.out.println();
        }
    }

    // Prints "Outer:Outer:" - correct
    private static void forLoops() {
        String[] classes = {"Outer", "Inner"};
        for (String outer : classes) {
            for (String inner : classes) {
                if (inner.equals("Inner"))
                    break;
                System.out.print(inner + ":");
            }
        }
    }

    private static void unaryOps() {
        int a = 10;
        a = a++ + ++a - a + a-- + ++a;
        System.out.println(a); //
    }

    private static void whileTest() {
        int i = 10;
        while (++i > 20) {
            i++;
        }
        System.out.println(i); // 11 - correct
    }
}

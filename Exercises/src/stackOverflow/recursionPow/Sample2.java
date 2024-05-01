package stackOverflow.recursionPow;

public class Sample2 {

    public static int pow(int x, int y) {
        if (y == 0) return 1;
        return x * pow(x, y - 1);
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(pow(3, 2));
        System.out.println(pow(2, 10));
    }
}

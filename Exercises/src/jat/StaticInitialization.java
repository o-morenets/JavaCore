package jat;

public class StaticInitialization {
    static {
        a = 6;
    }

    static int a = 5;

    public static void main(String[] args) {
        System.out.println(a); // 5
    }
}

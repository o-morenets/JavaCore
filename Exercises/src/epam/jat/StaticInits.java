package epam.jat;

public class StaticInits {

    public static void main(String[] args) {
        try {
            A1 ab = new B1();
        } catch (Throwable e) {
            System.out.println("caught!!!");
            e.printStackTrace();
        }
        System.out.println(A1.a);
        System.out.println(B1.b);

        B1 b = new B1();
    }
}

class A1 {
    public static final String a = "abc";
    public static int i = 0;

    static {
        System.out.println("in A1");
        i = Integer.parseInt(a);
    }
}

class B1 extends A1 {
    public static final String b = "class B1";
    public static int i = 0;

    static {
        System.out.println("in B1");
        i = Integer.parseInt("23");
    }
}

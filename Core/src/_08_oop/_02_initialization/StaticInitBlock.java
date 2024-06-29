package _08_oop._02_initialization;

public class StaticInitBlock {

    static {
        System.out.println("In static block");
        main(null);
    }

    public static void main(String[] args) {
        System.out.println("In main()");
        System.exit(-1);
        throw new Error();
    }
}

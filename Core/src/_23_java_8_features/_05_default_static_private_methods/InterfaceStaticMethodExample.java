package _23_java_8_features._05_default_static_private_methods;


interface MyData {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }
}

public class InterfaceStaticMethodExample implements MyData {

    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null ? true : false;
    }

    public static void main(String args[]) {
        InterfaceStaticMethodExample obj = new InterfaceStaticMethodExample();
        obj.print("");
        obj.isNull("abc");
    }
}

package _23_java_8_features._05_default_static_private_methods;

interface Foo {

    // Non-static
    default void bar() {
        System.out.print("Hello");
        baz();
    }

    private void baz() {
        System.out.println(" world!");
    }


    // Static
    static void buzz() {
        System.out.print("Hello");
        staticBaz();
    }

    private static void staticBaz() {
        System.out.println(" static world!");
    }

}

public class InterfacePrivateMethodsExample implements Foo {

    public static void main(String[] args) {
        Foo customFoo = new InterfacePrivateMethodsExample();
        customFoo.bar(); // calling non-static method
        Foo.buzz(); // calling static method
    }
}

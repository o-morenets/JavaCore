package _14_inner_classes._03_inner_static;

class OuterClass {
    static int data = 10;
    String str = "Hello";

    // Static nested class
    // * Can access static data members and methods of the outer class.
    // * Cannot access non-static data members and methods of the outer class directly.
    // * Can be instantiated independently of the outer class instance.
    static class StaticNestedClass {
        void display() {
            System.out.println("Data: " + data);
//            System.out.println("s = " + str); // Cannot access non-static data members and methods of the outer class directly.
        }
    }
}

public class InnerStaticClassSimple {
    public static void main(String[] args) {
        // Instantiating static nested class without outer class instance
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.display();  // Output: Data: 10
    }
}

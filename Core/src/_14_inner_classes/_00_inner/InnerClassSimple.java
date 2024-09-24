package _14_inner_classes._00_inner;

class OuterClass {
    int data = 20;

    // Non-static inner class
    // * Can access both static and non-static members of the outer class.
    // * Needs an instance of the outer class to be instantiated.
    // * Helps in logically grouping classes used only by the outer class.
    class InnerClass {
        void display() {
            System.out.println("Data: " + data);
        }
    }
}

public class InnerClassSimple {
    public static void main(String[] args) {
        // Instantiating the outer class
        OuterClass outer = new OuterClass();
        // Instantiating inner class using the outer class instance
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();  // Output: Data: 20
    }
}

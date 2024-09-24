package _14_inner_classes;

// TopLevelExample.java
// In Java, a .java file can only have one public class, and that class's name must match the filename.
// Other classes in the same file must be package-private (i.e., have no access modifier).

class OuterClass {
    private int outerValue = 10;

    // Inner class
    class InnerClass {
        void display() {
            System.out.println("Outer value: " + outerValue); // Can access private members
        }
    }
}

class AnotherClass {
    public void display() {
        System.out.println("This is a top-level class, not an inner class.");
    }
}

public class TopLevelExample {
    public static void main(String[] args) {
        // Inner class instantiation requires an outer class instance
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();  // Output: Outer value: 10

        // Top-level class can be instantiated normally
        AnotherClass another = new AnotherClass();
        another.display();  // Output: This is a top-level class, not an inner class.
    }
}

package _14_inner_classes._01_inner_local;

class OuterClass {
    void display() {
        int number = 30;  // Final or effectively final

        // Local inner class within a method
        // * Can access variables from the enclosing method or block if they are final or effectively final.
        // * It is not accessible outside the method or block.
        class LocalInnerClass {
            void print() {
                System.out.println("Number: " + number);
            }
        }

        // Creating an instance of the local inner class
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.print();  // Output: Number: 30
    }
}

public class InnerLocalClassSimple {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}

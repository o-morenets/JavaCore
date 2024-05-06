package epam.jat;

public class AB {

    public static void main(String[] args) {

        ClassA a = new ClassA();
        a.methodOne(1);
        a.methodTwo(2);

        ClassB b = new ClassB();
        b.methodOne(1);
        b.methodTwo(2);
        b.methodTwo(Integer.valueOf(2));

        ClassA ab = new ClassB();
        ab.methodOne(1);
        ab.methodTwo(2);
        ab.methodTwo(Integer.valueOf(2));
        ((ClassB) ab).methodTwo(Integer.valueOf(2));

        ClassA.methodFour(4);
        ClassB.methodFour(4);
    }
}

/**
 * Which method overrides a method in the superclass?
 * Which method hides a method in the superclass?
 * What do the other methods do?
 */

class ClassA {
    public void methodOne(int i) {
        System.out.println("A1: " + i);
    }

    public void methodTwo(int i) {
        System.out.println("A2: " + i);
    }

    public static void methodThree(int i) {
        System.out.println("A3: " + i);
    }

    public static void methodFour(int i) {
        System.out.println("A4: " + i);
    }

    private void methodFive() {
        System.out.println("A5");
    }

    public final void methodSAix() {

    }
}

class ClassB extends ClassA {
//    public static void methodOne(int i) {} // Static method 'methodOne(int)' cannot override instance method 'methodOne(int)'

    public void methodTwo(int i) {
        System.out.println("int B2: " + i); // Overrides
    }

    public void methodTwo(Integer i) {
        System.out.println("Integer B2: " + i); // separate method
    }

//    public void methodThree(int i) {} // Instance method 'methodThree(int)' cannot override static method 'methodThree(int)'

    public static void methodFour(int i) {
        System.out.println("B4: " + i); // Hides
    }

    private void methodFive() {
        System.out.println("B5");
    }

//    public final void methodSAix() {} // cannot override
}
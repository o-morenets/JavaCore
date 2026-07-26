package _08_oop._00_class.classLoader;

public class NoClassDefFoundErrorExample {

    public static void main(String[] args) {

        try {
            BrokenClass.doSomething(); // step 1: classLoader loads class
        } catch (Throwable e) {
            System.out.println(e);
        }

        System.out.println("Second attempt:");

        BrokenClass.doSomething();
    }
}


class BrokenClass {

    static {
        if (true) {
            throw new RuntimeException("Initialization failed"); // step 2: class initialization leads to ErrorInInitializerError
                                                                 // so, class marked as 'failed initialization'
        }
    }

    static void doSomething() {
        System.out.println("Hello");
    }
}

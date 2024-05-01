package jat.classExceptions;

/**
 * <a href="https://www.baeldung.com/java-classnotfoundexception-and-noclassdeffounderror">ClassNotFoundException vs NoClassDefFoundError</a>
 */
public class ClassWithInitErrors {

    static int data = 1 / 0;
}

class NoClassDefFoundErrorExample {

    public static ClassWithInitErrors getClassWithInitErrors() {

        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t); // java.lang.ExceptionInInitializerError
        }

        //If we try to load the same class again, we get the NoClassDefFoundError:
        test = new ClassWithInitErrors(); // Exception in thread "main" java.lang.NoClassDefFoundError

        return test;
    }

    public static void main(String[] args) {
        getClassWithInitErrors();
    }
}
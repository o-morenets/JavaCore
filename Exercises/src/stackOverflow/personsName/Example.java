package stackOverflow.personsName;

public class Example {

    public Example someMethod() {
        System.out.println("Hello");
        return this;
    }

    public Example anotherMethod() {
        System.out.println("World");
        return this;
    }

    public static void main(String[] args) {
        Example obj = new Example();
        obj.someMethod().anotherMethod();
    }
}
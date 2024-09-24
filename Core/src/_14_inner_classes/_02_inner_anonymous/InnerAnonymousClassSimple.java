package _14_inner_classes._02_inner_anonymous;

interface Greeting {
    void sayHello();
}

public class InnerAnonymousClassSimple {
    public static void main(String[] args) {
        // Anonymous inner class implementing an interface
        // * Can be used to create instances of interfaces or abstract classes.
        // * Cannot have explicit constructors since they have no name.
        // * Mostly used for event handling and functional programming (e.g., in lambdas or listeners).
        Greeting greeting = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from the anonymous class!");
            }
        };

        greeting.sayHello();  // Output: Hello from the anonymous class!
    }
}

package _08_oop._03_inheritance._01_encapsulation;

public class EncapsulationExample {

    public static void main(String[] args) {
        First first = new Second();
        first.addFive(); // prints second
        System.out.println(first.publicValue); // prints 1 (from First class) - no encapsulation (val is public field)
        System.out.println(first.getValue()); // prints 7 (from Second class) - val encapsulated (private + getter/setter)
    }

}

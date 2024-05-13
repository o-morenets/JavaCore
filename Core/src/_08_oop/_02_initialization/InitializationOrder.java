package _08_oop._02_initialization;

public class InitializationOrder {

    public static void main(String[] args) {
        System.out.println("Creating default Vehicle..................");
        Vehicle vehicle = new Vehicle();
        System.out.println("Creating default Car..................");
        Car car = new Car();
        System.out.println("Creating Car(2)..................");
        Car car2 = new Car(2);
        System.out.println("Creating default SportsCar..................");
        SportsCar sporty = new SportsCar();
    }
}

class Vehicle {
    {
        System.out.println("Vehicle - init block"); // 2, 4, 7, 11 (invokes when object is created)
    }

    static {
        System.out.println("Vehicle - static init block"); // 1 (is invoked once, when ClassLoader loads the class)
    }

    // no explicit default constructor, but compiler creates it for us and invokes when object is created
}

class Car extends Vehicle {
    {
        System.out.println("Car - init block"); // 5, 8, 12 (invokes when object is created)
    }

    static {
        System.out.println("Car - static init block"); // 3 (is invoked once, when ClassLoader loads the class)
    }

    int i;

    // explicit default constructor
    public Car() {
        // super() is invoked here internally, no need to invoke it explicitly
        System.out.println("Inside default Car() constructor"); // 6, 13 (invokes when object is created)
    }

    public Car(int i) {
        super(); // explicitly invoke super() from non-default constructor
        this.i = i;
        System.out.println("Inside Car(int i) constructor"); // 9
    }
}

class SportsCar extends Car {
    {
        System.out.println("SportsCar - init block"); // 14
    }

    static {
        System.out.println("SportsCar - static init block"); // 10 (is invoked once, when ClassLoader loads the class)
    }

    // no explicit default constructor, but compiler creates it for us and invokes surer() from it
}
package _23_java_8_features._05_default_static_private_methods;

public class Employee implements Person {

    // both Teacher and Driver inherit getName() from Person interface,
    // but there is no need to specify which to use, as the parent interface is known (Person)

    public static void main(String[] args) {
        System.out.println(new Employee().getName()); // "Person interface"
    }
}

interface Driver extends Person {

    // inherits default method getName() from Person
}

interface Teacher extends Person {

    // inherits default method getName() from Person
}
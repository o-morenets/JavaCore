package epam.jat.binding;

public class Binding {

    public static void main(String[] args) {
        Person obj = new Teacher();
        obj.teach(); // Person teaches (static)
        obj.speak(); // Teacher speaks

        Teacher.teach(); // Person teaches
    }
}


class Person {

    public static void teach() {
        System.out.println("Person teaches");
    }

    public void speak() {
        System.out.println("Person speaks");
    }
}


class Teacher extends Person {

//    public static void teach() {
//        System.out.println("Teacher teaches");
//    }

    public void speak() {
        System.out.println("Teacher speaks");
    }
}
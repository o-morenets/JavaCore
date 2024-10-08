package _23_java_8_features._05_default_static_private_methods;

// Both Cat and Dog implement Named interface
public class Pet implements Dog, Cat {

    public static void main(String[] args) {
        System.out.println(new Pet().getName()); // "Cat - meow :)"
        // ...because method getName() in Cat is "closer" to use (Cat overrides getName(), but Dog just inherits it from Named interface)
    }
}

interface Cat extends Named {

    // overrides Named's default method getName(), so it is "closer" to caller (see Dog and Pet)

    @Override
    default String getName() {
        return "Cat - meow :)";
    }
}

interface Dog extends Named {

    // inherits default method getName() from Named interface
}

package _23_java_8_features._05_default_and_static_methods;

public interface Cat extends Named {

    // overrides Named's default method getName(), so it is "closer" to caller (see Dog and Pet)

    @Override
    default String getName() {
        return "Cat - meow :)";
    }
}

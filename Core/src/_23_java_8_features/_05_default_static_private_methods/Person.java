package _23_java_8_features._05_default_static_private_methods;

public interface Person {

	String NAME = "Person interface";

	default String getName() {
		return NAME;
	}

	static void print() {
		System.out.println(NAME);
	}
}

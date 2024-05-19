package _23_java_8_features._05_default_and_static_methods;

public interface Named {

	String NAME = "Named interface";

	default String getName() {
		return NAME;
	}

	static void print() {
		System.out.println(NAME);
	}
}

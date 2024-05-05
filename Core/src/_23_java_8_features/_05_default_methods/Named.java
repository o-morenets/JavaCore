package _23_java_8_features._05_default_methods;

public interface Named {

	default String getName() {
		return getClass().getName() + "_" + hashCode();
	}
}
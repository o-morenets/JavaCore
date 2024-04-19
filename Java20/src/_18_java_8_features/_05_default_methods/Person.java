package _18_java_8_features._05_default_methods;

public interface Person {

	default String getName() {
		return getClass().getName() + "_" + hashCode();
	}
}

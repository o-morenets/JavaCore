package _23_java_8_features._05_default_methods;

public class Student implements Person, Named {

	// conflict resolution with getName():
	@Override
	public String getName() {
		return Person.super.getName();
	}
}

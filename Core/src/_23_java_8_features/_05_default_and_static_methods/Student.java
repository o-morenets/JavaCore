package _23_java_8_features._05_default_and_static_methods;

public class Student implements Person, Named {

	// conflict resolution with getName():
	@Override
	public String getName() {
		return Person.super.getName(); // specify which to return

		// or override as we want
//		return "Student class";
	}
}

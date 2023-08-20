package _08_oop._00_classes.classexample;

public class Person {

	public static void speak() {
		System.out.println("Person speaks");
	}

	final void go() {
		System.out.println("Going home...");
	}
}

class Teacher extends Person {

//    public void go() {} // overridden method is final

	public static void speak() {
		System.out.println("Teacher speaks");
	}

	public static void teach() {
		System.out.println("Teacher is always right!!!");
	}

	public static void main(String[] args) {
		Person obj1 = new Person();
		obj1.speak();
		((Teacher) obj1).teach(); // ClassCastException
	}
}
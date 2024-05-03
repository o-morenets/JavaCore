package _08_oop.oop_principles._03_encapsulation;


public class Second extends First {

	int publicValue = 2;
	private int value = 2;

	@Override
	void addFive() {
		System.out.println("addFive in Second");
		value += 5;
	}

	@Override
	public int getValue() {
		System.out.println("getValue in Second");
		return value;
	}
}

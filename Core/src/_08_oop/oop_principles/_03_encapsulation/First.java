package _08_oop.oop_principles._03_encapsulation;

public class First {

	int publicValue = 1;
	private int value = 1;

	void addFive() {
		System.out.println("addFive in First");
		value += 5;
	}

	public int getValue() {
		System.out.println("getValue in First");
		return value;
	}
}

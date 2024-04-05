package _08_oop.principles._01_polymorphism;

public class Manager extends Employee {

	private double bonus;
	int favNumber = 999;

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}

	@Override
	public int getFavNumber() {
		System.out.println("Getter from " + getClass().getName());
		return favNumber;
	}

	@Override
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}

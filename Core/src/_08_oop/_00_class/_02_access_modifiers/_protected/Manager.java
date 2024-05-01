package _08_oop._00_class._02_access_modifiers._protected;

public class Manager extends Employee {

	private double bonus;

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}

	@Override
	public double getSalary() {
		double baseSalary = this.salary; // access to protected field
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}

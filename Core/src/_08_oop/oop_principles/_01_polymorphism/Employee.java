package _08_oop.oop_principles._01_polymorphism;

import java.time.LocalDate;

public class Employee {

	private String name;
	private double salary;
	private LocalDate hireDay;
	int empNumber = 11111;
	int favNumber = 123;

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public int getFavNumber() {
		System.out.println("Getter from " + getClass().getName());
		return favNumber;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}

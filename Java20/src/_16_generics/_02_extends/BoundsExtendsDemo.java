package _16_generics._02_extends;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class Stats<T extends Number> {

	T[] nums;

	public Stats(T[] nums) {
		this.nums = nums;
	}

	double average() {
		double sum = 0.0;
		for (T num : nums) {
			sum += num.doubleValue();
		}
		return sum / nums.length;
	}
}

public class BoundsExtendsDemo {

	public static void main(String[] args) {
		Integer[] iNums = {1, 2, 3, 4, 5};
		Stats<Integer> iOb = new Stats<>(iNums);
		double v = iOb.average();
		System.out.println("Average of iOb = " + v);

		Double[] dNums = {1.0, 2.0, 3.0, 4.0, 5.0};
		Stats<Double> dOb = new Stats<>(dNums);
		double w = dOb.average();
		System.out.println("Average of dOb = " + w);

		// String does not extend class Number:	
//		String[] sNums = { "1.0", "2.0", "3.0", "4.0", "5.0" };
//		Stats<String> sOb = new Stats<>(sNums);
//		double x = sOb.average();
//		System.out.println("Average of dOb = " + x);

		Manager[] managers = {new Manager(), new Executive()};
		printManagers(Arrays.stream(managers).toList());
	}

	private static void printManagers(List<? extends Employee> managers) {
//		for (Manager p : managers) { // can not use Manager, should use only bounded value, e.g. Employee
		for (Employee p : managers) {
			System.out.println(p);
		}
	}

	static class Employee {

		private String name;
		private double salary;
		private LocalDate hireDay;
	}

	static class Manager extends Employee {

		private double bonus; // new instance variable

		public double getBonus() {
			return bonus;
		}
	}

	static class Executive extends Manager {
	}
}

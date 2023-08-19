package _13_interfaces._03_cloneable;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
	private String name;
	private double salary;
	private Date hireDay;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		hireDay = new Date();
	}

	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned = (Employee) super.clone(); // invoke method Object.clone()
		cloned.hireDay = (Date) hireDay.clone(); // clone mutable fields
		return cloned;
	}

	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}

}

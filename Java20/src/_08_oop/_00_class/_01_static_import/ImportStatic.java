package _08_oop._00_class._01_static_import;

import _08_oop._00_class.classexample.Employee;

import static java.lang.System.out;

public class ImportStatic {

	public static void main(String[] args) {

		/* Class Employee was imported from another package */
		Employee harry = new Employee("Harry Hacker", 50000);

		/* All System's static methods were imported above */
		out.println("name=" + harry.getName() + ", salary=" + harry.getSalary());
	}
}

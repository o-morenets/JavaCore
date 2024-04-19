package _18_stream_api._02_stream_api.collectors.employees;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Олександр", 56),
				new Employee("Максим", 33),
				new Employee("Олексій", 25),
				new Employee("Максим", 52),
				new Employee("Іван", 33),
				new Employee("Олександр", 18)
		);

		employees.stream()
				.collect(Collectors.groupingBy(Employee::getAge)) // Map<Integer, List<Employee>>
				.forEach((age, employeeList) -> System.out.printf("Вік %s: %s\n", age, employeeList));
//        Вік 33: [Максим (33), Іван (33)]
//        Вік 18: [Олександр (18)]
//        Вік 52: [Максим (52)]
//        Вік 56: [Олександр (56)]
//        Вік 25: [Олексій (25)]

		Double avgAge = employees.stream()
				.collect(Collectors.averagingInt(Employee::getAge));

		System.out.println(avgAge); // 27.25

		IntSummaryStatistics statistics = employees.stream()
				.collect(Collectors.summarizingInt(Employee::getAge));

		System.out.println(statistics); // IntSummaryStatistics{count=4, sum=109, min=18, average=27,250000, max=33}

		// Grouping by name
		Map<String, List<Employee>> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee::getName));

		System.out.println(collect);
	}
}

package _18_stream_api._02_stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Fiter and Count examples of Stream Api
 * Created by vedenin on 17.10.15.
 */
public class FiterAndCountTests {

	private static void testFilterAndCount() {
		System.out.println("Test filter and count start");

		// ************ Work with strings
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

		// Get count of this object
		long count = collection.stream().filter("a1"::equals).count();
		System.out.println("count = " + count); // print  count = 2

		// Get all element according pattern
		List<String> select = collection.stream().filter((s) -> s.contains("1")).collect(Collectors.toList());
		System.out.println("select = " + select); // print  select = [a1, a1]

		// ************ Work with objects

		// Init collection of People
		Collection<People> peoples = Arrays.asList(
				new People("Vasja", 16, Gender.MALE),
				new People("Petja", 23, Gender.MALE),
				new People("Elena", 42, Gender.FEMALE),
				new People("Ivan", 69, Gender.MALE)
		);

		// Get man from 18 to 27 years old
		List<People> militaryService = peoples.stream().filter((p) -> p.getAge() >= 18 && p.getAge() < 27
				&& p.getSex() == Gender.MALE).collect(Collectors.toList());
		System.out.println("militaryService = " + militaryService); // print  militaryService = [{name='Petja', age=23, sex=MAN}]

		// Get average age from man
		double manAverageAge = peoples.stream().filter((p) -> p.getSex() == Gender.MALE).
				mapToInt(People::getAge).average().getAsDouble();
		System.out.println("manAverageAge = " + manAverageAge); // print  manAverageAge = 36.0

		// Get potential working people (>= 18 years and if women go to retirement in 55 years, and man in 60 years
		long peopleHowCanWork = peoples.stream().filter((p) -> p.getAge() >= 18).filter(
				(p) -> (p.getSex() == Gender.FEMALE && p.getAge() < 55) || (p.getSex() == Gender.MALE && p.getAge() < 60)).count();
		System.out.println("peopleHowCanWork = " + peopleHowCanWork); // print  manAverageAge = 2

	}

	private enum Gender {

		MALE,
		FEMALE
	}

	private static class People {

		private final String name;
		private final Integer age;
		private final Gender gender;

		public People(String name, Integer age, Gender gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		public String getName() {
			return name;
		}

		public Integer getAge() {
			return age;
		}

		public Gender getSex() {
			return gender;
		}

		@Override
		public String toString() {
			return "{" +
					"name='" + name + '\'' +
					", age=" + age +
					", sex=" + gender +
					'}';
		}
	}

	public static void main(String[] args) throws Exception {
		testFilterAndCount();
	}
}

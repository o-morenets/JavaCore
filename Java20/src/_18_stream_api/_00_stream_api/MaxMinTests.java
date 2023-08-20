package _18_stream_api._00_stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/**
 * Max and min examples of Stream Api
 * Created by vedenin on 17 .10.15.
 */
public class MaxMinTests {

	private static void testMinMax() {
		System.out.println();
		System.out.println("Test min and max start");
		// ************ Work with strings
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

		// find max value
		String max = collection.stream().max(String::compareTo).get();
		System.out.println("max " + max); // print  a3

		// find min value
		String min = collection.stream().min(String::compareTo).get();
		System.out.println("min " + min); // print  a1

		// ************ Work with objects

		// Init collection of People
		Collection<People> peoples = Arrays.asList(
				new People("Vasja", 16, Gender.MALE),
				new People("Petja", 23, Gender.MALE),
				new People("Elena", 42, Gender.FEMALE),
				new People("Ivan", 69, Gender.MALE)
		);

		// Find people with minimum age
		People older = peoples.stream().max(Comparator.comparing(People::getAge)).get();
		System.out.println("older " + older); // print  {name='Ivan', age=69, sex=MAN}

		// Find people with maximum age
		People younger = peoples.stream().min(Comparator.comparing(People::getAge)).get();
		System.out.println("younger " + younger); // print  {name='Vasja', age=16, sex=MAN}
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

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof People)) return false;
			People people = (People) o;
			return Objects.equals(name, people.name) &&
					Objects.equals(age, people.age) &&
					Objects.equals(gender, people.gender);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, age, gender);
		}
	}

	public static void main(String[] args) throws Exception {
		testMinMax();
	}
}

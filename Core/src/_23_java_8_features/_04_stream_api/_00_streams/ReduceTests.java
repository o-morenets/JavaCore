package _23_java_8_features._04_stream_api._00_streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Reduce example of Stream Api
 * Created by vedenin on 17 .10.15.
 */
public class ReduceTests {

	private static void testReduce() {
		System.out.println();
		System.out.println("Test reduce start");

		// ************ Working with numbers
		Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 2);

		// Return sum
		Integer sum = collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0); // using stream Api
		Integer sumOld = 0; // using Java 7
		for (Integer i : collection) {
			sumOld += i;
		}
		System.out.println("sum = " + sum + " : " + sumOld); // print  sum = 12 : 12


		// Return max
		Integer max1 = collection.stream().reduce((s1, s2) -> s1 > s2 ? s1 : s2).orElse(0); // using stream Api
		Integer max2 = collection.stream().reduce(Integer::max).orElse(0); // using stream Api using Integer::max
		Integer maxOld = null; // using Java 7
		for (Integer i : collection) {
			maxOld = maxOld != null && maxOld > i ? maxOld : i;
		}
		maxOld = maxOld == null ? 0 : maxOld;
		System.out.println("max = " + max1 + " : " + max2 + " : " + maxOld); // print  max1 = 4 : 4 : 4

		// Return min
		Integer min = collection.stream().reduce((s1, s2) -> s1 < s2 ? s1 : s2).orElse(0);  // using stream Api
		Integer minOld = null; // using Java 7
		for (Integer i : collection) {
			minOld = minOld != null && minOld < i ? minOld : i;
		}
		minOld = minOld == null ? 0 : minOld;
		System.out.println("min = " + min + " : " + minOld); // print  min = 1 : 1

		// Return last element
		Integer last = collection.stream().reduce((s1, s2) -> s2).orElse(0); // using stream Api
		Integer lastOld = null; // using Java 7
		for (Integer i : collection) {
			lastOld = i;
		}
		lastOld = lastOld == null ? 0 : lastOld;
		System.out.println("last = " + last + " : " + lastOld); // print  last = 2 : 2

		// Return sum of didig that more then 2
		Integer sumMore2 = collection.stream().filter(o -> o > 2).reduce((s1, s2) -> s1 + s2).orElse(0);     // using stream Api
		Integer sumMore2Old = 0; // using Java 7
		for (Integer i : collection) {
			if (i > 2) {
				sumMore2Old += i;
			}
		}
		System.out.println("sumMore2 = " + sumMore2 + " : " + sumMore2Old); // print  sumMore2 = 7 : 7

		// Return sum of odd digit
		Integer sumOdd = collection.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0); // using stream Api
		Integer sumOddOld = 0; // using Java 7
		for (Integer i : collection) {
			if (i % 2 != 0) {
				sumOddOld += i;
			}
		}
		System.out.println("sumOdd = " + sumOdd + " : " + sumOddOld); // print  sumOdd = 4 : 4

		// ************ Working with objects

		// Init collection of People
		Collection<Person> people = Arrays.asList(
				new Person("Vasyl", 16, Gender.MALE),
				new Person("Petro", 23, Gender.MALE),
				new Person("Olena", 42, Gender.FEMALE),
				new Person("Ivan", 69, Gender.MALE)
		);

		// Find oldest people
		int oldMan = people.stream()
				.filter((p) -> p.getGender() == Gender.MALE)
				.map(Person::getAge)
				.reduce((s1, s2) -> s1 > s2 ? s1 : s2)
				.orElseThrow();
		System.out.println("oldMan = " + oldMan); // print  69

		// Find younger people with "e" in name
		int younger = people.stream()
				.filter((p) -> p.getName().contains("e"))
				.mapToInt(Person::getAge)
				.reduce(Math::min)
				.orElse(0);
		System.out.println("younger = " + younger); // print  23
	}

	private enum Gender {
		MALE,
		FEMALE
	}

	private static class Person {

		private final String name;
		private final Integer age;
		private final Gender gender;

		public Person(String name, Integer age, Gender gender) {
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

		public Gender getGender() {
			return gender;
		}

		@Override
		public String toString() {
			return "{" +
					"name='" + name + '\'' +
					", age=" + age +
					", gender=" + gender +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Person)) return false;
			Person person = (Person) o;
			return Objects.equals(name, person.name) &&
					Objects.equals(age, person.age) &&
					Objects.equals(gender, person.gender);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, age, gender);
		}
	}

	public static void main(String[] args) throws Exception {
		testReduce();
	}
}

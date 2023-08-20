package _17_collections._99_multitype_maps;

import java.util.Deque;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;

public class MultitypeMaps {

	public static void main(String[] args) throws Exception {
		//        HashSet<Object> objects = new HashSet<>();
		Set<Object> objects = new TreeSet<>();
		//        objects.add(new Object());
		objects.add("This is a String");
		objects.add(new Person("Ann", 31));
		//        objects.add(31); // java.lang.String cannot be cast to java.lang.Integer because implements
		// Comparable<Integer>, not Comparable<Object>
		objects.add("31");

		objects.forEach(o -> System.out.printf("o = %s; hashCode = %d; equals to 31? %b%n", o.getClass(), o.hashCode(),
				o.equals(31)));
		System.out.println("objects.size() = " + objects.size());

		Object o = new Object() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		};
		System.out.println("o.hashCode() = " + o.hashCode());

		interfaceDequeTest();
	}

	public static void interfaceDequeTest() {
		try {
			Deque<String> ad = new LinkedBlockingDeque<>(4);
			ad.addFirst("a1");
			ad.offerFirst("o1");
			ad.addFirst("a2");
			ad.offerFirst("02");

//            ad.addFirst("EXTRA"); // throws exception
			ad.offerFirst("EXTRA"); // returns false

			System.out.println("in finally block");

			for (String number : ad) {
				System.out.println("Number = " + number);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Person implements Comparable<Object> {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		return age == person.age;
	}

	@Override
	public int hashCode() {
		return age;
	}

	@Override
	public int compareTo(Object o) {
		return age;
	}
}
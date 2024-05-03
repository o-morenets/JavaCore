package _18_java_8_features._99_samples;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.mkyong.com/java8/java-8-flatmap-example/
 */
public class FlatMapBooksLibrary {

	static class Student {

		private String name;
		private Set<String> book;

		public void addBook(String book) {
			if (this.book == null) {
				this.book = new HashSet<>();
			}
			this.book.add(book);
		}

		//getters and setters

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<String> getBook() {
			return book;
		}

		public void setBook(Set<String> book) {
			this.book = book;
		}
	}

	public static void main(String[] args) {
		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);

		List<String> collect =
				list.stream()
						.map(Student::getBook)      // Stream<Set<String>>
						.flatMap(Collection::stream)   // Stream<String>
						.distinct()
						.collect(Collectors.toList());

		collect.forEach(System.out::println);
	}
}

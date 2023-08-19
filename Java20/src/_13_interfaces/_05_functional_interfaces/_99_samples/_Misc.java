package _13_interfaces._05_functional_interfaces._99_samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.mkyong.com/java8/java-8-flatmap-example/
 */
public class _Misc {

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


        // https://github.com/Vedenin/java_in_examples/blob/master/stream_api/src/com/github/vedenin/rus/stream_api/MapTests.java

        Collection<String> collection = Arrays.asList("1,2,0", "4,5");

        // get all numbers
        String[] number = collection.stream()
                .flatMap(p -> Arrays.stream(p.split(",")))
                .toArray(String[]::new);
        System.out.println("number = " + Arrays.toString(number)); // output: number = [1, 2, 0, 4, 5]

        // subtract 1 from each element and evaluate the average
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        double average = numbers.stream()
                .collect(Collectors.averagingInt(p -> p - 1));
        System.out.println("average = " + average); // output: average = 1.5
    }

}

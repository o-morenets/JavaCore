package _23_java_8_features._04_stream_api._00_streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * sort example of Stream Api
 * Created by vedenin on 17 .10.15.
 */
public class SortedTests {

    private static void testSorted() {
        System.out.println();
        System.out.println("Test sorted start");

        // ************ Work with strings
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        // sort by alphabet
        List<String> sorted = collection.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted = " + sorted); // print  sorted = [a1, a1, a2, a3, a4, a4]

        // sort by alphabet without duplicate
        List<String> sortedDistinct = collection.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("sortedDistinct = " + sortedDistinct); // print  sortedDistinct = [a1, a2, a3, a4]

        // sort by alphabet in reverse order
        List<String> sortedReverse = collection.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        System.out.println("sortedReverse = " + sortedReverse); // print  sortedReverse = [a4, a4, a3, a2, a1, a1]

        // sort by alphabet in reverse order without duplicate
        List<String> distinctReverse = collection.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctReverse = " + distinctReverse); // print  sortedReverse = [a4, a3, a2, a1]

        // ************ Working with objects

        // Init collection of People
        Collection<Person> people = Arrays.asList(
                new Person("Vasyl", 16, Gender.MALE),
                new Person("Petro", 23, Gender.MALE),
                new Person("Olena", 42, Gender.FEMALE),
                new Person("Ivan", 69, Gender.MALE)
        );

        // sort by alphabet by name in reverse order
        Collection<Person> byName = people.stream()
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        System.out.println("byName = " + byName); // byName = [{name='Petro', age=23, sex=MAN}, {name='Ivan', age=69, sex=MAN}, {name='Olena', age=42, sex=WOMAN}, {name='Vasja', age=16, sex=MAN}]

        // sort by gender and (later) by age
        Collection<Person> byGenderAndAge = people.stream()
                .sorted((o1, o2) -> o1.getGender() != o2.getGender() ? o1.getGender().compareTo(o2.getGender()) : o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
        System.out.println("byGenderAndAge = " + byGenderAndAge); // byGenderAndAge = [{name='Vasyl', age=16, sex=MAN}, {name='Petro', age=23, sex=MAN}, {name='Ivan', age=69, sex=MAN}, {name='Olena', age=42, sex=WOMAN}]
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
        testSorted();
    }
}

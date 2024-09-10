package _23_java_8_features._04_stream_api._00_streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter and Count examples of Stream Api
 * Created by vedenin on 17.10.15.
 */
public class FilterAndCountTests {

    private static void testFilterAndCount() {
        System.out.println("Test filter and count start");

        // ************ Work with strings
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Get count of this object
        long count = collection.stream()
                .filter("a1"::equals)
                .count();
        System.out.println("count = " + count); // print  count = 2

        // Get all elements according pattern
        List<String> select = collection.stream()
                .filter("1"::contains)
                .collect(Collectors.toList());
        System.out.println("select = " + select); // print  select = [a1, a1]

        // ************ Work with objects

        // Init collection of Persons
        Collection<Person> people = Arrays.asList(
                new Person("Vasyl", 16, Gender.MALE),
                new Person("Petro", 23, Gender.MALE),
                new Person("Olena", 42, Gender.FEMALE),
                new Person("Ivan", 69, Gender.MALE)
        );

        // Get persons from 18 to 27 years old
        List<Person> militaryService = people.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() < 27 && p.getGender() == Gender.MALE)
                .collect(Collectors.toList());
        System.out.println("militaryService = " + militaryService); // print  militaryService = [{name='Petro', age=23, gender=MAN}]

        // Get average age from persons
        double averageAge = people.stream()
                .filter(p -> p.getGender() == Gender.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("averageAge = " + averageAge); // print  averageAge = 36.0

        // Get potential working people (>= 18 years and if women go to retirement in 55 years, and man in 60 years
        long peopleCanWork = people.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getGender() == Gender.FEMALE && p.getAge() < 55) || (p.getGender() == Gender.MALE && p.getAge() < 60))
                .count();
        System.out.println("peopleCanWork = " + peopleCanWork); // print  peopleCanWork = 2
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
    }

    public static void main(String[] args) throws Exception {
        testFilterAndCount();
    }
}

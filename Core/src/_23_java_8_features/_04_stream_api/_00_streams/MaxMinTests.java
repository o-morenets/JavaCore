package _23_java_8_features._04_stream_api._00_streams;

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
        String max = collection.stream()
                .max(String::compareTo)
                .get();
        System.out.println("max " + max); // print  a3

        // find min value
        String min = collection.stream()
                .min(String::compareTo)
                .get();
        System.out.println("min " + min); // print  a1

        // ************ Work with objects

        // Init collection of People
        Collection<Person> people = Arrays.asList(
                new Person("Vasyl", 16, Gender.MALE),
                new Person("Petro", 23, Gender.MALE),
                new Person("Olena", 42, Gender.FEMALE),
                new Person("Ivan", 69, Gender.MALE)
        );

        // Find people with minimum age
        Person older = people.stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("older " + older); // print  {name='Ivan', age=69, sex=MAN}

        // Find people with maximum age
        Person younger = people.stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("younger " + younger); // print  {name='Vasyl', age=16, sex=MAN}
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
        testMinMax();
    }
}

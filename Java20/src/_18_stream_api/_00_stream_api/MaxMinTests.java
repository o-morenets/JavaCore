package _18_stream_api._00_stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * Max and min examples of Stream Api
 *
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
                new People("Vasja", 16, Sex.MAN),
                new People("Petja", 23, Sex.MAN),
                new People("Elena", 42, Sex.WOMAN),
                new People("Ivan", 69, Sex.MAN)
        );

        // Find people with minimum age
        People older = peoples.stream().max(Comparator.comparing(People::getAge)).get();
        System.out.println("older " + older); // print  {name='Ivan', age=69, sex=MAN}

        // Find people with maximum age
        People younger = peoples.stream().min(Comparator.comparing(People::getAge)).get();
        System.out.println("younger " + younger); // print  {name='Vasja', age=16, sex=MAN}
    }


    private enum Sex {
        MAN, WOMAN
    }

    private static class People {
        private final String name;
        private final Integer age;
        private final Sex sex;

        public People(String name, Integer age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof People)) return false;
            People people = (People) o;
            return Objects.equals(name, people.name) &&
                    Objects.equals(age, people.age) &&
                    Objects.equals(sex, people.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }

    public static void main(String[] args)  throws Exception {
        testMinMax();
    }
}

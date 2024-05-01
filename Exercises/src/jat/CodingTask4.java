package jat;

import java.util.Arrays;
import java.util.List;

public class CodingTask4 {

    public static void main(String[] args) {
        Department dept1 = new Department();
        dept1.setId(111);
        dept1.setDepartment("Marketing");

        Department dept2 = new Department();
        dept2.setId(222);
        dept2.setDepartment("Human Resources");

        Department dept3 = new Department();
        dept3.setId(333);
        dept3.setDepartment("IT");

        Person person1 = new Person();
        person1.setAge(23L);
        person1.setName("Anna");
        person1.setDpts(Arrays.asList(dept2, dept3));

        Person person2 = new Person();
        person2.setAge(41L);
        person2.setName("John");
        person2.setDpts(Arrays.asList(dept2));

        Person person3 = new Person();
        person3.setAge(35L);
        person3.setName("Tom");
        person3.setDpts(Arrays.asList(dept1, dept3, dept2));

        Person person4 = new Person();
        person4.setAge(54L);
        person4.setName("Anna");
        person4.setDpts(Arrays.asList(dept3));

        List<Person> employees = Arrays.asList(person2, person4, person3, person1);

        int countByName = new Question().countByName(employees, "Anna");
        int countByDepartment = new Question().countByDepartment(employees, "it");

        System.out.println(countByName);
        System.out.println(countByDepartment);
    }
}

class Person {
    private String name;
    private Long age;
    private List<Department> dpts;

    /* getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public List<Department> getDpts() {
        return dpts;
    }

    public void setDpts(List<Department> dpts) {
        this.dpts = dpts;
    }
}

class Department {
    static {

    }

    private long id;
    private String department;

    /* getters and setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class Question {
    public int countByName(List<Person> employees, String name) {
        // Your code here
        return (int) employees.stream()
                .filter(person -> person.getName().equals(name))
                .count();
    }

    public int countByDepartment(List<Person> employees, String department) {
        // Your code here
        return (int) employees.stream()
                .flatMap(person -> person.getDpts().stream())
                .filter(dep -> dep.getDepartment().equals(department))
                .count();
    }
}

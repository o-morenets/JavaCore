package stackOverflow.hiSchool;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Institute institute = new Institute("Oxford", new ArrayList<Faculty>() {
            {
                add(new Faculty("Math", new LinkedList<Student>() {
                    {
                        add(new Student("White", "John", "WJ0123", 66.89));
                        add(new Student("Black", "Mike", "BM4567", 36.93));
                        add(new Student("Jackson", "Stue", "JS8475", 98.54));
                    }
                }));
                add(new Faculty("ComputerScience", new LinkedList<Student>() {
                    {
                        add(new Student("Starr", "George", "GS8974", 97.25));
                        add(new Student("Arnold", "Rock", "AR2354", 85.65));
                    }
                }));
            }
        });

        long studentCount = institute.getFacultyList().stream()
                .mapToLong(faculty -> faculty.getStudentList().size())
                .sum();
        System.out.println("studentCount = " + studentCount);

        Optional<Faculty> facultyMaxStudents = institute.getFacultyList().stream()
                .max(Comparator.comparingInt(faculty -> faculty.getStudentList().size()));
        facultyMaxStudents.ifPresent(faculty -> System.out.println(faculty.getName()));

        List<Student> studentList = institute.getFacultyList().stream()
                .flatMap(faculty -> faculty.getStudentList().stream())
                .filter(student -> student.getAvgGrade() >= 95 && student.getAvgGrade() <= 100)
                .collect(Collectors.toList());
        System.out.println("studentList = " + studentList);
    }
}

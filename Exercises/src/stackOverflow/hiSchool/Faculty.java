package stackOverflow.hiSchool;

import java.util.List;

public class Faculty {
    private String name;
    private List<Student> studentList;

    public Faculty(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}

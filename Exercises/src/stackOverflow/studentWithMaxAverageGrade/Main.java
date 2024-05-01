package stackOverflow.studentWithMaxAverageGrade;

public class Main {
    private Student[] students = {
            new Student(77), new Student(12), new Student(95),
            new Student(23), new Student(8), new Student(56)
    };

    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxGrade = students[0]; // or ... = students.get(0);

        for (Student student : students) {
            if (student.getAverageGrade() > studentWithMaxGrade.getAverageGrade()) {
                studentWithMaxGrade = student;
            }
        }
        return studentWithMaxGrade;
    }

    public static void main(String[] args) {
        System.out.println(new Main().getStudentWithMaxAverageGrade());
    }

}

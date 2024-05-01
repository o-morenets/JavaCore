package stackOverflow.studentWithMaxAverageGrade;

public class Student {
    private double averageGrade;

    public Student(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "averageGrade=" + averageGrade +
                '}';
    }
}

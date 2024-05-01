package stackOverflow.hiSchool;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private double avgGrade;

    public Student(String firstName, String lastName, String id, double avgGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.avgGrade = avgGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }
}


package stackOverflow.studentsGroups;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentsGroups {

    public List<Student> student() {
        List<String> name = generatedNames();
        List<String> lastName = generatedSurname();
        return IntStream.range(0, name.size()).mapToObj(i -> new Student(name.get(i), lastName.get(i)))
                .collect(Collectors.toList());
    }

    private List<String> generatedSurname() {
        return new Random().ints().limit(200).mapToObj(value -> "Surname_" + value).collect(Collectors.toList());
    }

    private List<String> generatedNames() {
        return new Random().ints().limit(200).mapToObj(value -> "Name_" + value).collect(Collectors.toList());
    }

    public List<Group> group() {
        List<Integer> generatedID = groupID();
        return generatedID.stream().map(Group::new)
                .collect(Collectors.toList());
    }

    private List<Integer> groupID() {
        return new Random().ints().limit(10).boxed().collect(Collectors.toList());
    }

    private List<Student> studentsWithGroups(int maxStudents) {
        List<Student> studentList = student();
        List<Group> groups = group();
        Random rnd = new Random();
        studentList.forEach(student -> {
            while (true) {
                int groupId = rnd.nextInt(groups.size());
                long studentsCount = studentList.stream().filter(s -> s.getGroup() != null && s.getGroup().getId() == groupId).count();
                if (studentsCount <= maxStudents) {
                    student.setGroup(groups.get(groupId));
                    break;
                }
            }
        });
        return studentList;
    }

    public static void main(String[] args) {
        StudentsGroups studentsGroups = new StudentsGroups();
        List<Student> studentsWithGroups = studentsGroups.studentsWithGroups(30);
        Map<Group, Long> collect = studentsWithGroups.stream().collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));
        collect.forEach((group, count) -> System.out.println(group + " -> " + count));
    }
}

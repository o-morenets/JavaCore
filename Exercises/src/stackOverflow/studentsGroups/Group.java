
package stackOverflow.studentsGroups;

public class Group {
    private int id;

    public Group(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id: " + id +
                '}';
    }
}

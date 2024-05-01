package stackOverflow.hiSchool;

import java.util.List;

public class Institute {
    private String name;
    private List<Faculty> facultyList;

    public Institute(String name, List<Faculty> facultyList) {
        this.name = name;
        this.facultyList = facultyList;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }
}

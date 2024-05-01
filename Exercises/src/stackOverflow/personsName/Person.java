package stackOverflow.personsName;

import java.util.List;

public class Person {
    public List<Person> friends;
    private String name;

    public String getName() {
        return name;
    }

    public List<Person> getFriends() {
        return friends;
    }
}

package stackOverflow.personsName;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonHandler personsHandler = new PersonHandler();
        String nameOfThumb1 = getBestFriendOfAlex(personsHandler);
        String nameOfThumb2 = getBestFriendOfJohn(personsHandler);
    }

    private static List<Person> getPersonsFriends(PersonHandler personsHandler, String personName) {
        return personsHandler.getPerson(personName).getFriends();
    }

    private static Person getPersonBestFriend(PersonHandler personHandler, String personName) {
        return getPersonsFriends(personHandler, personName).get(0);
    }

    private static String getBestFriendOfAlex(PersonHandler personsHandler) {
        return getPersonBestFriend(personsHandler, "Alex").getName();
    }

    private static String getBestFriendOfJohn(PersonHandler personsHandler) {
        return getPersonBestFriend(personsHandler, "John").getName();
    }
}

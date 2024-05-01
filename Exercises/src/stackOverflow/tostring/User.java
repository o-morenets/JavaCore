package stackOverflow.tostring;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class  User implements Serializable
{

	public String name;
	public String login;
	public byte age;
	public List<String> hobby;

	public  User() {}

	public  User (String name, String login, byte age, List<String> hobby) {
		this.name = name;
		this.login = login;
		this.age = age;
		this.hobby =hobby;

	}
	public  String toString() {
		return "Пользователь: " + name + " c логином: " + login + ". Его возраст: " + age +
				". Все хобби:\n" + hobby.stream().collect(Collectors.joining("\n"));
	}
}
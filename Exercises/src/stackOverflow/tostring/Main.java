package stackOverflow.tostring;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);
		System.out.print("Введите имя: ");
		String name = in.nextLine();
		System.out.print("Введите логин: ");
		String login = in.nextLine();
		System.out.print("Введите возраст: ");
		byte age = in.nextByte();
		System.out.print("Введите хобби через запятую: ");
		String hobby_1 = in.nextLine();
		String hobby_2 = in.nextLine();
		String[] hobbyArr = hobby_2.split(",");
		List<String> hobby = Arrays.asList(hobbyArr);

		User Admin = new User(name, login, age, hobby);
		System.out.print(Admin);
	}
}

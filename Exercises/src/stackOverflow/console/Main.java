package stackOverflow.console;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		System.out.print("Введите x: ");
		int x = console.nextInt(); // "\n".

		while (true) {
			try {
				System.out.print("Введите y: ");
				int y = console.nextInt();
				break;
			} catch (Exception e) {
//				String nextLine = console.nextLine();
//				System.out.println(nextLine);
			}

		}
	}
}

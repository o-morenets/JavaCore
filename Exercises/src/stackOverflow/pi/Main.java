package stackOverflow.pi;

import java.util.Scanner;

class Menu implements Runnable {
	private int menu;
	private Thread thread;
	private PI pi;

	Menu(String name, PI pi) {
		thread = new Thread(this, name);
		this.pi = pi;
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pi) {
				Scanner in = new Scanner(System.in);
				System.out.println("1 Продолжить вычисления.");
				System.out.println("2 Приостановить вычисления.");
				System.out.println("3 Посмотреть текущий результат.");
				System.out.println("4 Узнать суммарное время, затраченное на вычисления.");
				System.out.println("5 Выход.");
				menu = in.nextInt();
				switch (menu) {
				case 1: {
					System.out.println("Продолжаем вычисления");
					pi.notify();
					pi.setStopProcess(false);
					break;
				}
				case 2: {
					System.out.println("Приостанавливаем вычисления");
					pi.setStopProcess(true);
					break;
				}
				case 3: {
					System.out.println("Полученное значение Пи: " + 4 * pi.getPI());
					break;
				}
				case 4: {
					System.out.println("Время выполения" + pi.getTime());
					break;
				}
				case 5: {
					System.out.println("");
					System.exit(0);
					break;
				}
				default: {
					System.out.println("<Error>");
					break;
				}
				}
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		PI pi = new PI("Leibnits");
		Menu menu = new Menu("Menu", pi);
	}
}
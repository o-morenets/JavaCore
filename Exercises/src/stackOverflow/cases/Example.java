package stackOverflow.cases;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = null;

        while (true) {
            System.out.println("Input 1 or 2:");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: // кейс с вводом содержимого n строк
                    System.out.print("Введите количество строк: ");

                    if (scanner.hasNextInt()) {
                        data = new Data(scanner.nextInt());
                    } else {
                        System.out.print("Введены некорректные данные!");
                        return;
                    }
                    scanner.nextLine();

                    for (int i = 0; i < data.n; i++) {
                        System.out.print((i + 1) + " ");
                        data.strings[i] = scanner.nextLine(); // НЕ ругается на ошибку
                    }

                    break;

                case 2:  //кейс с выводом содержимого n строк
                    if (data != null) {
                        for (int i = 0; i < data.n; i++) {
                            System.out.println(data.strings[i]);
                        }
                    }
                    break;
            }
        }
    }
}

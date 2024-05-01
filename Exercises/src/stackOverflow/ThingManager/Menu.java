
package stackOverflow.ThingManager;

import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Manager manager;

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addBook(978 - 5 - 6040043 - 6 - 4, "Лежит слева", "Двухтомник тех.литературы издательства культуры");
        manager.addMagnet("Польша стронг", "висит на холодосе", "с печеньку");
        manager.addClothes("XXL", "дахрензнаетгдеэтотносок", "42");
        Menu menu = new Menu(manager);
        menu.startManager();
    }


    Menu(Manager manager) {
        scanner = new Scanner(System.in);
        this.manager = manager;
    }

    int userInput() {
        int userInput;

        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                scanner.nextLine();

            }
        }
        return userInput;
    }


    void startManager() {
        int userInput;
        String[] options = {
                "1 - Показать всё",
                "2 - добавить книжку",
                "3 - добавить магнитик",
                "4 - добавить одёжу",
                "5 - удалить какой-нибудь объект",
                "6 - удалить все",


                "8 - для возврата в меню",
                "9 - для выхода"
        };
        do {
            System.out.println("Выберите вариант: ");
            for (String option : options) {
                System.out.println(option);
            }
            userInput = scanner.nextInt();
            scanner.nextLine();
            processing(userInput);
        } while (userInput != 9);
        System.out.println("Работа завершена.");
    }

    private void processing(int userInput) {

        switch (userInput) {
            case 1:
                showAnything();
                break;
            case 2:
                menuAddBook();
                break;
            case 3:
                menuAddMagnet();
                break;
            case 4:
                menuAddClothes();
                break;
            case 5:
                menuDelOneThing();
                break;
            case 6:
                menuDelAnything();
                break;
            case 8:
                break;
            case 9:
                return;

        }
    }

    void menuAddBook() {
        System.out.println("Введите серийник: ");
        long serial = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Введите место: ");
        String place = scanner.nextLine();
        System.out.println("Введите размер: ");
        String size = scanner.nextLine();
        manager.addBook(serial, place, size);
        System.out.println("Добавлено в библиотЭку");
    }

    void menuAddMagnet() {
        System.out.println("Введите откуда привезено: ");
        String country = scanner.nextLine();
        System.out.println("Введите место: ");
        String place = scanner.nextLine();
        System.out.println("Введите размер: ");
        String size = scanner.nextLine();
        manager.addMagnet(country, place, size);
        System.out.println("Повешено на холодос");
    }

    void menuAddClothes() {
        System.out.println("Введите размер одёжы: ");
        String ClothesSize = scanner.nextLine();
        System.out.println("Введите место: ");
        String place = scanner.nextLine();
        System.out.println("Введите размер: ");
        String size = scanner.nextLine();
        manager.addClothes(ClothesSize, place, size);
        System.out.println("Куда-то кинуто");
    }

    void menuDelOneThing() {
        System.out.println("Введите положение объекта для удаления: ");
        String place = scanner.nextLine();
        System.out.println("Введите размер объекта для удаления: ");
        String size = scanner.nextLine();
        manager.delThing(place, size);
    }

    void menuDelAnything() {
        manager.things.clear();
/*
        for (Thing thing : manager.things) {
            manager.things.remove(thing);
        }
*/
    }

    void showAnything() {
        for (Thing thing : manager.things) {
            System.out.println(thing);

        }
    }


}
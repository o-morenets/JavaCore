package stackOverflow.hashSet;

import java.util.Scanner;

public class Menu {
    Scanner scanner;
    BookCase bookCase;

    public Menu(BookCase bookCase) {
        scanner = new Scanner(System.in);
        this.bookCase = bookCase;
    }

    void offerMenu() {
        int userInput;
        do {
            listOptions();
            System.out.println();
            System.out.println("Выберите опцию:");
            System.out.println();
            userInput = scanner.nextInt();
            scanner.nextLine();
            processing(userInput);
        }
        while (userInput() != 7);
        System.out.println("Работа завершена.");
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

    void listOptions() {
        System.out.println("Выберите опцию менеджера книг: ");
        System.out.println("1 - посмотреть список книг");
        System.out.println("2 - поиск книги");
        System.out.println("3 - информация по книге");
        System.out.println("4 - добавить книгу");
        System.out.println("5 - удалить книгу");
        System.out.println("6 - fast find book");
        System.out.println("0 - для выхода в основное меню");
        System.out.println("7 - выход");
    }


    private void processing(int userInput) {

        switch (userInput) {
            case 1:
                menuShowBooks();
                break;
            case 2:
                menuFindBook();
                break;
            case 3:
                bookInfo();
                break;
            case 4:
                menuAddBook();
                break;
            case 5:
                menuDelBook();
                break;
            case 6:
                menuFastFindBook();
                break;
            case 0:
                break;
            case 7:
                return;
        }
    }

    private void menuFastFindBook() {
        System.out.println("Введите название/автора книги для поиска: ");
        String bookName = scanner.nextLine();
        bookCase.fastSearch(bookName);
    }

    void bookInfo() {
        System.out.println("Введите название/автора книги для поиска: ");
        String bookName = scanner.nextLine();
        bookCase.showBookInfo(bookName);
    }

    void menuFindBook() {
        System.out.println("Введите название/автора книги для поиска: ");
        String bookName = scanner.nextLine();
        System.out.println(bookCase.findBook(bookName));
    }


    void menuShowBooks() {
        for (Book book : bookCase.books) {
            System.out.println(book);
        }
    }

    void menuAddBook() {
        System.out.println("Введите автора: ");
        String bookName = scanner.nextLine();
        System.out.println("Введите название:");
        String author = scanner.nextLine();
        System.out.println("Введите серийник:");
        int serial = scanner.nextInt();
        bookCase.addBook(bookName, author, serial);
        System.out.println("Добавлено в библиотЭку");
    }

    void menuDelBook() {
        System.out.println("Введите название/автора книги для удаления: ");
        String bookName = scanner.nextLine();
        bookCase.delBook(bookName);
    }
}


package stackOverflow.bookManager;

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
            userInput = userInput();
            processing(userInput);
        }
        while (userInput != 7);
        System.out.println("Работа завершена.");
    }

    int userInput() {
        int userInput;

        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();

            }
        }
        return userInput;
    }

    String inputBookTitleAuthor() {
        System.out.println("Введите автора/название: ");
        String userStringInput = scanner.nextLine();
        return userStringInput;
    }

    void listOptions() {
        System.out.println("Выберите опцию менеджера книг: ");
        System.out.println("1 - посмотреть список книг");
        System.out.println("2 - поиск книги");
        System.out.println("3 - информация по книге");
        System.out.println("4 - добавить книгу");
        System.out.println("5 - удалить книгу");
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
                bookCase.showBookInfo(inputBookTitleAuthor());
                break;
            case 4:
                menuAddBook();
                break;
            case 5:
                menuDelBook();
                break;
            case 0:
                break;
            case 7:
                return;
        }
    }

    void menuFindBook() {
        System.out.println("Введите название/автора книги для поиска: ");
        String bookName = scanner.nextLine();
        System.out.println(bookCase.findBook(bookName));
    }

    void menuShowBooks() {
        System.out.println(bookCase.showBooks());
    }

    void menuAddBook() {
        System.out.println("Введите название: ");
        String bookName = scanner.nextLine();
        System.out.println("Введите автора:");
        String author = scanner.nextLine();
        bookCase.addBook(bookName, author);
        System.out.println("Добавлено в библиотЭку");
    }

    void menuDelBook() {
        System.out.println("Введите название/автора книги для удаления: ");
        String bookName = scanner.nextLine();
        bookCase.delBook(bookName);
    }
}
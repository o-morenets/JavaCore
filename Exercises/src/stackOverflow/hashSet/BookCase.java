package stackOverflow.hashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class BookCase {
    HashSet<Book> books;


    BookCase() {
        books = new HashSet<>();  //ArrayList<>();
    }

    void addBook(String bookName, String author, int serial) {
        Book book = new Book(bookName, author, serial);
        books.add(book);

    }

    HashSet<Book> showBooks() {
        System.out.println("Список книг: ");
        return books;
    }

    ArrayList<Book> findBook(String input) {
        ArrayList<Book> findBookList = new ArrayList<>();
        for (Book book : books) {
            if ((input.equals(book.getName())) | (input.equals(book.getWriter()))) {
                findBookList.add(book);
            }
        }
        return findBookList;
    }

    void showBookInfo(String input) {
        ArrayList<Book> showInfoBook = findBook(input);
        for (Book book : showInfoBook) {
            System.out.println("Название книги: " + book.getName() + " Писатель: " + book.getWriter());
        }
    }

    void delBook(String input) {
        for (Book book : books) {
            if ((input.equals(book.getName())) | (input.equals(book.getWriter()))) {
                books.remove(book);
                System.out.println("Книга удалена");
                break;
            } else {
                System.out.println("Нет такой книги.");
                break;
            }
        }
    }

    boolean checkBookInSet(String name) {                 //<<<------ метод быстрого поиска
        return books.contains(name.hashCode());
    }

    Book fastSearch(String soughtForBook) {
        if (checkBookInSet(soughtForBook)) {
            for (Book book : books) {
                if (book.equals(soughtForBook)) {         //<<<------- проверка соответствия
                    return book;
                }
            }
        } else {
            System.out.println("Такого нет");
        }
        return null;
    }


}

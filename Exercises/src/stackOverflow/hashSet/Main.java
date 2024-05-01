package stackOverflow.hashSet;

public class Main {
    public static void main(String[] args) {
        BookCase bookCase = new BookCase();
        bookCase.addBook("пушкин","сказки", 111);
        bookCase.addBook("непушкин","несказки",222);
        bookCase.addBook("гоголь","нос",333);
        bookCase.addBook("прямая линия", "pooteen", 2020);
        Menu menu = new Menu(bookCase);
        menu.offerMenu();
    }
}

package stackOverflow.hashSet;

import java.util.Objects;

public class Book {
    private String name;
    private String writer;
    private int isbn;

    Book(  String name, String writer, int serial) {
        this.name = name;
        this.writer = writer;
        this.isbn = serial;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }


    @Override
    public String toString() {
        return "Автор '" + name + '\'' +
                ", наименование книги: " +"' "+ writer + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

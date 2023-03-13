package repository;

import model.Book;

import java.util.List;

public interface BookRepository {
    boolean addBook(Book book);
    boolean updateBook(String name,Book book);
    boolean removeBook(String name);
    List<Book> showAllBook();
    List<Book> showByName(String name);
    List<Book> sortByDate();
    List<Book> sortByName();

}

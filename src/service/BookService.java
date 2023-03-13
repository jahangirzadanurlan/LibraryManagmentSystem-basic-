package service;

import model.Book;

import java.util.List;

public interface BookService {
    void addBook();
    void updateBook();
    void removeBook();
    List<Book> showAllBook();
    List<Book> showByName();
    List<Book> sortByDate();
    List<Book> sortByName();
}

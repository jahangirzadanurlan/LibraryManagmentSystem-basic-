package service.impl;

import model.Book;

import repository.BookRepository;
import repository.impl.BookRepositoryImpl;
import service.BookService;
import util.InputUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl() {
        bookRepository=new BookRepositoryImpl();
    }
    public static Book fillBook(){
        String name=InputUtil.requiredInputString("Enter the name: ");
        String author=InputUtil.requiredInputString("Enter the author: ");
        String publisher=InputUtil.requiredInputString("Enter the publisher: ");
        LocalDate releaseDate=InputUtil.requiredInputDate("Enter the release date: ");

        return new Book(name,author,publisher,releaseDate);
    }
    public static Book fillUpdateBook(){
        String name=InputUtil.requiredInputString("Enter the new name: ");
        String publisher=InputUtil.requiredInputString("Enter the new publisher: ");

        return new Book(name,publisher);
    }
    @Override
    public void addBook() {
        bookRepository.addBook(fillBook());
        System.out.println("----------| Adding is succesfully |--------");
    }

    @Override
    public void updateBook() {
        String name=InputUtil.requiredInputString("Enter the name of the book to be updated: ");

        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> bookList = bookService.showAllBook();
        Optional<Book> optionalBook = bookList.stream().filter(i -> i.getName().equals(name)).findFirst();

        if (optionalBook.isPresent()) {
            bookRepository.updateBook(name,fillUpdateBook());
            System.out.println("----------| Updating is succesfully |--------");
        }else{
            System.out.println("There is no book with this name...");
        }
    }

    @Override
    public void removeBook() {
        String name=InputUtil.requiredInputString("Enter the name of the book you want to delete: ");

        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> bookList = bookService.showAllBook();
        Optional<Book> optionalBook = bookList.stream().filter(i -> i.getName().equals(name)).findFirst();

        if (optionalBook.isPresent()){
            bookRepository.removeBook(name);
            System.out.println("----------| Removing is succesfully |--------");
        }else {
            System.out.println("There is no book with this name...");
        }
    }

    @Override
    public List<Book> showAllBook() {
        return bookRepository.showAllBook();
    }

    @Override
    public List<Book> showByName() {
        String name=InputUtil.requiredInputString("Enter the title of the book: ");

        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> bookList = bookService.showAllBook();
        Optional<Book> optionalBook = bookList.stream().filter(i -> i.getName().equals(name)).findFirst();

        if (optionalBook.isPresent()){
            return bookRepository.showByName(name);
        }else {
            System.out.println("There is no book with this name...");
        }
        return null;
    }

    @Override
    public List<Book> sortByDate() {
        return bookRepository.sortByDate();
    }

    @Override
    public List<Book> sortByName() {
        return bookRepository.sortByName();
    }
}

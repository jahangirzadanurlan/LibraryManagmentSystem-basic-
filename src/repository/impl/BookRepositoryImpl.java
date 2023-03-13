package repository.impl;

import model.Book;
import queries.BookQuery;
import repository.BookRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import static repository.DbConnection.connect;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public boolean addBook(Book book){
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.ADD_BOOK);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setString(3,book.getPublisher());
            preparedStatement.setDate(4,Date.valueOf(book.getReleaseDate()));

            int val=preparedStatement.executeUpdate();
            return val>0;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(String name,Book book) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.UPDATE_BOOK);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getPublisher());
            preparedStatement.setString(3,name);

            int val=preparedStatement.executeUpdate();
            return val>0;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeBook(String name) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.REMOVE_BOOK);
            preparedStatement.setString(1,name);

            int val=preparedStatement.executeUpdate();
            return val>0;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> showAllBook() {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.showAllBook);

            List<Book> books=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("bookName");
                String author=resultSet.getString("author");
                String publisher=resultSet.getString("publisher");
                Date releaseDate=resultSet.getDate("releaseDate");

                books.add(new Book(id,name,author,publisher, releaseDate.toLocalDate()));
            }
            return books;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> showByName(String name) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.showByName);
            preparedStatement.setString(1,name);

            List<Book> books=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String bookName=resultSet.getString("bookName");
                String author=resultSet.getString("author");
                String publisher=resultSet.getString("publisher");
                Date releaseDate=resultSet.getDate("releaseDate");

                books.add(new Book(id,bookName,author,publisher, releaseDate.toLocalDate()));
            }
            return books;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> sortByDate() {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.sortByDate);

            List<Book> books=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String bookName=resultSet.getString("bookName");
                String author=resultSet.getString("author");
                String publisher=resultSet.getString("publisher");
                Date releaseDate=resultSet.getDate("releaseDate");

                books.add(new Book(id,bookName,author,publisher, releaseDate.toLocalDate()));
            }
            return books;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> sortByName() {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(BookQuery.sortByName);

            List<Book> books=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String bookName=resultSet.getString("bookName");
                String author=resultSet.getString("author");
                String publisher=resultSet.getString("publisher");
                Date releaseDate=resultSet.getDate("releaseDate");

                books.add(new Book(id,bookName,author,publisher, releaseDate.toLocalDate()));
            }
            return books;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}

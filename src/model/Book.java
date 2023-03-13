package model;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    public Book(int id,String name, String author, String publisher, LocalDate releaseDate) {
        this.id=id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public Book(String name, String author, String publisher, LocalDate releaseDate) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public Book(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "id= " + id +"\n"+
                "Name= " + name + "\n" +
                "Author= " + author + "\n" +
                "Publisher= " + publisher + "\n" +
                "Release Date= " + releaseDate;
    }
}

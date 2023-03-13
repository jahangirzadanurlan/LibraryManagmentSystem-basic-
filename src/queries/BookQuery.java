package queries;

public class BookQuery {
    public static final String ADD_BOOK = "INSERT INTO book(bookName,author,publisher,releaseDate) "+
            "VALUES(?,?,?,?)";
    public static final String UPDATE_BOOK="UPDATE book SET bookName=?,publisher=? WHERE bookName=?";

    public static final String REMOVE_BOOK="UPDATE book SET bookStatus=0 WHERE bookName=?";

    public static final String showAllBook="SELECT * FROM book WHERE bookStatus=1";

    public static final String showByName="SELECT * FROM book WHERE bookName=? and bookStatus=1";

    public static final String sortByDate="SELECT * FROM book WHERE bookStatus=1 ORDER BY releaseDate";
    public static final String sortByName="SELECT * FROM book WHERE bookStatus=1 ORDER BY bookName ";
}

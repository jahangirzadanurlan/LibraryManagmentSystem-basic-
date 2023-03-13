package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection connect() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/library_managment_system";
        String username="postgres";
        String password="root";

        return DriverManager.getConnection(url,username,password);
    }
}

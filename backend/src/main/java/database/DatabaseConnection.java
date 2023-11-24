package database;

import java.sql.*;

public class DatabaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/cinema";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        // Metodă pentru a obține o conexiune la baza de date
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
}
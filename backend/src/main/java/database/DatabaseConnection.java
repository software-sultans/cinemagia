package database;

import java.sql.*;

public class DatabaseConnection {

    public static boolean authenticate(String username, String password) {
        // Configurare parametrii de conexiune la baza de date
        String url = "jdbc:mysql://localhost:3306/cinema";
        String user = "root";
        String dbPassword = "root";

        try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
            // Verifică autentificarea utilizatorului
            String query = "SELECT * FROM angajati WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Returnează true dacă există un rând în rezultat (autentificare reușită)
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Autentificare eșuată în caz de excepție SQL
        }

    }
}

package filme;
import database.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StocareFilme {

    public static List<Film> getListaFilme() {
        List<Film> filme = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM filme";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Film film = new Film();
                film.nume = resultSet.getString("nume");
                film.durata = resultSet.getInt("durata");
                film.descriere = resultSet.getString("descriere");
                film.dataLansare = resultSet.getDate("data_lansare").toLocalDate();
                film.pret = resultSet.getFloat("pret");
                film.regizor = resultSet.getString("regizor");
                film.gen = resultSet.getString("gen");
                film.parentalGuidance = resultSet.getString("parental_guidance");
                film.salaRulare = resultSet.getString("sala_rulare");
                film.setPoster(resultSet.getBytes("poster"));

                filme.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filme;
    }
}

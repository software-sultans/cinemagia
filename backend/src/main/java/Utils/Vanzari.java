package Utils;

import database.DatabaseConnection;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class Vanzari {



    public static float getSumaVanzari(String start, String end) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT SUM(pret) AS total_pret FROM vanzari WHERE data_bon >= ? AND data_bon <= ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, start);
                preparedStatement.setString(2, end);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        float totalPret = resultSet.getFloat("total_pret");
                        return totalPret;
                    } else {
                        return 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}



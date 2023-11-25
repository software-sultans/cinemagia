package produse;

import database.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaginaStoc {
    private JFrame frame;
    private List<Produs> listaProduse;

    public PaginaStoc() {
        frame = new JFrame("Stoc");
        // Configurări specifice paginii de stoc
        frame.setSize(1400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        // Obține datele din baza de date și stochează-le în lista de produse
        listaProduse = getListaProduseFromDatabase();

        // Crează un model de tabel pentru a afișa datele produselor într-un JTable
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Tip Produs", "Nume", "Pret", "Continut", "Cantitate Disponibila"}, 0);
        for (Produs produs : listaProduse) {
            model.addRow(new Object[]{
                    produs.getTipProdus(),
                    produs.getNume(),
                    produs.getPretVanzare(),
                    produs.getContinut(),
                    produs.getCantitateDisponibila()
            });
        }

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
    }

    // Metodă pentru a obține lista de produse din baza de date
    private List<Produs> getListaProduseFromDatabase() {
        List<Produs> produse = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT p.tip_produs, p.nume, sp.pret, p.continut, sp.cantitate " +
                    "FROM produse p INNER JOIN stoc_produse sp ON p.id = sp.id_produs";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Produs produs = new Produs(
                        resultSet.getString("nume"),
                        null, // Momentan nu există un câmp producător în interogare
                        resultSet.getFloat("pret"),
                        resultSet.getString("continut"),
                        resultSet.getString("tip_produs"),
                        null, // Momentan nu există un câmp pentru data de expirare în interogare
                        resultSet.getInt("cantitate")
                );
                produse.add(produs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produse;
    }

    public void afiseazaPaginaStoc() {
        frame.setVisible(true);
    }
}


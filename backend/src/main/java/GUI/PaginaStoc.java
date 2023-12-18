package GUI;

import database.DatabaseConnection;
import produse.PaginaActualizareStoc;
import produse.PaginaAdaugareProdus;
import produse.Produs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        // Obține produsele si stochează-le în lista de produse
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

        // Crearea și configurarea butoanelor "Adaugă" și "Actualizează"
        JButton adaugaButton = new JButton("Adaugă");
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaginaAdaugareProdus paginaAdaugareProdus = new PaginaAdaugareProdus();
                paginaAdaugareProdus.afiseazaPaginaAdaugareProdus();
            }
        });

        JButton actualizeazaButton = new JButton("Actualizează");
        actualizeazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaginaActualizareStoc paginaActualizareStoc = new PaginaActualizareStoc();
                paginaActualizareStoc.afiseazaPaginaActualizareStoc();
            }
        });

        // Crearea unui nou JPanel pentru butoanele de adăugare și actualizare
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout()); // Setarea layout-ului pentru a alinia butoanele pe orizontală
        buttonsPanel.add(adaugaButton);
        buttonsPanel.add(actualizeazaButton);
        buttonsPanel.setBackground(Color.BLACK); // Setează culoarea de fundal a grilei la negru

        frame.add(buttonsPanel, BorderLayout.NORTH);

    }

    // Metodă pentru a obține lista de produse din baza de date
    public static List<Produs> getListaProduseFromDatabase() {
        List<Produs> produse = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT p.tip_produse, p.nume, sp.pret, p.continut, sp.cantitate " +
                    "FROM produse p INNER JOIN stoc_produse sp ON p.id = sp.id_produs";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Produs produs = new Produs(
                        resultSet.getString("nume"),
                        null, // Momentan nu există un câmp producător în interogare
                        resultSet.getFloat("pret"),
                        resultSet.getString("continut"),
                        resultSet.getString("tip_produse"),
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


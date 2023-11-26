package produse;

import database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public class PaginaAdaugareProdus {
    private JFrame frame;

    public PaginaAdaugareProdus() {
        frame = new JFrame("Adăugare Produs");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel tipProdusLabel = new JLabel("Tip Produs:");
        JTextField tipProdusField = new JTextField(20);

        JLabel numeProdusLabel = new JLabel("Nume Produs:");
        JTextField numeProdusField = new JTextField(20);

        JLabel producatorLabel = new JLabel("Producator:");
        JTextField producatorField = new JTextField(20);

        JLabel pretVanzareLabel = new JLabel("Pret Vanzare:");
        JTextField pretVanzareField = new JTextField(20);

        JLabel continutLabel = new JLabel("Continut:");
        JTextField continutField = new JTextField(20);

        JLabel cantitateLabel = new JLabel("Cantitate:");
        JTextField cantitateField = new JTextField(20);

        JLabel dataExpirareLabel = new JLabel("Data Expirare (YYYY-MM-DD):");
        JTextField dataExpirareField = new JTextField(20);

        JButton adaugaButton = new JButton("Adaugă");
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement();

                    String tipProdus = tipProdusField.getText();
                    String numeProdus = numeProdusField.getText();
                    String producator = producatorField.getText();
                    float pretVanzare = Float.parseFloat(pretVanzareField.getText());
                    String continut = continutField.getText();
                    int cantitate = Integer.parseInt(cantitateField.getText());
                    String dataExpirare = dataExpirareField.getText();

                    String insertQueryProduse = "INSERT INTO produse (tip_produs, nume, producator, continut) " +
                            "VALUES ('" + tipProdus + "', '" + numeProdus + "', '" + producator + "', '" + continut + "')";
                    statement.executeUpdate(insertQueryProduse);

                    String insertQueryStocProduse = "INSERT INTO stoc_produse (id_produs, cantitate, pret, data_expirare) " +
                            "VALUES (LAST_INSERT_ID(), " + cantitate + ", " + pretVanzare + ", '" + dataExpirare + "')";
                    statement.executeUpdate(insertQueryStocProduse);

                    JOptionPane.showMessageDialog(null, "Produs adăugat cu succes!");
                    frame.dispose();
                    PaginaStoc paginaStoc = new PaginaStoc();
                    paginaStoc.afiseazaPaginaStoc();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Eroare la adăugarea produsului!");
                }
            }
        });

        panel.add(tipProdusLabel);
        panel.add(tipProdusField);
        panel.add(numeProdusLabel);
        panel.add(numeProdusField);
        panel.add(producatorLabel);
        panel.add(producatorField);
        panel.add(pretVanzareLabel);
        panel.add(pretVanzareField);
        panel.add(continutLabel);
        panel.add(continutField);
        panel.add(cantitateLabel);
        panel.add(cantitateField);
        panel.add(dataExpirareLabel);
        panel.add(dataExpirareField);
        panel.add(adaugaButton);

        frame.add(panel);
    }

    public void afiseazaPaginaAdaugareProdus() {
        frame.setVisible(true);
    }
}



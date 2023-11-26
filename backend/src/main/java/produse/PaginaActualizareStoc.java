package produse;

import database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public class PaginaActualizareStoc {
    private JFrame frame;

    public PaginaActualizareStoc() {
        frame = new JFrame("Actualizare Stoc");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel numeProdusLabel = new JLabel("Nume Produs:");
        JTextField numeProdusField = new JTextField(20);

        JLabel pretLabel = new JLabel("Pret:");
        JTextField pretField = new JTextField(20);

        JLabel cantitateLabel = new JLabel("Cantitate:");
        JTextField cantitateField = new JTextField(20);

        JLabel dataExpirareLabel = new JLabel("Data Expirare (YYYY-MM-DD):");
        JTextField dataExpirareField = new JTextField(20);

        JButton actualizeazaButton = new JButton("Actualizează");
        actualizeazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement();

                    String numeProdus = numeProdusField.getText();
                    float pret = Float.parseFloat(pretField.getText());
                    int cantitate = Integer.parseInt(cantitateField.getText());
                    String dataExpirare = dataExpirareField.getText();

                    // Actualizează stoc_produse
                    String updateStocQuery = "UPDATE stoc_produse sp " +
                            "INNER JOIN produse p ON sp.id_produs = p.id " +
                            "SET sp.pret = " + pret + ", sp.cantitate = " + cantitate + ", sp.data_expirare = '" + dataExpirare + "' " +
                            "WHERE p.nume = '" + numeProdus + "'";
                    statement.executeUpdate(updateStocQuery);

                    JOptionPane.showMessageDialog(null, "Stoc actualizat cu succes!");
                    frame.dispose();
                    PaginaStoc paginaStoc = new PaginaStoc();
                    paginaStoc.afiseazaPaginaStoc();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduceți un număr valid pentru preț și cantitate!");
                    ex.printStackTrace();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare la actualizarea stocului: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });




        panel.add(numeProdusLabel);
        panel.add(numeProdusField);
        panel.add(pretLabel);
        panel.add(pretField);
        panel.add(cantitateLabel);
        panel.add(cantitateField);
        panel.add(dataExpirareLabel);
        panel.add(dataExpirareField);
        panel.add(actualizeazaButton);

        frame.add(panel);
    }

    public void afiseazaPaginaActualizareStoc() {
        frame.setVisible(true);
    }
}


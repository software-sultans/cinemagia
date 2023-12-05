package GUI;

import database.DatabaseConnection;
import produse.ModificareStocPage;
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

public class PaginaBon extends JFrame{
    private JFrame frame;

    public PaginaBon() {

        frame = new JFrame("Bon");
        // Configurări specifice paginii de stoc
        frame.setSize(1400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        JButton bauturiButton = new JButton("Bauturi");
        JButton cipsuriButton = new JButton("Cipsuri");
        JButton dulciuriButton = new JButton("Dulciuri");
        JButton jeleuriButton = new JButton("Extra");
        JButton extraButton = new JButton("Extra");
        setLayout(null);

        bauturiButton.setBounds(10, 80, 100, 25);

        frame.add(bauturiButton);
        frame.add(cipsuriButton);
        frame.add(dulciuriButton);
        frame.add(extraButton);


    }

    public void afiseazaPaginaBon() {
        frame.setVisible(true);
    }


}

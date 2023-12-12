package GUI;

import database.DatabaseConnection;
import produse.ModificareStocPage;
import produse.Produs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import java.sql.Statement;

public class PaginaBon extends JFrame{

    String[] items=new String[10];
    int[] idItems=new int[10];
    int[] cantitate=new int[10];
    int inceputLabels=10;

    List<Produs> lista=PaginaStoc.getListaProduseFromDatabase();
    JComboBox<String> comboBox = new JComboBox<>(items);


    public PaginaBon() {

        // Configurări specifice paginii de stoc

        setSize(1400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

         // Butoane
        JButton bauturiButton = new JButton("Bauturi");
        JButton cipsuriButton = new JButton("Cipsuri");
        JButton dulciuriButton = new JButton("Dulciuri");
        JButton filmeButton = new JButton("Filme");
        JButton extraButton = new JButton("Extra");
        JButton adaugaButton= new JButton("Adauga");



        bauturiButton.setBounds(10, 10, 100, 25);
        cipsuriButton.setBounds(110,10,100,25);
        dulciuriButton.setBounds(210,10,100,25);
        extraButton.setBounds(310,10,100,25);
        filmeButton.setBounds(410,10,100,25);
        adaugaButton.setBounds(10,300,100,25);





        comboBox.setBounds(10,50,100,25);


        JTextField textField=new JTextField("Cantitate");
        textField.setBounds(210,50,100,25);


        // Action listeners butoane

        bauturiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                putNameInComboBox("Bauturi");

            }
        });

        cipsuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                putNameInComboBox("Cipsuri");

            }
        });

        dulciuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                putNameInComboBox("Dulciuri");

            }
        });
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel(comboBox.getSelectedItem().toString());
                label1.setBounds(1120,inceputLabels,200,50);

                JLabel jLabel=new JLabel(textField.getText().concat("x"));
                jLabel.setBounds(1100,inceputLabels,200,50);

                inceputLabels=inceputLabels+25;


//
//                String updateStocQuery = "UPDATE stoc_produse sp " +
//                        "INNER JOIN produse p ON sp.id_produs = p.id " +
//                        "SET sp.pret = " + pret + ", sp.cantitate = " + cantitate + ", sp.data_expirare = '" + dataExpirare + "' " +
//                        "WHERE p.nume = '" + numeProdus + "'";
//                statement.executeUpdate(updateStocQuery);

                add(label1);
                add(jLabel);
                repaint();
            }
        });

        // Adaugare butoane
        add(bauturiButton);
        add(cipsuriButton);
        add(dulciuriButton);
        add(extraButton);
        add(filmeButton);
        add(adaugaButton);
        add(comboBox);
        add(textField);

    }

    public void afiseazaPaginaBon() {


        setVisible(true);
    }

    private void putNameInComboBox(String cuvant)
    {

        int i=0;
        for (i=0;i<10;i++)
        {
            items[i]="";
            idItems[i]=0;
            cantitate[i]=0;
        }
        i=0;
        for(Produs produs:lista)
        {

            if(produs.getTipProdus().equals(cuvant)) {
                items[i] = produs.getNume();
                cantitate[i]=produs.getCantitateDisponibila();
                i++;
            }
        }
        comboBox.setModel(new DefaultComboBoxModel<>(items));
    }



}

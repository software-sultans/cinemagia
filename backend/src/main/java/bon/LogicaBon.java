package bon;

import GUI.PaginaBon;
import database.DatabaseConnection;
import produse.Produs;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static GUI.LoginForm.idAngajat;

public class LogicaBon {

    public static void putProduseInCombobox(String[] arrayProduse,int[] arrayCantitateProdus, float[] arrayPretProdus, List<Produs> listProdus, String cuvant,JComboBox comboBox)
    {


        int i=0;
        for (i=0;i<10;i++)
        {
            arrayProduse[i]="";
            arrayCantitateProdus[i]=0;
            arrayPretProdus[i]=0;
        }

        i=0;
        for(Produs produs:listProdus)
        {

            if(produs.getTipProdus().equals(cuvant)) {
                arrayProduse[i] = produs.getNume();
                arrayCantitateProdus[i]=produs.getCantitateDisponibila();
                arrayPretProdus[i]=produs.getPretVanzare();
                i++;
            }
        }
        comboBox.setModel(new DefaultComboBoxModel<>(arrayProduse));
    }

    public static void getMeniuriInfo(String[] arrayNumeMeniuri,float[] arrayPreturiMeniuri)
    {
        int i=0;


        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT  m.nume, m.pret " +
                    "FROM meniuri m";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                arrayNumeMeniuri[i]=resultSet.getString("nume");
                arrayPreturiMeniuri[i]=resultSet.getFloat("pret");
                i++;


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertVanzare(float pretVanzare)
    {
        LocalDate data = LocalDate.now();
        String formattedDate = data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //fgm SQL cu trunchierea ta
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "INSERT INTO vanzari (id_angajat, pret, data_bon) VALUES (" + idAngajat + "," + pretVanzare + ",'" + formattedDate + "')";
            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//    public static void logicaButonAdauga(int[]){
//        if (arrayCantitateProdus[comboBox.getSelectedIndex()] >= Integer.parseInt(textFieldCanitate.getText())) {
//
//            float pretProduse=(Integer.parseInt(textFieldCanitate.getText()) * (arrayPretProdus[comboBox.getSelectedIndex()] * 10) / 10);
//            pretTotal = pretTotal+pretProduse;
//            addToBon(textFieldCanitate.getText().concat("x").concat(comboBox.getSelectedItem().toString()),pretProduse,panelBon);
//            produseDeModificat[indexDeModificat] = comboBox.getSelectedItem().toString();
//            stocDeModificat[indexDeModificat] = Integer.parseInt(textFieldCanitate.getText());
//            indexDeModificat++;
//            totalLabel.setText(String.format("%.2f",pretTotal));
//            revalidate();
//
//        } else {
//
//            JOptionPane.showMessageDialog(PaginaBon.this, "Stoc insuficient", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }



}

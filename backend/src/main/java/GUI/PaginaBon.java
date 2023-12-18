package GUI;

import bon.LogicaBon;
import database.DatabaseConnection;
import filme.Film;
import filme.StocareFilme;
import produse.Produs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;

import java.sql.Statement;

import static bon.LogicaBon.getMeniuriInfo;
import static bon.LogicaBon.insertVanzare;

public class PaginaBon extends JFrame{


    String[] arrayProduse=new String[10];
    String[] arrayRevalidareProduse=new String[]{"","","","","","","","","",""};
    int[] idItems=new int[10];
    int[] arrayCantitateProdus=new int[10];
    float[] arrayPretProdus=new float[10];

    //Lista de Produse
    List<Produs> listProdus=PaginaStoc.getListaProduseFromDatabase();

    //Lista de Filme
    List<Film> listFilme = StocareFilme.getListaFilme();



    String[] produseDeModificat=new String[100];
    int[] stocDeModificat=new int[100];
    int indexDeModificat=0;


    int indexDeModificatExtra=0;

    float pretTotal=0;
    float valoareCupoane=0;

    String[] arrayNumeMeniuri=new String[10];
    float[] arrayPreturiMeniuri=new float[10];




    String lastButtonPressed="";


    JComboBox<String> comboBox = new JComboBox<>(arrayProduse);
    JComboBox<String> comboBoxMeniuri=new JComboBox<>(arrayNumeMeniuri);

    private StocareFilme filmRepository;

    public PaginaBon(StocareFilme filmRepository) {
        getMeniuriInfo(arrayNumeMeniuri,arrayPreturiMeniuri);

        comboBoxMeniuri.setModel(new DefaultComboBoxModel<>(arrayNumeMeniuri));


        this.filmRepository = filmRepository;

        // Obține lista de filme din baza de date


        // Configurări specifice paginii de bon
        setSize(1400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel container=new JPanel();


        container.setLayout(new BoxLayout(container,BoxLayout.X_AXIS));


        JPanel panelMeniuSiCupon=new JPanel();
        JPanel panelMeniu=new JPanel();
        JPanel panelBon=new JPanel();
        JPanel panelButoane=new JPanel();
        JPanel panelCupon=new JPanel();

        // Butoane
        JButton bauturiButton = new JButton("Bauturi");
        JButton cipsuriButton = new JButton("Cipsuri");
        JButton dulciuriButton = new JButton("Dulciuri");
        JButton filmeButton = new JButton("Filme");
        JButton extraButton = new JButton("Extra");
        JButton adaugaButton= new JButton("Adauga");
        JButton printButton=new JButton("Print");
        JButton adaugaBiletFilmButton=new JButton("Adauga Bilet");
        JButton adaugaPeMeniuButton=new JButton("Adauga pe Meniu");
        JButton adaugaMeniuPeBon=new JButton("Adauga meniul pe bon");
        JButton aplicaCupon=new JButton("Aplica cupon");

        JTextField textFieldCantitate=new JTextField("");
        JTextField textFieldCupon=new JTextField("");
        textFieldCupon.setPreferredSize(new Dimension(50,25));



        JLabel labelCantitate=new JLabel("Cantitate");
        labelCantitate.setFont(new Font("Arial",Font.PLAIN,24));
        JLabel totalLabelText=new JLabel("Total");
        JLabel totalLabelPret=new JLabel(String.valueOf(pretTotal));
        JLabel produsePeMeniu=new JLabel("");


        JScrollPane scrollPaneProdusePeMeniu=new JScrollPane(produsePeMeniu);


        panelButoane.setBackground(Color.BLUE);
        panelButoane.setLayout(new GridLayout(0,2));
        panelButoane.setMaximumSize(new Dimension(700,600));
        panelButoane.setMinimumSize(new Dimension(700,600));
        panelButoane.setPreferredSize(new Dimension(700,600));


        panelButoane.add(bauturiButton);
        panelButoane.add(cipsuriButton);
        panelButoane.add(dulciuriButton);
        panelButoane.add(extraButton);
        panelButoane.add(filmeButton);
        panelButoane.add(adaugaBiletFilmButton);
        panelButoane.add(adaugaButton);
        panelButoane.add(adaugaPeMeniuButton);
        panelButoane.add(comboBox);
        panelButoane.add(printButton);

        panelButoane.add(textFieldCantitate);
        panelButoane.add(labelCantitate);

        panelMeniuSiCupon.setMaximumSize(new Dimension(400,600));
        panelMeniuSiCupon.setMinimumSize(new Dimension(400,600));
        panelMeniuSiCupon.setPreferredSize(new Dimension(400,600));
        panelMeniuSiCupon.setBackground(Color.ORANGE);
        panelMeniuSiCupon.setLayout(new GridLayout(2,0));


        panelBon.setSize(new Dimension(300,600));
        panelBon.setLayout(new GridLayout(0,2));

        panelBon.add(totalLabelText);
        panelBon.add(totalLabelPret);
        JScrollPane scrollPane=new JScrollPane(panelBon);


        panelMeniu.setLayout(new FlowLayout());
        panelMeniu.setBackground(Color.ORANGE);

        panelMeniu.add(comboBoxMeniuri);
        panelMeniu.add(scrollPaneProdusePeMeniu);
        panelMeniu.add(adaugaMeniuPeBon);



        panelCupon.setLayout(new FlowLayout());
        panelCupon.add(textFieldCupon);
        panelCupon.add(aplicaCupon);







        panelMeniuSiCupon.add(panelMeniu);
        panelMeniuSiCupon.add(panelCupon);

        container.add(panelButoane);
        container.add(panelMeniuSiCupon);
        container.add(scrollPane);
        add(container);





        Label totalLabel=new Label(String.valueOf(pretTotal));














//        JPanel panelButoane=new JPanel();
//        JPanel panelBon=new JPanel();
//        JPanel panelMeniu=new JPanel();
//
//        panelButoane.setLayout(null);
//        panelButoane.setBounds(0,0,1100,600);
//        panelBon.setLayout(new BoxLayout(panelBon,BoxLayout.Y_AXIS));
//      //  panelBon.setBounds(1100,0,300,600);
//
//        JLabel labelTest1=new JLabel("Produs1");
//        JLabel labelTest2=new JLabel("Produs2");
//        JLabel labelTest3=new JLabel("Produs3");
//        JLabel labelTest4=new JLabel("Produs4");
//        JLabel labelTest5=new JLabel("Produs5");
//        JLabel labelTest6=new JLabel("Produs6");
////        labelTest2.setBounds(1100,100,200,50);
////        labelTest2.setBounds(1100,300,200,50);
////        labelTest3.setBounds(1100,500,200,50);
////        labelTest4.setBounds(1100,700,200,50);
////        labelTest5.setBounds(1100,900,200,50);
////        labelTest6.setBounds(1100,1100,200,50);
//
//        panelBon.add(labelTest1);
//        panelBon.add(labelTest2);
//        panelBon.add(labelTest3);
//        panelBon.add(labelTest4);
//        panelBon.add(labelTest5);
//        panelBon.add(labelTest6);
//        panelBon.add(Box.createVerticalGlue());
//
//
//        // Make the panel scrollable
//        JScrollPane paneBon = new JScrollPane(panelBon);
//       // paneBon.setBounds(1100,0,300,600);
//
//        paneBon.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        paneBon.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        paneBon.setViewportView(panelBon);
////        paneBon.add(labelTest1);
////        paneBon.add(labelTest2);
////        paneBon.add(labelTest3);
////        paneBon.add(labelTest4);
////        paneBon.add(labelTest5);
////        paneBon.add(labelTest6);
//        add(panelButoane);
//        add(paneBon);
//        //add(panelBon);
//
//
//
//
//        bauturiButton.setBounds(10, 10, 100, 25);
//        bauturiButton.setLocation(10,10);
//        bauturiButton.setSize(100,25);
//        cipsuriButton.setBounds(110,10,100,25);
//        dulciuriButton.setBounds(210,10,100,25);
//        extraButton.setBounds(310,10,100,25);
//        filmeButton.setBounds(410,10,100,25);
//        adaugaButton.setBounds(10,300,100,25);
//        adaugaBiletFilmButton.setBounds(10,300,100,25);
//        printButton.setBounds(10,400,100,25);
//        totalLabel.setBounds(1000,500,75,25);
//        comboBox.setBounds(10,50,100,25);
//        textField.setBounds(210,50,100,25);
//
//
//        // Adaugare butoane
//
//        panelButoane.add(bauturiButton);
//        panelButoane.add(cipsuriButton);
//        panelButoane.add(dulciuriButton);
//        panelButoane.add(extraButton);
//        panelButoane.add(filmeButton);
//        panelButoane.add(adaugaButton);
//        panelButoane.add(printButton);
//        panelButoane.add(comboBox);
//        panelButoane.add(textField);
//        panelButoane.add(totalLabel);



//
//        panelButoane.setBackground(Color.RED);
//        panelBon.setBackground(Color.ORANGE);



//        JLabel labelTest1=new JLabel("Produs1");
//        JLabel labelTest2=new JLabel("Produs2");
//        JLabel labelTest3=new JLabel("Produs3");
//        JLabel labelTest4=new JLabel("Produs4");
//        JLabel labelTest5=new JLabel("Produs5");
//        JLabel labelTest6=new JLabel("Produs6");
//        labelTest2.setBounds(1100,10,200,50);
//        labelTest2.setBounds(1100,30,200,50);
//        labelTest3.setBounds(1100,50,200,50);
//        labelTest4.setBounds(1100,70,200,50);
//        labelTest5.setBounds(1100,90,200,50);
//        labelTest6.setBounds(1100,110,200,50);
//
//        panelBon.add(labelTest1);
//        panelBon.add(labelTest2);
//        panelBon.add(labelTest3);
//        panelBon.add(labelTest4);
//        panelBon.add(labelTest5);
//        panelBon.add(labelTest6);




        // Action listeners butoane


        bauturiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastButtonPressed="bauturi";
             //   remove(adaugaBiletFilmButton);
              //  adaugaButton.setBounds(10,300,100,25);

               // panelButoane.add(adaugaButton);
//                panelButoane.repaint();

                LogicaBon.putProduseInCombobox(arrayProduse,arrayCantitateProdus,arrayPretProdus,listProdus,"Bauturi",comboBox);

            }
        });

        cipsuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastButtonPressed="cipsuri";
               // remove(adaugaBiletFilmButton);
               // panelButoane.add(adaugaButton);
                repaint();

                LogicaBon.putProduseInCombobox(arrayProduse,arrayCantitateProdus,arrayPretProdus,listProdus,"Cipsuri",comboBox);

            }
        });

        dulciuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastButtonPressed="dulciuri";
                LogicaBon.putProduseInCombobox(arrayProduse,arrayCantitateProdus,arrayPretProdus,listProdus,"Dulciuri",comboBox);

            }
        });

        adaugaBiletFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                float pretTotalLocal = (Integer.parseInt(textFieldCantitate.getText()) * (arrayPretProdus[comboBox.getSelectedIndex()] * 10) / 10);
                pretTotal=pretTotal+pretTotalLocal;
                addToBon(textFieldCantitate.getText().concat("x").concat(comboBox.getSelectedItem().toString()).toString(),pretTotalLocal,panelBon);
                totalLabelPret.setText(String.valueOf(pretTotal));

                    revalidate();
            }
        });
        filmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                for (i=0;i<10;i++)
                {
                    arrayProduse[i]="";
                    idItems[i]=0;
                    arrayCantitateProdus[i]=0;
                    arrayPretProdus[i]=0;
                }
                i=0;
                for(Film film:listFilme)
                {

                  arrayProduse[i]=film.getNume();
                  arrayPretProdus[i]=film.getPret();
                  i++;
                }
                comboBox.setModel(new DefaultComboBoxModel<>(arrayProduse));

            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();


                // Actualizează stoc_produse
                    if(indexDeModificat>0) {
                        for (int counter = 0; counter <= indexDeModificat; counter++) {
                            String updateStocQuery = "UPDATE stoc_produse sp " +
                                    "INNER JOIN produse p ON sp.id_produs = p.id " +
                                    "SET sp.cantitate =sp.cantitate-" + stocDeModificat[counter] + " " +
                                    "WHERE p.nume = '" + produseDeModificat[counter].toString() + "'";
                            System.out.println(produseDeModificat[counter].toString() + " " + stocDeModificat[counter]);
                            statement.executeUpdate(updateStocQuery);
                            produseDeModificat[counter]="";
                            stocDeModificat[counter]=0;
                        }
                    }

                }
                catch (Exception exception)
                {
                System.out.println(exception);
                }

                JOptionPane.showMessageDialog(null, "Total de plată : ".concat(String.valueOf(pretTotal)));
                insertVanzare(pretTotal+valoareCupoane);
                indexDeModificat=0;
                indexDeModificatExtra=0;
                 panelBon.removeAll();
                 revalidate();
                 repaint();

                comboBox.setModel(new DefaultComboBoxModel<>(arrayRevalidareProduse));


            }
        });

        extraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastButtonPressed = "dulciuri";
                LogicaBon.putProduseInCombobox(arrayProduse, arrayCantitateProdus, arrayPretProdus, listProdus, "Extra", comboBox);
            }
        });

        aplicaCupon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretTotal=pretTotal-Float.valueOf(textFieldCupon.getText().toString());
                valoareCupoane=valoareCupoane+Float.valueOf(textFieldCupon.getText().toString());
                addToBon("Cupon Reducere",-1*Float.valueOf(textFieldCupon.getText().toString()),panelBon);
                totalLabelPret.setText(String.valueOf(pretTotal));
                revalidate();
            }
        });


        adaugaPeMeniuButton.addActionListener(new ActionListener() {
                @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayCantitateProdus[comboBox.getSelectedIndex()] >= Integer.parseInt(textFieldCantitate.getText()) && Integer.parseInt(textFieldCantitate.getText())>0) {

                 //   float pretProduse=(Integer.parseInt(textFieldCantitate.getText()) * (arrayPretProdus[comboBox.getSelectedIndex()] * 10) / 10);
                  //  pretTotal = pretTotal+pretProduse;
                  //  addToBon(textFieldCantitate.getText().concat("x").concat(comboBox.getSelectedItem().toString()),pretProduse,panelBon);
                    produseDeModificat[indexDeModificat] = comboBox.getSelectedItem().toString();
                    stocDeModificat[indexDeModificat] = Integer.parseInt(textFieldCantitate.getText());
                    indexDeModificat++;
                    produsePeMeniu.setText(produsePeMeniu.getText().concat(",").concat(textFieldCantitate.getText().concat("x").concat(comboBox.getSelectedItem().toString())));

                    //totalLabelPret.setText(String.valueOf(pretTotal));

                    revalidate();

                } else {

                    JOptionPane.showMessageDialog(PaginaBon.this, "Stoc insuficient", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        adaugaMeniuPeBon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              addToBon(comboBoxMeniuri.getSelectedItem().toString(),arrayPreturiMeniuri[comboBoxMeniuri.getSelectedIndex()],panelBon );
              pretTotal=pretTotal+arrayPreturiMeniuri[comboBoxMeniuri.getSelectedIndex()];
              totalLabelPret.setText(String.valueOf(pretTotal));
              produsePeMeniu.setText("");
              revalidate();
            }
        });

        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayCantitateProdus[comboBox.getSelectedIndex()] >= Integer.parseInt(textFieldCantitate.getText()) && Integer.parseInt(textFieldCantitate.getText())>0) {

                    float pretProduse=(Integer.parseInt(textFieldCantitate.getText()) * (arrayPretProdus[comboBox.getSelectedIndex()] * 10) / 10);
                    pretTotal = pretTotal+pretProduse;
                    addToBon(textFieldCantitate.getText().concat("x").concat(comboBox.getSelectedItem().toString()),pretProduse,panelBon);
                    produseDeModificat[indexDeModificat] = comboBox.getSelectedItem().toString();
                    stocDeModificat[indexDeModificat] = Integer.parseInt(textFieldCantitate.getText());
                    indexDeModificat++;

                    totalLabelPret.setText(String.valueOf(pretTotal));

                    revalidate();

                } else {

                    JOptionPane.showMessageDialog(PaginaBon.this, "Stoc insuficient", "Error", JOptionPane.ERROR_MESSAGE);
                }

                }
        });
    }


    private void addToBon(String nume,float pret,JPanel panelBon)
    {


        panelBon.add(new JLabel(nume));
        panelBon.add(new JLabel(String.valueOf(pret)));

    }


    public void afiseazaPaginaBon() {


        setVisible(true);
    }






}

package GUI;

import Utils.Vanzari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class PaginaVanzari extends JFrame {
    private JComboBox<String> startDayComboBox;
    private JComboBox<String> startMonthComboBox;
    private JTextField startYearTextField;

    private JComboBox<String> endDayComboBox;
    private JComboBox<String> endMonthComboBox;
    private JTextField endYearTextField;
    private JTextArea sumaVanzari;

    public PaginaVanzari() {
        setTitle("Date Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*
        Map<String, Integer> monthMap = new LinkedHashMap<>(); //Hashmap simplu nu le pune ordonat
        monthMap.put("January", 01);
        monthMap.put("February", 02);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
        String[] months = monthMap.keySet().toArray(new String[0]); // mai bine puneam array direct
        System.out.println(months);

         */
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

        String[] days = new String[32];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i+1);//daca incep de la 0 se vede goala prima linie
        }

        //array de string uri pt ca asa imi trebuie cand transform in data

            startYearTextField = new JTextField();
            endYearTextField = new JTextField();

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);

        panel.setLayout(new GridLayout(3, 4));
        startDayComboBox = new JComboBox<>(days);
        endDayComboBox = new JComboBox<>(days);
        startMonthComboBox = new JComboBox<>(months);
        endMonthComboBox = new JComboBox<>(months);
        sumaVanzari = new JTextArea();
        sumaVanzari.setEditable(false);

        JButton calculateButton = new JButton("Calculate Sum");

        panel.add(new JLabel("Start Date:"));
        panel.add(startDayComboBox);
        panel.add(startMonthComboBox);
        panel.add(startYearTextField);
        panel.add(new JLabel("End Date:"));
        panel.add(endDayComboBox);
        panel.add(endMonthComboBox);
        panel.add(endYearTextField);
        //panel.add(new JLabel("Result:"));
        panel.add(sumaVanzari);
        panel.add(calculateButton);

        setSize(1000,1000);
        setLocationRelativeTo(null);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStartDay = (String) startDayComboBox.getSelectedItem();
                String selectedStartMonth = (String) startMonthComboBox.getSelectedItem();
                String selectedStartYear = startYearTextField.getText();

                String selectedEndDay = (String) endDayComboBox.getSelectedItem();
                String selectedEndMonth = (String) endMonthComboBox.getSelectedItem();
                String selectedEndYear = endYearTextField.getText();
                StringBuilder startDate = new StringBuilder();
                startDate.append(selectedStartYear).append("-");
                startDate.append(selectedStartMonth).append("-");
                startDate.append(selectedStartDay);
                String formattedStartDate = startDate.toString();
                StringBuilder endDate = new StringBuilder();
                endDate.append(selectedEndYear).append("-");
                endDate.append(selectedEndMonth).append("-");
                endDate.append(selectedEndDay);
                String formattedendDate = endDate.toString();
                try {
                    float sum = Vanzari.getSumaVanzari(formattedStartDate,formattedendDate);
                            sumaVanzari.setText(String.valueOf(sum));
                    System.out.println(selectedStartYear);
                    System.out.println(selectedEndMonth);


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }



            }
        });
    }



}

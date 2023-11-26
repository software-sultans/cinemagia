package produse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificareStocPage {
    private JFrame frame;

    public ModificareStocPage() {
        frame = new JFrame("Modificare Stoc");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        JButton adaugaButton = new JButton("Adaugă");
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaginaAdaugareProdus paginaAdaugareProdus = new PaginaAdaugareProdus();
                paginaAdaugareProdus.afiseazaPaginaAdaugareProdus();
            }
        });

        JButton stergeButton = new JButton("Actualizeaza");
        stergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaginaActualizareStoc paginaActualizareStoc = new PaginaActualizareStoc();
                paginaActualizareStoc.afiseazaPaginaActualizareStoc();
            }
        });

        panel.add(adaugaButton);
        panel.add(stergeButton);

        frame.add(panel);
    }

    public void afiseazaInterfataModificareStoc() {
        frame.setVisible(true);
    }
}

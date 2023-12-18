package GUI;
import filme.StocareFilme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MeniuPrincipalPage extends JFrame {

    public MeniuPrincipalPage() {
        // Setează titlul ferestrei
        setTitle("Meniu Principal");

        // Setează culoarea de fundal
        getContentPane().setBackground(Color.decode("#FFA500"));

        // Crează componente
        JButton stocButton = new JButton("Stoc");
        JButton creareBonButton = new JButton("Creare Bon");
        JButton filmeButton = new JButton("Filme");
        JButton logoutButton = new JButton("Logout");

        // Crează un container pentru butoane și setează managerul de layout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Face container-ul invizibil pentru a lăsa culoarea fundalului să se vadă

        // Adaugă butoanele la container
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        buttonPanel.add(stocButton, gbc);
        buttonPanel.add(creareBonButton, gbc);
        buttonPanel.add(filmeButton, gbc);
        buttonPanel.add(logoutButton, gbc);

        // Adaugă container-ul cu butoane în cadrul ferestrei
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // Adaugă border-ul negru în jurul ferestrei
        LineBorder blackBorder = new LineBorder(Color.decode("#000000"), 3);
        ((JPanel)getContentPane()).setBorder(blackBorder);

        // Centrare fereastră pe ecran
        pack();
        setLocationRelativeTo(null);

        filmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Deschide fereastra cu lista de filme
                ListaFilmePage listaFilmePage = new ListaFilmePage(new StocareFilme());
                listaFilmePage.setVisible(true);
            }
        });

        stocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Deschide fereastra de stoc
                PaginaStoc paginaStoc = new PaginaStoc();
                paginaStoc.afiseazaPaginaStoc();
            }
        });
        creareBonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaginaBon paginaBon=new PaginaBon(new StocareFilme());
                paginaBon.afiseazaPaginaBon();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });


        // Setează dimensiunile fixe ale ferestrei
        setSize(400, 400);

        // Centralizează fereastra pe ecran
        setLocationRelativeTo(null);

        // Setează operațiunea implicită la închiderea ferestrei
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Face fereastra non-scalabilă
        setResizable(false);
    }
}

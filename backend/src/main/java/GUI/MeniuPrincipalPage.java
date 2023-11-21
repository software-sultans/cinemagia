package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MeniuPrincipalPage extends JFrame {

    public MeniuPrincipalPage() {
        // Setează titlul ferestrei
        setTitle("Meniu Principal");

        // Crează componente
        JButton stocButton = new JButton("Stoc");
        JButton creareBonButton = new JButton("Creare Bon");
        JButton filmeButton = new JButton("Filme");
        JButton logoutButton = new JButton("Logout");

        // Setează managerul de layout la null pentru poziționare absolută
        setLayout(null);

        // Poziționează componente pe fereastră
        stocButton.setBounds(10, 20, 150, 30);
        creareBonButton.setBounds(10, 60, 150, 30);
        filmeButton.setBounds(10, 100, 150, 30);
        logoutButton.setBounds(10, 140, 150, 30);

        // Adaugă componente la fereastră
        add(stocButton);
        add(creareBonButton);
        add(filmeButton);
        add(logoutButton);

        // Setează dimensiunile fixe ale ferestrei
        setSize(200, 220);

        // Centralizează fereastra pe ecran
        setLocationRelativeTo(null);

        // Setează operațiunea implicită la închiderea ferestrei
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Face fereastra non-scalabilă
        setResizable(false);
    }
}
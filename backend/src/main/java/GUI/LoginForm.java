package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        // Setează titlul ferestrei
        setTitle("Logare");

        // Crează componente
        JLabel usernameLabel = new JLabel("Utilizator:");
        JLabel passwordLabel = new JLabel("Parolă:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Conectare");

        // Setează managerul de layout la null pentru poziționare absolută
        setLayout(null);

        // Poziționează componente pe fereastră
        usernameLabel.setBounds(10, 20, 80, 25);
        usernameField.setBounds(100, 20, 160, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordField.setBounds(100, 50, 160, 25);
        loginButton.setBounds(10, 80, 100, 25);

        // Adaugă componente la fereastră
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Adaugă ascultător pentru butonul de conectare
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Aici poți adăuga logica de verificare a numelui de utilizator și parolei
                // Într-un scenariu real, ar trebui să te conectezi la o bază de date sau să folosești un serviciu de autentificare

                // Exemplu simplu de redirecționare către Meniu Principal
                dispose(); // închide fereastra de logare
                MeniuPrincipalPage meniuPrincipalPage = new MeniuPrincipalPage();
                meniuPrincipalPage.setVisible(true);
            }
        });

        // Setează dimensiunile fixe ale ferestrei
        setSize(300, 150);

        // Centralizează fereastra pe ecran
        setLocationRelativeTo(null);

        // Setează operațiunea implicită la închiderea ferestrei
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Face fereastra non-scalabilă
        setResizable(false);
    }
}
package GUI;

import database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public static int idAngajat = -1;

    public LoginForm() {
        // Setează titlul ferestrei
        setTitle("Logare");

        // Crează componente
        JLabel loginLabel = new JLabel("Login", SwingConstants.CENTER); // Eticheta va fi centrată
        loginLabel.setFont(loginLabel.getFont().deriveFont(Font.BOLD, 20)); // Mărește fontul etichetei
        JLabel usernameLabel = new JLabel("Utilizator:");
        JLabel passwordLabel = new JLabel("Parolă:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Conectare");

        // Setează managerul de layout la null pentru poziționare absolută
        setLayout(null);

        // Poziționează componente pe fereastră
        loginLabel.setBounds(10, 10, 280, 35); // Ajustează dimensiunea și poziționarea pentru centrat și mărime text
        usernameLabel.setBounds(10, 55, 80, 25);
        usernameField.setBounds(100, 55, 160, 25);
        passwordLabel.setBounds(10, 85, 80, 25);
        passwordField.setBounds(100, 85, 160, 25);
        loginButton.setBounds(10, 115, 100, 25);

        // Adaugă componente la fereastră
        add(loginLabel);
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

                // Adaugă logica de verificare a numelui de utilizator și parolei în baza de date
                if (authenticate(username, password)) {

                    // Autentificare reușită
                    dispose(); // închide fereastra de logare
                    MeniuPrincipalPage meniuPrincipalPage = new MeniuPrincipalPage();
                    meniuPrincipalPage.setVisible(true);
                } else {
                    // Autentificare eșuată
                    JOptionPane.showMessageDialog(LoginForm.this, "Autentificare eșuată. Verificați utilizatorul și parola.",
                            "Eroare de autentificare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Setează dimensiunile ferestrei
        setSize(300, 200);

        // Centralizează fereastra pe ecran
        setLocationRelativeTo(null);

        // Setează operațiunea implicită la închiderea ferestrei
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Face fereastra non-scalabilă
        setResizable(false);

        // Setează fundalul și border-ul ferestrei
        getContentPane().setBackground(Color.decode("#FFA500"));
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Adaugă un border de dimensiune 2
    }

    public static boolean authenticate(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifică autentificarea utilizatorului
            String query = "SELECT * FROM angajati WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    idAngajat = resultSet.getInt(1);
                    return idAngajat != -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Autentificare eșuată în caz de excepție SQL
        }
    }
}
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

    public static int idAngajat=-1;

    public LoginForm() {

        setTitle("Logare");

        JLabel usernameLabel = new JLabel("Utilizator:");
        JLabel passwordLabel = new JLabel("Parolă:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Conectare");


        setLayout(null);


        usernameLabel.setBounds(10, 20, 80, 25);
        usernameField.setBounds(100, 20, 160, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordField.setBounds(100, 50, 160, 25);
        loginButton.setBounds(10, 80, 100, 25);


        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);


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


        setSize(300, 150);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setResizable(false);
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
                    idAngajat=resultSet.getInt(1);
                    if(idAngajat!=-1)
                        return true;
                    else
                        return false;

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Autentificare eșuată în caz de excepție SQL
        }

    }
}
package GUI;

import javax.swing.*;

class GUI {
    public static void main(String[] args) {
        // Rulează aplicația
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);}
        });
    }

}

package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gui {
    public static void main(String[] args) {


        // Rulează aplicația
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

}
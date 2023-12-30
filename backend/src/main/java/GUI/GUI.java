package GUI;

import javax.swing.*;
import java.time.LocalDateTime;

class Gui {
    public static void main(String[] args) {
        // Rulează aplicația
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);}
        });
    }

}

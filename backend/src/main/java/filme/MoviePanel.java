package filme;

import filme.Film;
import Utils.BitToImg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import static Utils.BitToImg.createImageIcon;

public class MoviePanel extends JPanel {
    private JLabel nameLabel;
    private JLabel durationLabel;
    private JLabel directorLabel;
    private JLabel genreLabel;
    private JLabel priceLabel;
    private JLabel posterLabel;
    private JLabel descriptionLabel;
    private JLabel dataLansareLabel;
    private JLabel PGLabel;

    private JButton reserveButton;

    public MoviePanel(Film film) {
        setLayout(new BorderLayout());

        // Left panel for the poster
        JPanel posterPanel = new JPanel();
        posterLabel = new JLabel();
        posterPanel.add(posterLabel);
        add(posterPanel, BorderLayout.WEST);

        // Right panel for movie information and reserve button
        JPanel infoPanel = new JPanel(new GridLayout(9, 1));
        nameLabel = new JLabel("Nume: " + film.getNume());
        durationLabel = new JLabel("Durata: " + film.getDurata());
        directorLabel = new JLabel("Regizor: " + film.getRegizor());
        genreLabel = new JLabel("Gen: " + film.getGen());
        priceLabel = new JLabel("Pret: " + film.getPret());
        descriptionLabel = new JLabel(("Descriere : " + film.getDescriere()));
        dataLansareLabel = new JLabel(("Data Lansare : " + film.getDataLansare()));
        PGLabel = new JLabel(("Parental Guidance  : " + film.getParentalGuidance()));

        reserveButton = new JButton("Reserve");

        infoPanel.add(nameLabel);
        infoPanel.add(durationLabel);
        infoPanel.add(directorLabel);
        infoPanel.add(genreLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(descriptionLabel);
        infoPanel.add(dataLansareLabel);
        infoPanel.add(PGLabel);
        infoPanel.add(reserveButton);
        add(infoPanel, BorderLayout.CENTER);

        // Display the ImageIcon in a JLabel
        if (film.getPoster() != null) {
            ImageIcon imageIcon = createImageIcon(film.getPoster());
            posterLabel.setIcon(imageIcon);
        }

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SwingUtilities.invokeLater(() -> {
                    new SeatSelectionWindow(film.getNume(),10, 10).setVisible(true);
                });
            }

        });

    }
}


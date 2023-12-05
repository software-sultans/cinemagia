package GUI;

import filme.Film;
import filme.MoviePanel;
import filme.StocareFilme;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ListaFilmePage extends JFrame {
    private StocareFilme filmRepository;

    public ListaFilmePage(StocareFilme filmRepository) {
        this.filmRepository = filmRepository;

        setTitle("Lista Filme");

        // Obține lista de filme din baza de date
        List<Film> filme = StocareFilme.getListaFilme();

        // Create a panel to hold movie entries
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));

        // Add MoviePanel instances for each film
        for (Film film : filme) {
            moviePanel.add(new MoviePanel(film));
            moviePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some spacing between entries
        }
        
        JScrollPane scrollPane = new JScrollPane(moviePanel);

        // Add the JScrollPane to the content pane
        add(scrollPane);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

    }
}

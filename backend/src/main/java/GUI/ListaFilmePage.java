package GUI;

import Utils.BitToImg;
import Utils.ImageRender;
import filme.Film;
import filme.StocareFilme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class ListaFilmePage extends JFrame {
    private StocareFilme filmRepository;

    public ListaFilmePage(StocareFilme filmRepository) {
        this.filmRepository = filmRepository;

        setTitle("Lista Filme");

        // Obține lista de filme din baza de date
        List<Film> filme = StocareFilme.getListaFilme();

        // Creează un model pentru tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nume");
        model.addColumn("Durata");
        model.addColumn("Regizor");
        model.addColumn("Gen");
        model.addColumn("Pret");
        model.addColumn("Poster");

        // Adaugă datele despre filme în modelul tabelului
        for (Film film : filme) {
            model.addRow(new Object[]{film.getNume(), film.getDurata(), film.getRegizor(), film.getGen(), film.getPret(), BitToImg.createImageIcon(film.getPoster())});
        }

        // Creează tabelul cu modelul creat
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(5).setCellRenderer(new ImageRender()); // Column index is 5 for "Poster"


        // Adaugă tabelul într-un JScrollPane pentru a permite derularea în cazul în care există multe filme
        JScrollPane scrollPane = new JScrollPane(table);

        // Adaugă JScrollPane-ul la conținutul ferestrei
        add(scrollPane);

        // Setează dimensiunile ferestrei
        setSize(500, 500);

        // Centralizează fereastra pe ecran
        setLocationRelativeTo(null);

        // Setează operațiunea implicită la închiderea ferestrei
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Face fereastra non-scalabilă
        setResizable(false);
    }
}

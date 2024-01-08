package filme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SeatSelectionWindow extends JFrame {
    private String movieName;
    private int rows;
    private int cols;
    private boolean[][] seatMatrix;

    // Map to store reservation data for each movie
    private static Map<String, boolean[][]> reservationData = new HashMap<>();

    public SeatSelectionWindow(String movieName, int rows, int cols) {
        this.movieName = movieName;
        this.rows = rows;
        this.cols = cols;

        if (reservationData.containsKey(movieName)) {
            this.seatMatrix = reservationData.get(movieName);
        } else {
            this.seatMatrix = new boolean[rows][cols];
        }

        setTitle("Seat Selection - " + movieName);
        setLayout(new GridLayout(rows, cols));

        // Set default background color for selected and unselected JToggleButtons
        UIManager.put("ToggleButton.select", Color.red);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JToggleButton seatButton = new JToggleButton();
                seatButton.setSelected(seatMatrix[i][j]); // Set initial selection state
                add(seatButton);
                // Set action listener after adding the button to the layout
                seatButton.addActionListener(new SeatButtonListener(i, j, seatButton));
                updateSeatColor(seatButton, i, j); // Set initial background color
            }
        }

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private class SeatButtonListener implements ActionListener {
        private int row;
        private int col;
        private JToggleButton seatButton;

        public SeatButtonListener(int row, int col, JToggleButton seatButton) {
            this.row = row;
            this.col = col;
            this.seatButton = seatButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Toggle the seat status in the matrix
            seatMatrix[row][col] = !seatMatrix[row][col];
           // System.out.println("rand " + row + "coloana " + col);
            saveReservationData();
            updateSeatColor(seatButton, row, col);
        }
    }

    private void updateSeatColor(JToggleButton seatButton, int row, int col) {
        if (seatMatrix[row][col]) {
            // Reserved
            seatButton.setBackground(Color.RED);
        } else {
            // Not reserved
            seatButton.setBackground(Color.GREEN);
        }
    }

    private void saveReservationData() {
        // Save reservation data for the movie to the map
        reservationData.put(movieName, seatMatrix);
    }
}

import javax.swing.*;
import java.awt.*;


public class TTTGameFrame extends JFrame{
    private TTTTileButton[][] buttons = new TTTTileButton[3][3];
    private  JLabel statusLabel;
    private TTTGame game;
    private JPanel boardPanel;

    public  TTTGameFrame(){
        setTitle("TTT Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //top panel, status label
        statusLabel = new JLabel("Player X's turn");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel, BorderLayout.NORTH);

       // setLayout(new BorderLayout());
        //center panel, game board
        boardPanel = new JPanel(new GridLayout(3, 3));

        game = new TTTGame(this);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TTTTileButton(row, col);
                int finalRow = row;
                int finalCol = col;

                buttons[row][col].addActionListener(e -> {
                    game.handleMove(finalRow, finalCol);
                });

                boardPanel.add(buttons[row][col]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
      //  boardPanel = new JPanel(new GridLayout(3, 3));
        // bottom: reset + quit
        JPanel bottomPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        JButton quitButton = new JButton("Quit");

        resetButton.addActionListener(e -> game.resetGame());
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(resetButton);
        bottomPanel.add(quitButton);
      //  add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);



    }
    public void updateStatus(String message) {
        statusLabel.setText(message);
    }

    // This method is commented out because it is not working right
    public void resetBoardUI(){
        for (TTTTileButton[] row : buttons) {
            for (TTTTileButton button : row) {
                button.setText("");
                button.setEnabled(true);
            }
        }
        updateStatus("Player X's turn");
    }

public void disableBoard(){
    for (TTTTileButton[] row : buttons) {
        for (TTTTileButton button : row) {
            button.setEnabled(false);
        }
    }

}
    public TTTTileButton[][] getButtons() {
        return buttons;
    }

    }


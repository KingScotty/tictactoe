public class TTTGame {
    private TTTGameFrame frame;
    private String currentPlayer; // "X" or "O"

    public TTTGame(TTTGameFrame frame) {
        this.frame = frame;
        currentPlayer = "X"; // X always starts
    }

    public void handleMove(int row, int col) {
        TTTTileButton button = frame.getButtons()[row][col];

        if (button.isEmpty()) {
            button.setSymbol(currentPlayer);

            if (checkWin()) {
                frame.updateStatus("Player " + currentPlayer + " wins!");
                frame.disableBoard();
            } else if (checkTie()) {
                frame.updateStatus("It's a tie!");
                frame.disableBoard();
            } else {
                switchPlayer();
                frame.updateStatus("Player " + currentPlayer + "'s turn");
            }
        }
    }

    private void switchPlayer() {  // <-- ADD "void" keyword
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    private boolean checkWin() {
        TTTTileButton[][] buttons = frame.getButtons();

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].isEmpty() &&
                    buttons[i][0].getSymbol().equals(buttons[i][1].getSymbol()) &&
                    buttons[i][0].getSymbol().equals(buttons[i][2].getSymbol())) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!buttons[0][i].isEmpty() &&
                    buttons[0][i].getSymbol().equals(buttons[1][i].getSymbol()) &&
                    buttons[0][i].getSymbol().equals(buttons[2][i].getSymbol())) {
                return true;
            }
        }

        // Check diagonals
        if (!buttons[0][0].isEmpty() &&
                buttons[0][0].getSymbol().equals(buttons[1][1].getSymbol()) &&
                buttons[0][0].getSymbol().equals(buttons[2][2].getSymbol())) {
            return true;
        }

        if (!buttons[0][2].isEmpty() &&
                buttons[0][2].getSymbol().equals(buttons[1][1].getSymbol()) &&
                buttons[0][2].getSymbol().equals(buttons[2][0].getSymbol())) {
            return true;
        }

        return false;
    }

    private boolean checkTie() {
        TTTTileButton[][] buttons = frame.getButtons();

        for (TTTTileButton[] row : buttons) {
            for (TTTTileButton button : row) {
                if (button.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetGame() {
        currentPlayer = "X";
        frame.resetBoardUI();
    }
}

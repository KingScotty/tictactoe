import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class TTTTileButton extends JButton {
private int row;
private int col;
private String symbol;

public TTTTileButton(int row, int col) {
    this.row = row;
    this.col = col;
    this.symbol = "";
    setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 36));
}

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
        setText(symbol);
        setEnabled(false); // disable after move
    }

    public boolean isEmpty() {
        return symbol.equals("");
    }

}

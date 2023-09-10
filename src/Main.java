// Import classes
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarculaLaf;

/**
 * Main class
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class Main {

    /**
     * Main method
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        setLookAndFeel();
        new Controller();
    }

    /**
     * Set look and feel to FlatDarculaLaf
     */
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, 
                "Unable to set look and feel to FlatDarculaLaf.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
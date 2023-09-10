// Import classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tile
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class Tile extends JPanel {
    
    /**
     * A label that displays the number of the tile
     */
    private JLabel label;

    /**
     * The index of the tile
     */
    private int index;

    /**
     * Constructor
     * @param gamePanel Game panel
     */
    public Tile(GamePanel gamePanel) {
        // Create label
        label = new JLabel("", JLabel.CENTER);
        // Set background color
        setBackground(Color.DARK_GRAY);
        // Set layout manager
        setLayout(new BorderLayout());
        // Set border color to black
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Add label to tile
        add(label);
        addComponentListener(new ComponentAdapter() {
            // If tile changes size
            @Override
            public void componentResized(ComponentEvent e) {
                // Change label font size
                label.setFont(new Font("Liberation Sans", Font.PLAIN, gamePanel.getHeight() / 15));
            }
        });
        addMouseListener(new MouseAdapter() {
            // If mouse clicks on tile
            @Override
            public void mouseClicked(MouseEvent e) {
                // Call method moveTile from class GamePanel
                gamePanel.moveTile(getIndex());
            }
            // If mouse enters tile
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change border color to blue
                setBorder(BorderFactory.createLineBorder(Color.BLUE));
            }
            // If mouse exits tile
            @Override
            public void mouseExited(MouseEvent e) {
                // Change border color to black
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
            } 
        });
    }

    /**
     * Set index
     * @param index Index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Get index
     * @return Index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Set number
     * @param num Number
     */
    public void setNum(String num) {
        label.setText(num);
    }

    /**
     * Get number
     * @return Number
     */
    public String getNum() {
        return label.getText();
    }
}
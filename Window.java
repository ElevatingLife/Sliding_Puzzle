// Import classes
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Window
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class Window extends JFrame {
    
    /**
     * A layout manager
     */
    private CardLayout cardLayout;

    /**
     * A panel that holds other panels
     * and uses the layout manager to
     * flip to a specified panel
     */
    private JPanel cardPane;

    /**
     * Set window to full screen
     */
    public void setFullScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int screenWidth = (int) tk.getScreenSize().getWidth();
        int screenHeight = (int) tk.getScreenSize().getHeight();
        setSize(screenWidth, screenHeight);
    }

    /**
     * Add north panel
     * @param northPanel North panel
     */
    public void addNorthPanel(NorthPanel northPanel) {
        add(northPanel, BorderLayout.NORTH);
    }

    /**
     * Add a center panel
     * @param gamePanel Game panel
     * @param settingsPanel Settings panel
     */
    public void addCenterPanel(GamePanel gamePanel, SettingsPanel settingsPanel) {
        cardPane = new JPanel();
        cardLayout = new CardLayout();
        cardPane.setLayout(cardLayout);
        cardPane.add(gamePanel, "Game Panel");
        cardPane.add(settingsPanel, "Settings Panel");
        add(cardPane);
    }

    /**
     * Show a specified card
     * @param cardName Card name
     */
    public void showCard(String cardName) {
        cardLayout.show(cardPane, cardName);
    }
}
// Import classes
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * Controller
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class Controller {

    /**
     * An object of class Window
     */
    private Window window;

    /**
     * An object of class DataTransferObject
     */
    private DataTransferObject dto;

    /**
     * An object of class NorthPanel
     */
    private NorthPanel northPanel;

    /**
     * An object of class GamePanel
     */
    private GamePanel gamePanel;

    /**
     * An object of class SettingsPanel
     */
    private SettingsPanel settingsPanel;
    
    /**
     * Constructor
     */
    public Controller() {
        // Instantiate other classes
        window = new Window();
        dto = new DataTransferObject();
        northPanel = new NorthPanel(this);
        gamePanel = new GamePanel(this, dto);
        settingsPanel = new SettingsPanel(this, dto);

        // North Panel
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        northPanel.addSpace(20, 45);
        northPanel.addResetFeature();
        northPanel.disableResetButton();
        northPanel.addSpace(20, 45);
        northPanel.addSettingsFeature();
        northPanel.addSpace(20, 45);
        northPanel.addExitFeature();
        northPanel.addSpace(20, 45);
        northPanel.addMovesFeature();
        northPanel.addSpace(20, 45);
        northPanel.addTimeFeature();

        // Settings Panel
        settingsPanel.setLayout();
        settingsPanel.addHeading();
        settingsPanel.addRow(1);
        settingsPanel.addColumn(2);
        settingsPanel.addHorizontalGap(3);
        settingsPanel.addVerticalGap(4);
        settingsPanel.addStartGameButton(5);

        // Window
        window.setTitle("Sliding Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setFullScreen();
        window.addNorthPanel(northPanel);
        window.addCenterPanel(gamePanel, settingsPanel);
        window.showCard("Settings Panel");
        window.setVisible(true);
    }

    /**
     * Show a specified card
     * @param cardName Card name
     */
    public void showCard(String cardName) {
        window.showCard(cardName);
    }

    /**
     * Increment the number of moves
     */
    public void incrementMoves() {
        northPanel.incrementMoves();
    }

    /**
     * Start the game
     */
    public void startGame() {
        northPanel.resetMoves();
        northPanel.resetTimer();
        northPanel.startTimer();
        gamePanel.startGame();
    }

    /**
     * Enable the reset button
     */
    public void enableResetButton() {
        northPanel.enableResetButton();;
    }

    /**
     * Disable the reset button
     */
    public void disableResetButton() {
        northPanel.disableResetButton();;
    }

    /**
     * Enable the settings button
     */
    public void enableSettingsButton() {
        northPanel.enableSettingsButton();;
    }

    /**
     * Disable the settings button
     */
    public void disableSettingsButton() {
        northPanel.disableSettingsButton();;
    }
}

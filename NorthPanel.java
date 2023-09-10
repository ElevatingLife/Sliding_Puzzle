// Import classes
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * North Panel
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class NorthPanel extends JPanel {

    /**
     * An object of class Controller
     */
    private Controller controller;

    /**
     * The total number of moves
     */
    private int numOfMoves;

    /**
     * A label that displays the total
     * number of moves
     */
    private JLabel lbNumOfMoves;

    /**
     * Timer
     */
    private Timer timer;

    /**
     * Minutes
     */
    private int min;

    /**
     * Seconds
     */
    private int sec;

    /**
     * A label that displays the time
     */
    private JLabel lbTime;

    /**
     * Whether the user can activate the reset button
     */
    private boolean canReset;
    
    /**
     * Whether the user can activate the settings button
     */
    private boolean canSettings;

    /**
     * Constructor
     * @param controller An object of class Controller
     */
    public NorthPanel(Controller controller) {
        this.controller = controller;
    }

    /**
     * Add space between components
     * @param width Width
     * @param height Height
     */
    public void addSpace(int width, int height) {
        add(Box.createRigidArea(new Dimension(width, height)));
    }

    /**
     * Add a reset feature
     */
    public void addResetFeature() {
        ImageIcon imgReset = new ImageIcon(getClass().getClassLoader().getResource("Reset.png"));
        JLabel lbReset = new JLabel(imgReset);
        lbReset.setToolTipText("Reset");
        lbReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        });
        add(lbReset);
    }

    /**
     * Add a settings feature
     */
    public void addSettingsFeature() {
        ImageIcon imgSettings = new ImageIcon(getClass().getClassLoader().getResource("Settings.png"));
        JLabel lbSettings = new JLabel(imgSettings);
        lbSettings.setToolTipText("Settings");
        lbSettings.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                settings();
            }
        });
        add(lbSettings);
    }
    
    /**
     * Add an exit feature
     */
    public void addExitFeature() {
        ImageIcon imgExit = new ImageIcon(getClass().getClassLoader().getResource("Exit.png"));
        JLabel lbExit = new JLabel(imgExit);
        lbExit.setToolTipText("Exit");
        lbExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit();
            }
        });
        add(lbExit);
    }

    /**
     * Add a move counter feature
     */
    public void addMovesFeature() {
        lbNumOfMoves = new JLabel("Move 0");
        add(lbNumOfMoves);
    }

    /**
     * Add a timer feature
     */
    public void addTimeFeature() {
        lbTime = new JLabel("Time 00:00");
        add(lbTime);
        timer = new Timer(1000, e -> incrementTime());
    }

    /**
     * Reset the game
     */
    private void reset() {
        if (canReset) {
            int option = JOptionPane.showConfirmDialog(this, 
                "Do you want to reset the game?", 
                null, JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                controller.showCard("Game Panel");
                controller.startGame();
            }
        }
    }

    /**
     * Adjust the settings
     */
    private void settings() {
        if (canSettings) {
            int option = JOptionPane.showConfirmDialog(this, 
                "Do you want to adjust the settings?\n" +
                "It will exit the current game.", 
                null, JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                controller.showCard("Settings Panel");
                canSettings = false;
                canReset = false;
                resetMoves();
                stopTimer();
                resetTimer();
            }
        }
    }

    /**
     * Exit the game
     */
    private void exit() {
        int option = JOptionPane.showConfirmDialog(this, 
            "Do you want to exit the game?", 
            null, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Start timer
     */
    public void startTimer() {
        timer.start();
    }

    /**
     * Stop timer
     */
    public void stopTimer() {
        timer.stop();
    }

    /**
     * Reset timer
     */
    public void resetTimer() {
        min = 0;
        sec = 0;
        lbTime.setText("Time 00:00");
    }

    /**
     * Increment time
     */
    private void incrementTime() {
        // Increment second
        sec++;
        // If second equals 60
        if (sec == 60) {
            // Set second to 0
            sec = 0;
            // Increment minute
            min++;
        }
        // Display updated time in format mm:ss
        lbTime.setText("Time " + (min > 9 ? min : "0" + min) + ":" + 
            (sec > 9 ? sec : "0" + sec));
    }

    /**
     * Reset the number of moves
     */
    public void resetMoves() {
        numOfMoves = 0;
        lbNumOfMoves.setText(String.format("Move %d", numOfMoves));
    }

    /**
     * Increment the number of moves
     */
    public void incrementMoves() {
        numOfMoves++;
        lbNumOfMoves.setText(String.format("Move %d", numOfMoves));
    }

    /**
     * Enable the reset button
     */
    public void enableResetButton() {
        canReset = true;
    }

    /**
     * Disable the reset button
     */
    public void disableResetButton() {
        canReset = false;
    }

    /**
     * Enable the settings button
     */
    public void enableSettingsButton() {
        canSettings = true;
    }

    /**
     * Disable the settings button
     */
    public void disableSettingsButton() {
        canSettings = false;
    }
}
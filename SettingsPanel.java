// Import classes
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Settings Panel
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class SettingsPanel extends JPanel {

    /**
     * An object of class Controller
     */
    private Controller controller;

    /**
     * An object of class DataTransferObject
     */
    private DataTransferObject dto;

    /**
     * A field for the user to enter 
     * the number of tiles in a row
     */
    private JTextField tfRow;
    
    /**
     * A field for the user to enter 
     * the number of tiles in a column
     */
    private JTextField tfCol;
    
    /**
     * A field for the user to enter 
     * the amount of space between tiles in a row
     */
    private JTextField tfHorGap;
    
    /**
     * A field for the user to enter the amount 
     * of space between tiles in a column
     */
    private JTextField tfVerGap;

    /**
     * Two constraints used by the GridBagLayout manager
     */
    private GridBagConstraints col1, col2;

    /**
     * Constructor
     * @param controller An object of class Controller
     * @param dto An object of class DataTransferObject
     */
    public SettingsPanel(Controller controller, DataTransferObject dto) {
        this.controller = controller;
        this.dto = dto;
    }

    /**
     * Set layout
     */
    public void setLayout() {
        // Set layout manager
        setLayout(new GridBagLayout());
        // Create two layout manager constraints
        col1 = new GridBagConstraints();
        col2 = new GridBagConstraints();
        // Set spacing between components
        col1.insets = new Insets(5, 5, 5, 5);
        col2.insets = new Insets(5, 5, 5, 5);
        // Set anchoring for components
        col1.anchor = GridBagConstraints.EAST;
        col2.anchor = GridBagConstraints.WEST;
    }

    /**
     * Add heading "SETTINGS"
     */
    public void addHeading() {
        JLabel lbHeading = new JLabel("SETTINGS", JLabel.RIGHT);
        col1.gridx = 0;
        col1.gridy = 0;
        add(lbHeading, col1);
    }

    /**
     * Add a label and a field for user to enter 
     * the number of tiles to be displayed in a row
     * @param gridy Y-coordinate
     */
    public void addRow(int gridy) {
        // Label
        JLabel lbRow = new JLabel("Enter the number of tiles " +
            "to be displayed in a row:", JLabel.RIGHT);
        col1.gridx = 0;
        col1.gridy = gridy;
        add(lbRow, col1);
        // Field
        tfRow = new JTextField(7);
        col2.gridx = 1;
        col2.gridy = gridy;
        add(tfRow, col2);
    }

    /**
     * Add a label and a field for the user to enter
     * the number of tiles to be displayed in a column
     * @param gridy Y-coordinate
     */
    public void addColumn(int gridy) {
        // Label
        JLabel lbCol = new JLabel("Enter the number of tiles " +
            "to be displayed in a column:", JLabel.RIGHT);
        col1.gridx = 0;
        col1.gridy = gridy;
        add(lbCol, col1);
        // Field
        tfCol = new JTextField(7);
        col2.gridx = 1;
        col2.gridy = gridy;
        add(tfCol, col2);
    }

    /**
     * Add a label and a field for the user to enter the amount 
     * of space to be displayed between tiles in a row
     * @param gridy Y-coordinate
     */
    public void addHorizontalGap(int gridy) {
        // Label
        JLabel lbHorGap = new JLabel("Enter the amount of space " +
            "to be displayed between rows:", JLabel.RIGHT);
        col1.gridx = 0;
        col1.gridy = gridy;
        add(lbHorGap, col1);
        // Field
        tfHorGap = new JTextField(7);
        tfHorGap.setText("10");
        col2.gridx = 1;
        col2.gridy = gridy;
        add(tfHorGap, col2);
    }

    /**
     * Add a label and a field for the user to enter the amount
     * of space to be displayed between tiles in a column
     * @param gridy Y-coordinate
     */
    public void addVerticalGap(int gridy) {
        // Label
        JLabel lbVerGap = new JLabel("Enter the amount of space " +
            "to be displayed between columns:", JLabel.RIGHT);
        col1.gridx = 0;
        col1.gridy = gridy;
        add(lbVerGap, col1);
        // Field
        tfVerGap = new JTextField(7);
        tfVerGap.setText("10");
        col2.gridx = 1;
        col2.gridy = gridy;
        add(tfVerGap, col2);
    }

    /**
     * Add a button for the user to start the game
     * @param gridy Y-coordinate
     */
    public void addStartGameButton(int gridy) {
        JButton bStart = new JButton("Start Game");
        bStart.addActionListener(e -> startGame());
        col2.gridx = 1;
        col2.gridy = gridy;
        add(bStart, col2);
    }

    /**
     * Actions performed when user clicks on "Start Game" button
     */
    public void startGame() {
        try {
            // Transfer data from fields to class DataTransferObject
            dto.setRow(Integer.parseInt(tfRow.getText()));
            dto.setCol(Integer.parseInt(tfCol.getText()));
            dto.setHorGap(Integer.parseInt(tfHorGap.getText()));
            dto.setVerGap(Integer.parseInt(tfVerGap.getText()));
            // If user entered a whole number between 3 and 10 for the first two fields
            if (dto.getRow() >= 3 && dto.getRow() <= 10 && dto.getCol() >= 3 && dto.getCol() <= 10) {
                // Show game panel
                controller.showCard("Game Panel");
                // Enable reset button
                controller.enableResetButton();
                // Enable settings button
                controller.enableSettingsButton();
                // Start game
                controller.startGame();
            } else {
                // Display error message
                JOptionPane.showMessageDialog(this, "Please choose a number between 3 and 10"
                    + " for the first two fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        // If user did not enter a whole number for any of the fields
        } catch (NumberFormatException e) {
            // Display error message
            JOptionPane.showMessageDialog(this, 
                "Please enter a whole number for each field.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
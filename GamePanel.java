// Import classes
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Game Panel
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class GamePanel extends JPanel {

    /**
     * An object of class Controller
     */
    private Controller controller;

    /**
     * An object of class DataTransferObject
     */
    private DataTransferObject dto;

    /**
     * The total number of tiles
     */
    private int numOfTiles;

    /**
     * Tiles
     */
    private Tile[] tiles;

    /**
    * Constructor 
    * @param controller An object of class Controller
    * @param dto An object of class DataTransferObject
    */
    public GamePanel(Controller controller, DataTransferObject dto) {
        this.controller = controller;
        this.dto = dto;
    }

    /**
     * Start the game
     */
    public void startGame() {
        // Remove all components from game panel
        removeAll();
        // Create a new grid layout
        setLayout(new GridLayout(dto.getRow(), dto.getCol(),
            dto.getHorGap(), dto.getVerGap()));
        // An object of class Random
        Random random = new Random();
        // Total number of tiles
        numOfTiles = dto.getRow() * dto.getCol();
        System.out.println("numOfTiles = " + numOfTiles);
        // Array of tiles
        tiles = new Tile[numOfTiles + 1];
        // Array to keep track of which tiles have not been numbered
        boolean[] isNumbered = new boolean[numOfTiles + 1];
        // Loop tiles
        for (int x = 1; x <= numOfTiles; x++) {
            while (true) {
                // Select random number from 1 to (n + 1)
                int a = random.nextInt(1, numOfTiles + 1);
                // If random number has not been selected before
                if (isNumbered[a] == false) {
                    // Number is now used
                    isNumbered[a] = true;
                    // Initialize tile
                    tiles[x] = new Tile(this);
                    // Set tile number
                    tiles[x].setNum(String.format("%s", a));
                    // Set tile index
                    tiles[x].setIndex(x);
                    // Set last tile to invisible
                    if (a == numOfTiles) {
                        System.out.println("a = " + a + " should be invisible, x = " + x);
                        tiles[x].setVisible(false);
                    }
                    // Add tile to board
                    add(tiles[x]);
                    // Exit
                    break;
                }
            }
        }
        repaint();
        revalidate();
    }

    /**
     * Move selected tile to adjacent empty space
     * @param index Index of selected tile
     */
    public void moveTile(int index) {
        // Move up
        if (index - dto.getCol() >= 1 && !tiles[index - dto.getCol()].isVisible()) {
            switchTiles(index, index - dto.getCol());
        }
        // Move right
        else if (index % dto.getCol() > 0 && !tiles[index + 1].isVisible()) {
            switchTiles(index, index + 1);
        }
        // Move down
        else if (index + dto.getCol() <= numOfTiles && !tiles[index + dto.getCol()].isVisible()) {
            switchTiles(index, index + dto.getCol());
        }
        // Move left
        else if (index % dto.getCol() != 1 && !tiles[index - 1].isVisible()) {
            switchTiles(index, index - 1);
        }
        // Check if user won the game
        isWinner();
    }

    /**
     * Swap selected tile with invisible tile
     * @param a Index of selected tile
     * @param b Index of invisible tile
     */
    private void switchTiles(int a, int b) {
        controller.incrementMoves();
        // Switch visibility
        tiles[a].setVisible(false);
        tiles[b].setVisible(true);
        // Switch numbers
        String temp = tiles[a].getNum();
        tiles[a].setNum(tiles[b].getNum());
        tiles[b].setNum(temp);
    }

    /**
     * Check if user won the game
     */
    private void isWinner() {
        // Set count to 1
        int count = 1;
        // Loop through all tiles
        for (Tile x : tiles) {
            // If tile number equals count
            if (x != null && Integer.parseInt(x.getNum()) == count) {
                // Increment count
                count++;
            } else {
                // Exit loop
                break;
            }
            // If user won the game
            if (count == numOfTiles) {
                // Display victory message
                // and ask user if they would like to play again
                int option = JOptionPane.showConfirmDialog(this, 
                    "You won the game!\nWould you like to play again?", 
                    "Victory", JOptionPane.YES_NO_OPTION);
                // If user chooses to play again
                if (option == JOptionPane.YES_OPTION) {
                    // Switch to Game Panel
                    controller.showCard("Settings Panel");
                    controller.disableResetButton();
                } else {
                    // Exit the game
                    System.exit(0);
                }
            }
        }
    }
}
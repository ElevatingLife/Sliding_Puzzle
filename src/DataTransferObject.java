/**
 * Data Transfer Object
 * @author Ali Al-Hariri
 * @version September 6, 2023
 */
public class DataTransferObject {
 
    /**
     * The number of tiles in a row
     */
    private int row;
    
    /**
     * The number of tiles in a column
     */
    private int col;
    
    /**
     * The amount of space (in pixels) between rows
     */
    private int hgap;
    
    /**
     * The amount of space (in pixels) between columns
     */
    private int vgap;

    /**
     * Set the number of tiles in a row
     * @param row Number of tiles in a row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Get the number of tiles in a row
     * @return Number of tiles in a row
     */
    public int getRow() {
        return row;
    }

    /**
     * Set the number of tiles in a column
     * @param col Number of tiles in a column
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Get the number of tiles in a column
     * @return Number of tiles in a column
     */
    public int getCol() {
        return col;
    }

    /**
     * Set the amount of space (in pixels)
     * between rows
     * @param hgap Amount of space (in pixels)
     * between rows
     */
    public void setHorGap(int hgap) {
        this.hgap = hgap;
    }

    /**
     * Get the amount of space (in pixels)
     * between rows
     * @return Amount of space (in pixels)
     * between rows
     */
    public int getHorGap() {
        return hgap;
    }

    /**
     * Set the amount of space (in pixels)
     * between columns
     * @param vgap Amount of dpace (in pixels)
     * between columns
     */
    public void setVerGap(int vgap) {
        this.vgap = vgap;
    }

    /**
     * Get the amount of space (in pixels)
     * between columns
     * @return Amount of space (in pixels)
     * between columns
     */
    public int getVerGap() {
        return vgap;
    }
}
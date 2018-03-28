package application.model;

/**
 *
 */
public abstract class Tile{
    /**
     * The coordinates for a tile
     */
    int xPos, yPos;
    //methods
    //getters
    /**
     * Returns the x-coordinate
     * @return The x value of the tile
     */
    public int getXPos(){return xPos;}
    /**
     * Returns the y-coordinate
     * @return The y value of the tile
     */
    public int getYPos(){return yPos;}

    /**
     * Returns a string of the tile's position
     * @return String in the form of "(x, y)"
     */
    public String toString(){return "(" + xPos + ", " + yPos + ")";}
}

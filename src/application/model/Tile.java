package application.model;

/**
 *
 */
public abstract class Tile{
    //fields
    /**
     * The coordinates for a tile
     */
    Tuple coordinates;
    
    //methods
    //getters
    public Tuple getCoordinates() {return coordinates;}
    /**
     * Returns the x-coordinate
     * @return The x value of the tile
     */
    public int getXPos(){return coordinates.getX();}
    /**
     * Returns the y-coordinate
     * @return The y value of the tile
     */
    public int getYPos(){return coordinates.getY();}

    /**
     * Returns a string of the tile's position
     * @return String in the form of "(x, y)"
     */
    public String toString(){return coordinates.toString() + getClass();}
}

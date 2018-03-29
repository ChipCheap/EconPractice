package application.model;

/**
 * Represents a tile on the map that is considered land which can have a port built on it
 */
public class LandTile extends Tile{
    //fields
    /**
     * The flag for whether this tile is considered to be a port tile
     */
    private boolean isPort;

    //constructors
    /**
     * Creates a new land tile at the given location
     * @param x The x-coordinate of the tile
     * @param y The y-coordinate of the tile
     */
    public LandTile(int x, int y, boolean isPort){
        xPos = x;
        yPos = y;
        this.isPort = isPort;
    }

    public boolean isPort() {return isPort;}
}

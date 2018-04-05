package application.model;

/**
 * Represents a tile on the map filled with water for ships to sail.
 */
public class SeaTile extends Tile{
    //TODO maybe add a few extra features to slow down movement or add other special effects
    /**
     * Creates a new sea tile at the given location
     * @param x The x-coordinate of the tile
     * @param y The y-coordinate of the tile
     */
    public SeaTile(int x, int y){
        coordinates = new Tuple(x, y);
    }
}

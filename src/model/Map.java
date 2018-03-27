package model;

/**
 *
 */
public class Map {
    //fields
    /**
     *
     */
    private Tile[][] tiles;

    //constructors
    /**
     *
     */
    public Map(){
        tiles = new Tile[10][10];
    }

    //methods
    //getters
    public Tile[][] getTiles() {
        return tiles;
    }

    //setters
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
}

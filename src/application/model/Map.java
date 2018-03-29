package application.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a map with tiles and their corresponding contents
 */
public class Map {
    //fields
    /**
     * The tiles stored within the map
     */
    private Tile[][] tiles;
    /**
     * The size of the map
     */
    private int xSize, ySize;
    /**
     * The tiles with ports on them
     */
    private ArrayList<Tile> portTiles;

    //constructors
    /**
     * Creates a map with the given sizes
     * @param xSize The map width in number of tiles
     * @param ySize The map height in number of tiles
     */
    public Map(int xSize, int ySize){
        //TODO make variable setting, also, make width larger than height(new Tile[x][y], x < y)
        tiles = new Tile[ySize][xSize];
        this.ySize = ySize;
        this.xSize = xSize;
        portTiles = new ArrayList<>();
        generateMap();
    }

    //methods
    /**
     * Fills the map with tiles
     */
    public void generateMap(){
        //TODO make default and random later
        boolean portGenerated = false;
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[0].length; j++){
                //TODO remove port addition later
                tiles[i][j] = (j < 7 && j > 3 && i > 2 && i < 6 ? new LandTile(j, i, !portGenerated) :
                        new SeaTile(j, i));
                if(tiles[i][j] instanceof LandTile && !portGenerated) {
                    portTiles.add(tiles[i][j]);
                    portGenerated = true;
                }
            }
        }
    }

    //getters
    /**
     *
     * @return
     */
    public Tile[][] getTiles() {return tiles;}

    /**
     *
     * @return
     */
    public ArrayList<Tile> getPortTiles() {return portTiles;}

    /**
     *
     * @return
     */
    public int getxSize() {return xSize;}

    /**
     *
     * @return
     */
    public int getySize() {return ySize;}

    //setters
}

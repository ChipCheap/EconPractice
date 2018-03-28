package application.model;

import java.util.Arrays;

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
        tiles = new Tile[100][100];
        generateMap();
    }

    //methods
    public void generateMap(){
        //TODO make default and random later
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                tiles[i][j] = (j < 7 && j > 3 && i > 2 && i < 6 ? new LandTile(j, i) : new SeaTile(j, i));
            }
        }
    }
    //getters
    public Tile[][] getTiles() {
        return tiles;
    }

    //setters
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
}

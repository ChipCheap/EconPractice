package application.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

/**
 * Represents a map with tiles and their corresponding contents
 */
//TODO make some kind of interface for tiles[][] access
public class Map {
    //fields
    /**
     * The tiles stored within the map
     */
    private Tile[][] tiles;
    /**
     * The 4 cardinal directions in tuple form
     * coding: 0 = UP, 1 = RIGHT, 2 = DOWN, 3 = LEFT
     */
    private final static Tuple[] DIRECTIONS = new Tuple[]{
            new Tuple(0, -1), new Tuple(1, 0),
            new Tuple(0, 1), new Tuple(-1, 0)};
    /**
     * The tiles not allowed for landmass expansion in the map generation
     */
    private boolean[][] takenLandSpots;
    /**
     * The size of the map
     */
    private int xSize, ySize;
    /**
     * The tiles with ports on them
     */
    private ArrayList<Tile> portTiles;
    /**
     * Global random number generator
     */
    private Random random = new Random();

    //constructors
    /**
     * Creates a map with the given sizes
     * @param xSize The map width in number of tiles
     * @param ySize The map height in number of tiles
     */
    public Map(int xSize, int ySize){
        //TODO make variable setting, also, make width larger than height(new Tile[x][y], x < y)
        this.xSize = xSize;
        this.ySize = ySize;
        createTiles(xSize, ySize);
        portTiles = new ArrayList<>();
        generateRandomMap(2);
    }

    //methods
    /**
     * Fills the map with tiles
     */
    private void generateMap(){
        //TODO make default and random later
        boolean portGenerated = false;
        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                //TODO remove port addition later
                Tile tile = (j < 7 && j > 3 && i > 2 && i < 6 ? new LandTile(j, i, !portGenerated) :
                        new SeaTile(j, i));
                setTile(j, i, tile);
                if(tiles[i][j] instanceof LandTile && !portGenerated){
                    portTiles.add(tiles[i][j]);
                    portGenerated = true;
                }
            }
        }
    }

    /**
     * Generates the map with the given number of islands and ports
     * @param numIslands The number of islands to be generated
     */
    private void generateRandomMap(int numIslands){
        int xCenter, yCenter;
        for(int i = 0; i < numIslands; i++) {
            xCenter = random.nextInt(xSize - 4) + 2;
            yCenter = random.nextInt(ySize - 4) + 2;
            if(getTakenLand(xCenter, yCenter)){
                i--;
                continue;
            }
            addLandTile(xCenter, yCenter, true);
            portTiles.add(getTile(xCenter, yCenter));
            expandLandmassFromPort(new Tuple(xCenter, yCenter));
            updateTakenLand();
        }

        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                if(getTile(j, i) == null){
                    setTile(j, i, new SeaTile(wrapCoordinates(j), i));
                }
            }
        }
    }

    //helper functions
    /**
     * For map generation; expands the land around a port after a few rules, which are:
     * Land may not be in range 2 of any land of another port, 3 tiles adjacent to a port will always be land,
     * land will be randomly generated in all 4 directions of land tile
     * the further away a tile is from the port, the lower the percentage becomes (Exponentially)
     * @param portCenter The tuple of the center of the port
     */
    private void expandLandmassFromPort(Tuple portCenter){
        boolean directionIncreased = false;
        int direction = random.nextInt(DIRECTIONS.length);
        Tuple landTileToAdd = portCenter.addTuple(DIRECTIONS[direction]);
        //addLandTile(landTileToAdd, false);
        expandLandmassFromTile(portCenter, landTileToAdd, 1);
        if(challengeRNG(2)){
            direction++;
            direction = direction % DIRECTIONS.length;
            directionIncreased = true;
        }
        else{
            direction--;
            if(direction < 0) {
                direction += DIRECTIONS.length;
            }
        }
        landTileToAdd = portCenter.addTuple(DIRECTIONS[direction]);
        //addLandTile(landTileToAdd, false);
        expandLandmassFromTile(portCenter, landTileToAdd, 1);
        if(challengeRNG(2)){
            if(challengeRNG(2)){
                direction++;
                direction++;
                direction = direction % DIRECTIONS.length;
            }
            else{
                if(directionIncreased){
                    direction++;
                    direction = direction % DIRECTIONS.length;
                }
                else direction--;
                if(direction < 0) {
                    direction += DIRECTIONS.length;
                }
            }
            landTileToAdd = portCenter.addTuple(DIRECTIONS[direction]);
            //addLandTile(landTileToAdd, false);
            expandLandmassFromTile(portCenter, landTileToAdd, 1);
        }

    }

    /**
     * Creates new land tiles around already existing ones next to a port to create bigger, randomized, islands;
     * Only used in map generation
     * @param portLocation The starting location of the landmass marked by the port
     * @param location The location of the land tile to expand from; initially the tiles next to a port
     * @param distance The distance to the port of the island
     */
    //TODO add passed function for RNG manipulation to make for example continents of larger sizes than islands
        //TODO To do so, make new class with about 4 or 5 different functions (small to large islands) for variability
    private void expandLandmassFromTile(Tuple portLocation, Tuple location, int distance){
        if(getTile(location) == null && !getTakenLand(location)){
            addLandTile(location, false);

            for(Tuple direction : DIRECTIONS){
                if(Tuple.calculateDistance(portLocation, location.addTuple(direction)) > distance){
                    //TODO find better function for percent reduction, some hyperbolic function prolly
                    if(challengeRNG(100. - distance * 10)){
                        expandLandmassFromTile(portLocation, location.addTuple(direction), distance + 1);
                    }
                }
            }
        }
    }

    /**
     * Updates the takenLand matrix so that all tiles within range of 2 of other land will be considered taken
     */
    private void updateTakenLand(){
        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                if(getTile(j, i) instanceof LandTile){
                    setTakenLand(j, i);
                    for(Tuple direction1 : DIRECTIONS){
                        setTakenLand(j + direction1.getX(), i + direction1.getY());
                        for(Tuple direction2 : DIRECTIONS){
                            setTakenLand(j + direction1.getX() + direction2.getX(),
                                    i + direction1.getY() + direction2.getY());
                        }
                    }
                }
            }
        }
    }

    /**
     * Generates a boolean with a given percent chance of being true
     * @param percentChance The chance of returning true in percent
     * @return True in case the rng generates a number lower or equal to the percent chance given
     */
    private boolean challengeRNG(double percentChance){return random.nextDouble() * 100 <= percentChance;}

    /**
     * Uses the other RNG method with the percent chance of 1 / given divisor
     * @param divisor The divisor for the chance
     * @return True in case the other rng function is true
     */
    private boolean challengeRNG(int divisor){return challengeRNG((1D / divisor) * 100);}

    /**
     * Wraps the x-coordinate around if needed
     * @param x The x-coordinate to be wrapped
     * @return xSize - |x| if x is negative, else just x, which completes the wrap around
     */
    public int wrapCoordinates(int x){
        int xTemp = x;
        while(xTemp < 0){
            xTemp += xSize;
        }
        return xTemp % xSize;
    }

    /**
     * Adds a LandTile, including ports, to the given tuple's coordinates;
     * Used only for map generation for easy use
     * @param location The location of the new LandTile
     * @param isPort Whether the tile is a port
     */
    private void addLandTile(Tuple location, boolean isPort){
        setTile(location.getX(), location.getY(),
                new LandTile(wrapCoordinates(location.getX()), location.getY(), isPort));
    }

    /**
     * Works the same as the other {@link #addLandTile(Tuple, boolean)} function, but uses raw coordinates
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param isPort Whether the tile is a port
     */
    private void addLandTile(int x, int y, boolean isPort){
        setTile(x, y, new LandTile(wrapCoordinates(x), y, isPort));
    }

    /**
     * Interface method like the other Tile methods for uniformity;
     * Initializes the matrices needed for map storage and generation with the given sizes
     * @param xSize The width of the map in tiles
     * @param ySize The height of the map in tiles
     */
    private void createTiles(int xSize, int ySize){
        tiles = new Tile[ySize][xSize];
        takenLandSpots = new boolean[ySize][xSize];
        for(int i = 0; i < xSize; i++){
            setTakenLand(i, 0);
            setTakenLand(i, ySize - 1);
        }
    }

    /**
     * Same as {@link #getTile(int, int)}, just for map generation for the taken land matrix
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @return The boolean at the given coordinates
     */
    private boolean getTakenLand(int x, int y){
        if(y < 0 || y >= ySize){
            return true;
        }
        return takenLandSpots[y][x];
    }

    /**
     * Same as {@link #getTile(Tuple)}, just for map generation for the taken land matrix
     * @param coordinates The tuple containing the coordinates
     * @return The boolean at the given coordinates
     */
    private boolean getTakenLand(Tuple coordinates){
        if (coordinates.getY() < 0 || coordinates.getY() >= ySize){
            return true;
        }
        return takenLandSpots[coordinates.getY()][wrapCoordinates(coordinates.getX())];
    }

    /**
     * Retrieves the tile with the given coordinates with map wrap-around
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @return The tile with the given coordinates
     */
    public Tile getTile(int x, int y){
        if(y < 0 || y >= ySize){
            return null;
        }
        return tiles[y][wrapCoordinates(x)];
    }

    /**
     * Retrieves the tile with the coordinates of the given tuple with map wrap-around
     * @param coordinates The tuple with its coordinates
     * @return The tile with the coordinates of the tuple
     */
    public Tile getTile(Tuple coordinates){
        if (coordinates.getY() < 0 || coordinates.getY() >= ySize){
            return null;
        }
        return tiles[coordinates.getY()][wrapCoordinates(coordinates.getX())];
    }

    /**
     * Interface method for use of takenLandSpots array in the map generation;
     * Sets the slot at x, y to true
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    private void setTakenLand(int x, int y){
        if(y < 0 || y >= ySize){
            return;
        }
        takenLandSpots[y][wrapCoordinates(x)] = true;
    }

    /**
     * Same as the other {@link #setTakenLand(int, int)}, just with a tuple
     * @param coordinates The tuple with the coordinates
     */
    private void setTakenLand(Tuple coordinates){
        if(coordinates.getY() < 0 || coordinates.getY() >= ySize){
            return;
        }
        takenLandSpots[coordinates.getY()][wrapCoordinates(coordinates.getX())] = true;
    }

    /**
     * Interface method for working with the tiles array of the map;
     * Sets tiles[y][x] to the given tile
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param tile The tile to set the slot of x, y to
     */
    public void setTile(int x, int y, Tile tile){
        if(y < 0 || y >= ySize){
            return;
        }
        tiles[y][wrapCoordinates(x)] = tile;
    }

    /**
     * Extracts the coordinates of a tuple and then uses the other {@link #setTile(int, int, Tile)} method
     * @param coordinates The tuple containing the coordinates
     * @param tile The tile to set the slot of x, y to
     */
    public void setTile(Tuple coordinates, Tile tile){
        if(coordinates.getY() < 0 || coordinates.getY() >= ySize){
            return;
        }
        tiles[coordinates.getY()][wrapCoordinates(coordinates.getX())] = tile;
    }

    //getters
    /**
     * Returns the map with the tiles
     * @return The map with all filled tiles
     */
    public Tile[][] getTiles() {return tiles;}

    /**
     * Returns all tiles considered to be a port
     * @return The ports generated on the map
     */
    public ArrayList<Tile> getPortTiles() {return portTiles;}

    /**
     * Returns the width of the map in tiles
     * @return The width of the map
     */
    public int getXSize() {return xSize;}

    /**
     * Returns the height of the map in tiles
     * @return The height of the map
     */
    public int getYSize() {return ySize;}

    //setters
}

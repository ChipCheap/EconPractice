package application.model;

import java.util.ArrayList;

/**
 * Represents the entire game and controls its flow.
 */
public class Game {
    //fields
    /**
     * The player playing the game.
     */
    private Player player;
    /**
     * The world map
     */
    private Map map;
    /**
     * The list of all existing ports.
     */
    private ArrayList<Port> ports;


    //constructors
    /**
     *
     */
    public Game(){
        player = new Player(1000);
        map = new Map(30, 20);
        ports = new ArrayList<>();
        addPorts();
        player.addShip(new Ship(ports.get(0).getLocation()));
    }

    //methods
    /**
     * Creates port instances on all port tiles
     */
    private void addPorts(){
        for(Tile tile : map.getPortTiles()){
            if(tile instanceof LandTile && ((LandTile) tile).isPort()) {
                ports.add(new Port((LandTile) tile));
            }
        }
    }

    /**
     *
     * @param frame
     */
    public void updateGame(int frame){
        moveShips(frame);
        //TODO update everything here
    }

    /**
     * Updates all ships of the player
     * @param frame The current frame decides whether a ship moves or not
     */
    private void moveShips(int frame){
        for(Ship ship : player.getShips()){
            if(frame % ship.getFramesPerTileSpeed() == 0){
                //TODO implement pathfinder
                //ship.move(new SeaTile(1,1));
            }
        }
    }

    /**
     * Updates all ports of the game by applying the production and also updating the prices
     * @param frame The current frame
     */
    private void updatePorts(int frame){
        //TODO
    }

    //getters
    /**
     * Returns the player instance
     * @return The player controlled by the user
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the map instance
     * @return The map containing all the Tiles
     */
    public Map getMap() {
        return map;
    }

    /**
     * Returns the list of all ports
     * @return list of all ports for easy access
     */
    public ArrayList<Port> getPorts() {
        return ports;
    }

    //setters
    /**
     * Sets the ports instance
     * @param ports The ports in the game
     */
    public void setPorts(ArrayList<Port> ports) {
        this.ports = ports;
    }

    /**
     * Sets the map instance
     * @param map The map to which the game's map is to be set to
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Sets the player instance
     * @param player The player to which the instance is to be set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}

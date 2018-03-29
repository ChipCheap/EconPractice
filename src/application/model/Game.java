package application.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

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
        player = new Player();
        map = new Map();
        ports = new ArrayList<>();
    }

    //methods
    /**
     *
     */
    public void updateGame(){
        //TODO update everything here
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

package application.model;

import java.util.ArrayList;

/**
 * Represents a ship for trading goods from one location to another one
 */
public class Ship {
    //fields
    /**
     * The location of da ship.
     */
    private Tile location;
    /**
     * The destination tile of da ship.
     */
    private Tile destination;
    /**
     * The cargo of the da ship.
     */
    private ArrayList<Ware> cargo;
    /**
     * Describes the frame on which the ship moves on.
     */
    private int framesPerTileSpeed = 30;
    //TODO order list to queue up orders, later also repeat orders

    //constructors
    /**
     * Creation of mentioned above.
     * @param port The port at which the ship is created
     */
    public Ship(LandTile port){
        location = port;
        cargo = new ArrayList<>();
    }

    //methods
    /**
     * Moves the ship to the given location
     * @param newLocation The location this ship is to be moved to
     */
    public void move(Tile newLocation){
        location = newLocation;
        //TODO update destination and order list
    }

    //getters
    /**
     * Returns the number of frames needed for the ship to move, alas the speed.
     * @return The speed in frames/tile.
     */
    public int getFramesPerTileSpeed() {return framesPerTileSpeed;}

    /**
     * Returns the current location of this ship
     * @return The tile on which the ship currently is on
     */
    public Tile getLocation(){return location;}

    //setters

}

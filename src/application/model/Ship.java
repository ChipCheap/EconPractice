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
     * The cargo of the da ship.
     */
    private ArrayList<Ware> cargo;

    //constructors
    /**
     * Creation of mentioned above.
     * @param port The port at which the ship is created
     */
    public Ship(LandTile port){
        location = port;
        cargo = new ArrayList<>();
    }
}

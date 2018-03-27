package model;

import java.util.ArrayList;

/**
 * Represents a Port at which a player can trade goods.
 */
public class Port {
    /**
     * Tile, which the port is located on.
     */
    private LandTile location;
    /**
     * A list of wares, that are sold at the Port.
     */
    private ArrayList<Ware> wares;
    /**
     * A list of the prices for their representative wares.
     */
    private ArrayList<Integer> priceList;
    /**
     * The production of a port in the time-span.
     */
    private ArrayList<Integer> production;
    /**
     * The need of certain wares.
     */
    private ArrayList<Integer> needList;

    public Port(LandTile location){

        this.location = location;
        wares = new ArrayList<>();
        priceList = new ArrayList<> ();
        production = new ArrayList<>();
        needList = new ArrayList<>();
    }

}

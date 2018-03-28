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
    private  Ware[] wares;
    /**
     * A list of the prices for their representative wares.
     */
    private ArrayList<Integer> priceList;
    /**
     * The production of a port in the time-span.
     */
    private int[] production;
    /**
     * The need of certain wares.
     */
    private ArrayList<Integer> needList;

    /**
     * Creation of mentioned above.
     * @param location
     */
    public Port(LandTile location){

        this.location = location;
        wares = new Ware[WareType.values().length];
        priceList = new ArrayList<> ();
        production = new int[WareType.values().length];
        needList = new ArrayList<>();
    }
    /**
     * Adds a certain number of wares to a port depending on the production.
     */
    public void produce(){
        for(int i = 0; i<wares.length;i++){
            wares[i].setAmount(wares[i].getAmount() + production[i]);
        }
    }

}

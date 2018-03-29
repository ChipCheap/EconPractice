package application.model;

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
    private int[] priceList;
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
     * @param location The location at which the port is located.
     */
    public Port(LandTile location){
        this.location = location;
        wares = new Ware[WareType.values().length];
        priceList = Constants.BUY_PRICES.clone();
        production = new int[WareType.values().length];
        needList = new ArrayList<>();
    }


    /**
     * Adds a certain number of wares to a port depending on the production.
     */
    public void produce(){
        for(int i = 0; i < wares.length; i++){
            wares[i].setAmount(wares[i].getAmount() + production[i]);
        }
    }

    //getters
    /**
     * Returns the location of the port
     * @return The land tile on which the port is built upon
     */
    public LandTile getLocation() {return location;}
}

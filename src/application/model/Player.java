package application.model;

import java.util.ArrayList;

/**
 * Represents the player controlling the ships.
 */
public class Player {
    //fields
    /**
     * The amount of money the player has.
     */
    private int money;
    /**
     * The ships the player owns.
     */
    private ArrayList<Ship> ships;

    //constructors
    /**
     * Creates a player instance with the given amount of starting money.
     * @param startingMoney The amount of money the player begins with
     */
    public Player(int startingMoney){
        money = startingMoney;
        ships = new ArrayList<>();

    }

    //methods
    /**
     *
     */
    public void tradeGoods(){

    }

    /**
     * Adds a ship to the list of ships the player controls
     * @param ship The ship to be added
     */
    //TODO maybe make this buyShip and pass the ship type with its given cost stored in the ship instance?
    public void addShip(Ship ship){
        ships.add(ship);
    }

    //getters
    /**
     * Returns the list of ships of the player
     * @return
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

    //setters
    /**
     *
     * @param ships
     */
    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }
}

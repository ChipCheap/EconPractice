package model;

import java.util.ArrayList;

public class Ship {
    /**
     * The location of da ship.
     */
    private Tile location;
    /**
     * The cargo of the da ship.
     */
    private ArrayList<Ware> cargo;

    public Ship(){
        location = new Tile();
        cargo = new ArrayList<>();
    }
}

package application.view;

import application.model.Ship;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 */
public class ShipImageView extends ImageView {
    //fields
    /**
     *
     */
    private Ship ship;

    //constructors
    /**
     *
     * @param ship
     * @param shipImage
     * @param size
     */
    public ShipImageView(Ship ship, Image shipImage, int size){
        super(shipImage);
        this.ship = ship;
        setPreserveRatio(true);
        setFitHeight(size);
    }

    //methods
    //getters
    public Ship getShip(){return ship;}
    //setters
}

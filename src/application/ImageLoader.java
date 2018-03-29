package application;

import javafx.scene.image.Image;

/**
 * Loads and stores all images ever to be loaded for public access
 */
public class ImageLoader {
    /**
     * The tile images
     */
    public static Image
            seaTileImage = new Image(Main.class.getClassLoader().getResourceAsStream("res/seaTile.png")),
            landTileImage = new Image(Main.class.getClassLoader().getResourceAsStream("res/landTile.png")),
            portTileImage = new Image(Main.class.getClassLoader().getResourceAsStream("res/portTile.png"));
    /**
     * The ship images
     */
    public static Image
            shipImage = new Image(Main.class.getClassLoader().getResourceAsStream("res/ship.png"));
}

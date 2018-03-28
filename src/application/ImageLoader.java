package application;

import javafx.scene.image.Image;

/**
 * Loads and stores all images ever to be loaded for public access
 */
public class ImageLoader {
    public static Image
            seaTile = new Image(Main.class.getClassLoader().getResourceAsStream("res/seaTile.png")),
            landTile = new Image(Main.class.getClassLoader().getResourceAsStream("res/landTile.png")),
            portTile = new Image(Main.class.getClassLoader().getResourceAsStream("res/portTile.png"));
}

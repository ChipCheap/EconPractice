package application.view;

import application.model.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 */
public class TileImageView extends ImageView {
    /**
     *
     */
    private Tile tile;

    /**
     *
     * @param tile
     * @param tileImage
     * @param size
     */
    public TileImageView(Tile tile, Image tileImage, int size){
        super(tileImage);
        this.tile = tile;
        setPreserveRatio(true);
        setFitHeight(size);
    }
}

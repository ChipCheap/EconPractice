package application.view;

import application.ImageLoader;
import application.controller.GameController;
import application.model.SeaTile;
import application.model.Tile;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Shows the in-game view.
 */
public class GameView{
    //fields
    /**
     * The controller unit for this view.
     */
    private GameController gameController;
    /**
     * The Pane containing all grid squares with the corresponding tiles
     */
    private GridPane mapPane;
    /**
     * The Stage the view is shown in
     */
    private Stage mainStage;
    /**
     * The Scene of the game
     */
    private Scene mainScene;

    //constructors
    /**
     * Creates the entire view
     */
    public GameView(GameController gc){
        gameController = gc;
        mainStage = gameController.getGameStage();
        mapPane = new GridPane();
        initMap();
        mainScene = new Scene(mapPane);
        mainStage.setScene(mainScene);
    }

    //methods
    /**
     * Reads the map and fills the spots in the grid with the corresponding tile images
     */
    private void initMap(){
        for(Tile[] tileArray : gameController.getGame().getMap().getTiles()){
            for(Tile tile : tileArray){
                mapPane.add(
                        new ImageView(tile instanceof SeaTile ? ImageLoader.seaTile : ImageLoader.landTile),
                        tile.getXPos(), tile.getYPos());
            }
        }
    }
}

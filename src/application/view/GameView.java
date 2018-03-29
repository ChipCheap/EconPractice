package application.view;

import application.ImageLoader;
import application.controller.GameController;
import application.model.SeaTile;
import application.model.Tile;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        mainStage.setResizable(true);
        //TODO make this variable somewhere and also set it to some variable for re-use
        mainStage.setMaxWidth(1600);
        mainStage.setMaxHeight(900);
    }

    //methods
    /**
     * Reads the map and fills the spots in the grid with the corresponding tile images
     */
    private void initMap(){
        Tile[][] tileMap = gameController.getGame().getMap().getTiles();
        for(Tile[] tileArray : tileMap){
            for(Tile tile : tileArray){
                ImageView imageView =
                        new ImageView(tile instanceof SeaTile ? ImageLoader.seaTile : ImageLoader.landTile);
                imageView.setPreserveRatio(true);
                imageView.setFitHeight((Math.min(1280, 720) - 100)/tileArray.length);
                mapPane.add(imageView, tile.getXPos(), tile.getYPos());
            }
        }
    }

    /**
     * example use for JavaFX elements
     */
    private void jfxExample(){
        HBox hBox = new HBox(); //container parent node;
        // note: could also be used as a child node and therefore added to another parent
        Button button = new Button("Test"); //child node
        hBox.getChildren().add(button); //parent adds child to its children list (getChildren(). )
    }

    /**
     * Updates all view elements according to the re-newed model information
     */
    public void update(){
       //TODO update all view elements here
    }
}

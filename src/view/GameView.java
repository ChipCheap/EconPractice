package view;

import controller.GameController;
import javafx.scene.layout.GridPane;
import model.Tile;

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

    //constructors
    /**
     *
     */
    public GameView(GameController gc){
        gameController = gc;
        mapPane = new GridPane();
    }

    //methods
    /**
     *
     */
    private void initMap(){
        for(int i = 0; i < gameController.getGame().getMap().getTiles().length;)
        for(Tile[] tileArray : gameController.getGame().getMap().getTiles()){
            for(Tile tile : tileArray){
                ;
            }
        }
    }
}

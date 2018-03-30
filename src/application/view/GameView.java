package application.view;

import application.ImageLoader;
import application.controller.GameController;
import application.model.LandTile;
import application.model.Ship;
import application.model.Tile;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

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
    /**
     *
     */
    private ArrayList<ShipImageView> shipImageViews = new ArrayList<>();

    //constructors
    /**
     * Creates the entire view
     */
    public GameView(GameController gc){
        gameController = gc;
        mainStage = gameController.getGameStage();
        mapPane = new GridPane();
        initMap();
        initShips();
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
                        new ImageView(tile instanceof LandTile ?
                                (((LandTile) tile).isPort() ?
                                        ImageLoader.portTileImage : ImageLoader.landTileImage) :
                                ImageLoader.seaTileImage);
                imageView.setPreserveRatio(true);

                //TODO fix the screen height
                imageView.setFitHeight((Math.min(1280, 720) - 100) / gameController.getGame().getMap().getYSize());
                mapPane.add(imageView, tile.getXPos(), tile.getYPos());
                imageView.setOnMouseClicked(e -> {
                    if(imageView.getImage().equals(ImageLoader.portTileImage)){
                        new PortWindow();
                    }
                    gameController.getGame().getPlayer().getShips().get(0).move(tile);
                    System.out.println(tile);
                });
            }
        }
    }

    /**
     * Initiates the ships in the view
     */
    private void initShips(){
        for(Ship ship : gameController.getGame().getPlayer().getShips()){
            ShipImageView imgV = new ShipImageView(ship, ImageLoader.shipImage,
                    (Math.min(1280, 720) - 100) / gameController.getGame().getMap().getYSize()); //TODO export size
            shipImageViews.add(imgV);
            mapPane.add(imgV, ship.getLocation().getXPos(), ship.getLocation().getYPos());
            /*
            ImageView imageView = new ImageView(ImageLoader.shipImage);
            mapPane.add(imageView,
                    ship.getLocation().getXPos(), ship.getLocation().getYPos());
            imageView.setPreserveRatio(true);
            //TODO fix copy pasta and height
            imageView.setFitHeight((Math.min(1280, 720) - 100)/gameController.getGame().getMap().getYSize());*/
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
     * TODO prolly remove this, since it is in initMap now
     */
    private void initPorts(){

    }

    /**
     * Updates all view elements according to the re-newed model information
     */
    public void update(){
        initShips();
        updateShips();
       //TODO update all view elements here
    }

    /**
     * Removes all ships from the view and re-adds them with their updated location
     */
    private void updateShips(){
        for(ShipImageView shipImgVw : shipImageViews){
            mapPane.getChildren().remove(shipImgVw);
            mapPane.add(shipImgVw, shipImgVw.getShip().getLocation().getXPos(),
                    shipImgVw.getShip().getLocation().getYPos());
        }
    }
}

package application.controller;

import application.model.Game;
import application.view.GameView;
import javafx.stage.Stage;

/**
 * The controller unit for the running game
 */
public class GameController {
    //fields
    /**
     * The game instance to be managed
     */
    private Game game;
    /**
     * The view for the game
     */
    private GameView gameView;
    /**
     * The stage for the game
     */
    private Stage gameStage;

    //constructors
    /**
     * Creates a new controller and the corresponding view to it
     */
    public GameController(Stage primaryStage){
        gameStage = primaryStage;
        game = new Game();
        gameView = new GameView(this);
    }

    //methods

    //getters
    /**
     * Returns the instance of the running game
     * @return The game instance
     */
    public Game getGame() {
        return game;
    }

    /**
     * Returns the instance of the stage
     * @return
     */
    public Stage getGameStage() {
        return gameStage;
    }

    //setters

    /**
     * Sets the game instance of the controller
     * @param game The game instance
     */
    public void setGame(Game game) {
        this.game = game;
    }
}

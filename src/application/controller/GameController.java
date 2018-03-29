package application.controller;

import application.model.Game;
import application.view.GameView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    /**
     *
     */
    private int frameCounter;

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
    private void updateAll(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000/60), e -> {
            frameCounter++;
            frameCounter = frameCounter % 60;
            game.updateGame();
            gameView.update();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

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

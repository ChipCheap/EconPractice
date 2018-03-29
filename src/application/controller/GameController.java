package application.controller;

import application.model.Game;
import application.view.GameView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

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
     * The current frame the game is on
     */
    private int frameCounter;
    //testing
    private Random r = new Random();

    //constructors
    /**
     * Creates a new controller and the corresponding view to it
     */
    public GameController(Stage primaryStage){
        gameStage = primaryStage;
        game = new Game();
        gameView = new GameView(this);
        startTimeline();
    }

    //methods
    /**
     * Initiates the timeline which updates the game data
     */
    private void startTimeline(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000/60), e -> updateAll()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Updates the entire game and view 60 times per second
     */
    private void updateAll(){
        frameCounter++;
        //if(frameCounter % 60 == 0)
            gameView.update();
        game.updateGame(frameCounter);
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
     * @return The instance of the stage
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

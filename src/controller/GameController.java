package controller;

import model.Game;

/**
 *
 */
public class GameController {
    //fields
    /**
     *
     */
    private Game game;

    //constructors
    /**
     *
     */
    public GameController(){

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

    //setters
    /**
     * Sets the game instance of the controller
     * @param game The game instance
     */
    public void setGame(Game game) {
        this.game = game;
    }
}

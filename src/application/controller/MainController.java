package application.controller;

import javafx.stage.Stage;

public class MainController {
    private GameController gameController;
    private Stage gameStage;
    public MainController(Stage primaryStage){
        gameStage = primaryStage;
        gameController = new GameController(primaryStage);
    }
}

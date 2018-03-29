package application;

import application.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Main entry point for the appliation
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage){
        new MainController(primaryStage);
        primaryStage.setTitle("High Seas");
        primaryStage.show();
    }
}

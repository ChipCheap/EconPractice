package application.view;

import application.model.Port;
import application.model.WareType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


public class PortSubWindow extends Stage{
    /**
     * Sets the instance of the PortSubWindow to null
     */
    private static PortSubWindow instance = null;
    /**
     * Port from the Port class to realize the port Window.
     */
    private Port port;
    /**
     * Constructor for the PortSubWindow.
     */
    private PortSubWindow(Port port){
        super();
        //TODO positioning, fill with scene, delete the weird window border and make it look like it is integrated LuL
        this.port = port;
        this.show();

    }
    /**
     * Getting the Instance.
     * @return Returning the Instance.
     */
    public static PortSubWindow getInstance(){
        return instance;
    }
    /**
     * Creating the Instance of the PortSubWindow.
     * @param port Port from the Port class to realize the PortSubWindow.
     */
    public static void createInstance(Port port){
        instance = new PortSubWindow(port);
    }
    /**
     * Change the Scene of the PortSubWindow, depending on the button pressed in the PortWindow
     * @param index Number of the Button pressed in the PortWindow.
     */
    public static void changeScene(int index){

        switch(index){
            case 0:


        }
    }
}

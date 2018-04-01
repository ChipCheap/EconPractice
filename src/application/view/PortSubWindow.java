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

    private static PortSubWindow instance = null;
    private Port port;

    /**
     * Constructor for PortSubWindow
     */
    private PortSubWindow(Port port){
        super();
        //TODO positioning, fill with scene, delete the weird window border and make it look like it is integrated LuL
        this.port = port;
        this.show();

    }
    public static PortSubWindow createPortSubWindow(Port port){
        if(instance == null){
            instance = new PortSubWindow(port);
        }
        return instance;
    }
    public static PortSubWindow getInstance(){
        return instance;
    }
    public static void createInstance(Port port){
        instance = new PortSubWindow(port);
    }
    public static void changeScene(int index){

        switch(index){
            case 0:


        }
    }
}

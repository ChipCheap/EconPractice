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

/**
 *
 */
public class PortWindow extends Stage{
    //fields
    /**
     *
     */
    private Port port;

    //constructors
    /**
     *
     * @param port
     */
    //TODO realize this as a singleton
    public PortWindow(Port port){
        super();
        this.port = port;
        //TODO positioning, fill with scene, delete the weird window border and make it look like it is integrated
        this.show();
        HBox mainHBox = new HBox();
        Scene s = new Scene(mainHBox);

        VBox priceList = new VBox();
        Label price1 = new Label("Clothing 40");
        for(int i = 0; i < WareType.values().length; i++){
            createLabel();
        }
        priceList.getChildren().add(price1);
        VBox shipMenu = new VBox();
        Label ships = new Label("ships");

        shipMenu.setPadding(new Insets(1, 1, 1, 1));
        shipMenu.getChildren().add(ships);
        mainHBox.getChildren().addAll(priceList, shipMenu);
        this.setScene(s);
    }

    private void createLabel(){

    }
}

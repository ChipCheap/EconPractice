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

/**
 *Port Window, which holds the ports information(Wares,politics,events, etc..)
 */
public class PortWindow extends Stage{
    //fields
    /**
     *sets the PortWindow's instance to null.
     */
    private static PortWindow instance = null;
    /**
     *Port from the Port class to realize the port Window.
     */
    private Port port;

    //constructors
    /**
     *Constructor for the PortWindow.
     * @param port Port from the Port class to realize the port Window.
     */
    //TODO realize this as a singleton
    private PortWindow(Port port){
        super();
        this.port = port;
        //TODO positioning, fill with scene, delete the weird window border and make it look like it is integrated
        this.show();
        HBox mainHBox = new HBox();
        Scene s = new Scene(mainHBox);
        HBox LeftHBox = new HBox();
        VBox priceNames = new VBox();
        for(int i = 0; i < WareType.values().length; i++){
            priceNames.getChildren().add(createNameLabel(i));
        }
        VBox priceList = new VBox();
        for(int i = 0; i < WareType.values().length; i++){
            priceList.getChildren().add(createPriceLabel(i));
        }
        LeftHBox.getChildren().addAll(priceNames,priceList);
        VBox RightVBox = new VBox();
        Label ships = new Label("ships");

        Button trade = new Button("Trade");
        Button production = new Button("Manage Production");
        Button politics = new Button("Politics");
        Button events = new Button("Events");
        Button empty = new Button("Niggerz");
        Button[] buttons = new Button[] {trade,production,politics,events,empty};
        for(int i = 0; i < buttons.length;i++){
            final int index = i;
            buttons[i].setOnMouseClicked(e -> createSubWindow(index));
        }
        HBox rightHBox = new HBox();


        Button buyShip = new Button("Buy Ship");
        Button invest = new Button("Invest");

        rightHBox.getChildren().addAll(buyShip,invest);

        RightVBox.setPadding(new Insets(1, 1, 1, 1));
        RightVBox.getChildren().addAll(rightHBox,trade,production,politics,events,empty);
        mainHBox.getChildren().addAll(LeftHBox, RightVBox);
        this.setScene(s);
        this.setOnCloseRequest(e ->instance = null);
    }
    /**
     * Creates the name for the respectetive WareType.
     * @param i index for lopp
     * @return returns wares
     */
    private Label createNameLabel(int i){
        Label wares = new Label("" + WareType.values()[i]);
        //Font font = new Font("ARIAL",3,30); TODO FONTS
        //wares.Font(font);
        return wares;
    }

    /**
     * Creates the prices for their respectetive WareTypes.
     * @param i index for the lopp
     * @return returns prices
     */
    private Label createPriceLabel(int i){
        Label price = new Label("" + port.getPriceList()[i]);
        return price;
    }

    /**
     * creates the Port Window itsself.
     * @param port port from the port class
     * @return returns the current instance
     */
    public static PortWindow createPortWindow(Port port){
        if(instance == null){
            instance = new PortWindow(port);
        }
        return instance;
    }

    /**
     * Creates the PortSubWindow next to the PortWindow.
     * @param index index for the loop
     */
    private void createSubWindow(int index){
        if(PortSubWindow.getInstance() == null){
            PortSubWindow.createInstance(port);
        }
        PortSubWindow.changeScene(index);
    }

}


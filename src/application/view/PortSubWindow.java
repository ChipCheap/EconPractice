package application.view;

import application.model.Port;
import application.model.WareType;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



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
     * @param port Port from the Port class to realize the PortSubWindow.
     */
    private PortSubWindow(Port port){
        super();
        //TODO positioning, fill with scene, delete the weird window border and make it look like it is integrated LuL
        this.port = port;
        this.show();
        this.setOnCloseRequest(e -> instance = null);
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
    public void changeScene(int index){

        switch(index){
            case 0:
                createTrade();
                break;
            case 1:
                createProduction();
                break;
            case 2:
                createPolitics();
                break;
            case 3:
                createEvents();
                break;

        }
    }

    /**
     * Creating the Trade Window to trade Wares as a PortSubWindow.
     */
    private void createTrade(){
        BorderPane mainPane = new BorderPane();

        HBox leftHBox = new HBox();
        VBox priceNames = new VBox();
        for(int i = 0; i < WareType.values().length; i++){
            priceNames.getChildren().add(createNameLabel(i));
        }
        VBox priceList = new VBox();
        for(int i = 0; i < WareType.values().length; i++){
            priceList.getChildren().add(createPriceLabel(i));
        }

        HBox rightHBox = new HBox();
        VBox priceNames2 = new VBox();
        for(int i = 0; i < WareType.values().length; i++){
            priceNames2.getChildren().add(createNameLabel(i));
        }
        VBox priceList2 = new VBox();
        for(int i = 0; i < WareType.values().length; i++){
            priceList2.getChildren().add(createPriceLabel(i));
        }


        VBox buttons = new VBox();
        Button buyGrain = new Button("Buy");
        Button buySpices = new Button("Buy");
        Button buyClothing = new Button("Buy");
        Button buyTools = new Button("Buy");
        Button buyCoffee = new Button("Buy");
        Button buyWeapons = new Button("Buy");
        Button buyCannons = new Button("Buy");
        buttons.getChildren().addAll(buyGrain,buySpices,buyClothing,buyTools,buyCoffee,buyWeapons,buyCannons);

        VBox buttons2 = new VBox();
        Button sellGrain = new Button("Sell");
        Button sellSpices = new Button("Sell");
        Button sellClothing = new Button("Sell");
        Button sellTools = new Button("Sell");
        Button sellCoffee = new Button("Sell");
        Button sellWeapons = new Button("Sell");
        Button sellCannons = new Button("Sell");
        buttons2.getChildren().addAll(sellGrain,sellSpices,sellClothing,sellTools,sellCoffee,sellWeapons,sellCannons);

        leftHBox.getChildren().addAll(priceNames,priceList,buttons);
        rightHBox.getChildren().addAll(buttons2,priceList2,priceNames2);

        mainPane.setLeft(leftHBox);
        mainPane.setRight(rightHBox);

        Scene s = new Scene(mainPane);
        setScene(s);

    }
    private void createProduction(){

    }
    private void createPolitics(){

    }
    private void createEvents(){

    }
    /**
     * Creates the name for the respectetive WareType and sets their font.
     * @param i index for lopp
     * @return returns wares
     */
    private Label createNameLabel(int i){
        Label wares = new Label("" + WareType.values()[i]);
        wares.setFont(Font.font("Verdana", 20 ));
        return wares;
    }

    /**
     * Creates the prices for their respectetive WareTypes and sets their font.
     * @param i index for the lopp
     * @return returns prices
     */
    private Label createPriceLabel(int i){
        Label price = new Label("" + port.getPriceList()[i]);
        price.setFont(Font.font("Verdana", 20 ));
        return price;
    }

}

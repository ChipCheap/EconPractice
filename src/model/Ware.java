package model;

/**
 * The ware, that the player can trade with.
 */
public class Ware {
    /**
     *The type of ware, that the player can trade with.
     */
    private WareType type;
    /**
     *The price, at which the ware was originally bought.
     */
    private int buyPrice;
    /**
     *The amount of wares, that the player buys.
     */
    private int amount;

    public Ware(WareType type, int buyPrice, int amount){
        this.type = type;
        this.buyPrice = buyPrice;
        this.amount = amount;
    }




}

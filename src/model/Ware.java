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

    /**
     *
     * @param type
     * @param buyPrice
     * @param amount
     */
    public Ware(WareType type, int buyPrice, int amount){
        this.type = type;
        this.buyPrice = buyPrice;
        this.amount = amount;
    }

    public Ware split(int amt){
        amount = amount - amt;
        Ware splitWare = new Ware(type, buyPrice, amt);
        buyPrice += 2; //TODO
        return splitWare;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

    public boolean equals(Ware ware) {
        return buyPrice == ware.buyPrice && type == ware.type && amount == ware.amount;
    }
}

package se.kth.IV1350.seminarThree.DTOPackage;

public class ItemDTO {
    private String itemDescription;
    private int itemID;
    private int price;
    private double VAT;

    public ItemDTO(String itemDescription, int itemID, int price, double VAT){
        this.itemDescription = itemDescription;
        this.itemID = itemID;
        this.price = price;
        this.VAT = VAT;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemID() {
        return itemID;
    }

    public int getPrice() {
        return price;
    }

    public double getVAT() {
        return VAT;
    }
}

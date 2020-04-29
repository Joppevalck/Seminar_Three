package se.kth.IV1350.seminarThree.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class CompletedSale {

    private LocalDateTime saleDateAndTime;
    private StoreLocation storeLocation;
    private HashMap<String, ItemAndQuantity> itemInventory;
    private double runningTotal;
    private int amountPaid;
    private double change;
    private double VAT;

    public CompletedSale(LocalDateTime saleDateAndTime, StoreLocation storeLocation,
                         HashMap<String, ItemAndQuantity> itemInventory, int runningTotal, int amountPaid) {
        this.saleDateAndTime = saleDateAndTime;
        this.storeLocation = storeLocation;
        this.itemInventory = itemInventory;
        this.runningTotal = runningTotal;
        this.amountPaid = amountPaid;
        this.change = amountPaid-runningTotal;
        calculateVAT();

    }

    private void calculateVAT(){
        this.VAT = 0;
        for (String itemDesc : itemInventory.keySet()){
            this.VAT += getVATfromItem(itemDesc);
        }
    }

    private double getVATfromItem(String itemDesc){
         double VATRate = itemInventory.get(itemDesc).getItem().getVAT();
         double itemPrice = itemInventory.get(itemDesc).getItem().getPrice();
         int quantity = itemInventory.get(itemDesc).getQuantity();
         return itemPrice*VATRate*quantity;
    }

    public LocalDateTime getSaleDateAndTime() {
        return saleDateAndTime;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public HashMap<String, ItemAndQuantity> getItemInventory() {
        return itemInventory;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public double getChange() {
        return change;
    }

    public double getVAT() {
        return VAT;
    }
}

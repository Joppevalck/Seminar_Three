package se.kth.IV1350.seminarThree.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Receipt {
    private LocalDateTime saleDateAndTime;
    private StoreLocation storeLocation;
    private ItemNameQuantityPrice[] itemAndPrices;
    private double runningTotal;
    private int amountPaid;
    private double change;
    private double VAT;

    public Receipt(CompletedSale completedSale) {
        storeCompletedSaleInformation(completedSale);
        getAllItemInformation(completedSale);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(saleDateAndTime.toString() + "\n" + storeLocation.toString() + "\n");
        for (ItemNameQuantityPrice itemAndPrice : itemAndPrices)
            sb.append(itemAndPrice).append("\n");
        sb.append("Total price: " + runningTotal + "kr\t" + "VAT: " + VAT + "kr\n" + "Amount paid: " + amountPaid +
                "kr\t" + "Change: " + change + "kr\n");

        return sb.toString();
    }

    private void storeCompletedSaleInformation(CompletedSale compSale){
        this.saleDateAndTime = compSale.getSaleDateAndTime();
        this.storeLocation = compSale.getStoreLocation();
        this.runningTotal = compSale.getRunningTotal();
        this.amountPaid = compSale.getAmountPaid();
        this.change = compSale.getChange();
        this.VAT = compSale.getVAT();
    }

    private void getAllItemInformation(CompletedSale compSale){
        HashMap<String, ItemAndQuantity> itemInv = compSale.getItemInventory();
        itemAndPrices = new ItemNameQuantityPrice[itemInv.size()];
        int i = 0;
        for(String itemDesc : itemInv.keySet()){
            ItemAndQuantity itemAndQuantity = itemInv.get(itemDesc);
            itemAndPrices[i++] = createItemAndPriceObject(itemAndQuantity);
        }
    }

    private ItemNameQuantityPrice createItemAndPriceObject(ItemAndQuantity itemAndQuantity){
        String name = itemAndQuantity.getItem().getItemDescription();
        int quantity = itemAndQuantity.getQuantity();
        int price = itemAndQuantity.getItem().getPrice();
        return new ItemNameQuantityPrice(name, quantity, price);
    }
}

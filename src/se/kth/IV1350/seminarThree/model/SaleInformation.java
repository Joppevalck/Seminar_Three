package se.kth.IV1350.seminarThree.model;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * SaleInformation contains all Information of a sale.
 */
public class SaleInformation {
    private LocalTime saleTime;
    private StoreLocation storeLocation;
    private Map itemInventory;
    private ItemAndQuantity lastItemAdded;
    private double VAT;
    private int runningTotal;
    private int amountPaid;
    private int change;


    /**
     * Creates an instance of SaleInformation. Initializes the sale information.
     */
    SaleInformation(){
        setTimeOfSale();
        setStoreLocationOfSale("nameOfStore", "addressOfStore" );
        createItemInventory();
        initMoneyVariables();
    }

    /**
     * Prints the running total and last item's that was registered description and price.
     *
     * @return String formated to print the running total and the item's description and price.
     */
    @Override
    public String toString() {
        return lastItemAdded == null ? "" : "Total price:" + runningTotal + "\n" + lastItemAdded.getQuantity() + "*" +
                lastItemAdded.getItem().getItemDescription() + "\t" + lastItemAdded.getQuantity() + "*" +
                lastItemAdded.getItem().getPrice();
    }

    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    private void setStoreLocationOfSale(String nameOfStore, String addressOfStore){
        this.storeLocation = new StoreLocation(nameOfStore, addressOfStore);
    }

    private void createItemInventory(){
        this.itemInventory = new HashMap<String, ItemAndQuantity>();
    }

    private void initMoneyVariables(){
        this.runningTotal = this.amountPaid = this.change = (int)(this.VAT = 0);
    }

}

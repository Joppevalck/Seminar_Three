package se.kth.IV1350.seminarThree.model;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * SaleInformation contains all Information of a sale.
 */
public class SaleInformation {
    private LocalDateTime saleDateAndTime;
    private StoreLocation storeLocation;
    private HashMap<String, ItemAndQuantity> itemInventory;
    private ItemAndQuantity lastItemAdded;
    private int runningTotal;

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
        return lastItemAdded == null ? "Total price: " + runningTotal + "kr \nNo item registered": "Total price: " + runningTotal +
                "kr\n" + lastItemAdded.getQuantity() + "*" + lastItemAdded.getItem().getItemDescription() + "\t" +
                lastItemAdded.getQuantity() + "*" + lastItemAdded.getItem().getPrice() + "kr \tVAT: "+
                lastItemAdded.getItem().getVAT()*100 + "%";
    }

    public SaleInformation addItem(ItemAndQuantity itemAndQuantity){
        addItemAndQuantity(itemAndQuantity);
        this.lastItemAdded = itemAndQuantity;
        updatePrice();
        return this;
    }

    public void setLastItemAddedToNull(){
        lastItemAdded = null;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public CompletedSale completeSale(int amountPaid){
        return  new CompletedSale(this.saleDateAndTime, this.storeLocation, this.itemInventory, this.runningTotal,
                amountPaid);
    }

    private void setTimeOfSale(){
        this.saleDateAndTime = LocalDateTime.now();
    }

    private void setStoreLocationOfSale(String nameOfStore, String addressOfStore){
        this.storeLocation = new StoreLocation(nameOfStore, addressOfStore);
    }

    private void createItemInventory(){
        this.itemInventory = new HashMap<String, ItemAndQuantity>();
    }

    private void initMoneyVariables(){
        this.runningTotal = 0;
    }

    private void addItemAndQuantity(ItemAndQuantity itemAndQuantity){
        String itemDescription = itemAndQuantity.getItem().getItemDescription();

        if(this.itemInventory.containsKey(itemDescription)){
            ItemAndQuantity prevAddedItem = this.itemInventory.get(itemDescription);
            prevAddedItem.addQuantity(itemAndQuantity.getQuantity());
        }
        else{
            this.itemInventory.put(itemDescription, itemAndQuantity);
        }
    }
    private void updatePrice(){
        ItemAndQuantity itemAndQuantity;
        this.runningTotal = 0;
        for(String itemDescription : this.itemInventory.keySet() ){
            itemAndQuantity = this.itemInventory.get(itemDescription);
            this.runningTotal += itemAndQuantity.getQuantity()*itemAndQuantity.getItem().getPrice();
        }
    }
}

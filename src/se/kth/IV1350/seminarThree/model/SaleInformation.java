package se.kth.IV1350.seminarThree.model;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * SaleInformation contains all Information of a sale.
 */
public class SaleInformation {
    private LocalTime saleTime;
    private StoreLocation storeLocation;
    private HashMap<String, ItemAndQuantity> itemInventory;
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
        return lastItemAdded == null ? "Total price: " + runningTotal + "kr \nNo item registered": "Total price: " + runningTotal +
                "kr\n" + lastItemAdded.getQuantity() + "*" + lastItemAdded.getItem().getItemDescription() + "\t" +
                lastItemAdded.getQuantity() + "*" + lastItemAdded.getItem().getPrice() + "kr";
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

    private void setTimeOfSale(){
        this.saleTime = LocalTime.now();
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

package se.kth.IV1350.seminarThree.integration;

import se.kth.IV1350.seminarThree.DTOPackage.ItemDTO;
import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;
import se.kth.IV1350.seminarThree.model.CompletedSale;

/**
 * This class resembles a database where all the item information of the store lies. In this seminar it will be
 * hardcoded with a few items.
 */
public class ExternalInventorySystem {
    private ItemDTO[] items = { new ItemDTO("Banana", 1, 5, 0.12),
            new ItemDTO("Soda", 2, 15, 0.12),
            new ItemDTO("Book", 3, 49, 0.06),
            new ItemDTO("Frying Pan", 4, 299, 0.25),
            new ItemDTO("Bread", 5, 29, 0.12)};

    /**
     * This will get the iteminformation from the hardcoded database.
     *
     * @param scannedItem contains the item identifier which will select which item information will return.
     * @return resembles an item and the information about it.
     */
    public ItemDTO getItemInformation(ScannedItemDTO scannedItem) {
        if(checkItemID(scannedItem))
            return this.items[scannedItem.getItemID() - 1];
        else
            throw new ArrayIndexOutOfBoundsException("Item ID ("+scannedItem.getItemID()+") is invalid. ");
    }

    private boolean checkItemID(ScannedItemDTO scannedItem){
        return scannedItem.getItemID() > 0 && scannedItem.getItemID() < (items.length+1);
    }

    /**
     * This will update the item inventory after a completed sale.
     * @param completedSale contains the completed sale information.
     */
    public void updateInventory(CompletedSale completedSale) {
        // Code that updates the inventory system.
    }
}

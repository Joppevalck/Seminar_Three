package se.kth.IV1350.seminarThree.integration;

import se.kth.IV1350.seminarThree.DTOPackage.ItemDTO;
import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;

public class ExternalInventorySystem {
    private ItemDTO[] items = { new ItemDTO("Banana", 1, 5, 0.12),
            new ItemDTO("Soda", 2, 15, 0.12),
            new ItemDTO("Book", 3, 49, 0.06),
            new ItemDTO("Frying Pan", 4, 299, 0.25),
            new ItemDTO("Bread", 5, 29, 0.12)};

    public ItemDTO getItemInformation(ScannedItemDTO scannedItem) {
        if(checkItemID(scannedItem))
            return this.items[scannedItem.getItemID() - 1];
        else
            throw new ArrayIndexOutOfBoundsException("Item ID ("+scannedItem.getItemID()+") is invalid. ");
    }

    private boolean checkItemID(ScannedItemDTO scannedItem){
        return scannedItem.getItemID() > 0 && scannedItem.getItemID() < (items.length+1);
    }
}

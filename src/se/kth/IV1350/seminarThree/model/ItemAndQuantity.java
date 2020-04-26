package se.kth.IV1350.seminarThree.model;

import se.kth.IV1350.seminarThree.DTOPackage.ItemDTO;

public class ItemAndQuantity {
    private ItemDTO item;
    private int quantity;

    public ItemAndQuantity(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ItemDTO getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

package se.kth.IV1350.seminarThree.model;

public class Sale {
    private SaleInformation saleInfo;
    private boolean saleActive;

    public Sale(){
        initSale();
    }

    public SaleInformation addItemToSale(ItemAndQuantity itemAndQuantity){
        if(saleActive)
            return saleInfo.addItem(itemAndQuantity);
        return saleInfo;
    }

    public boolean isSaleActive() {
        return saleActive;
    }

    public SaleInformation getSaleInformation(){
        return saleInfo;
    }

    public int endSale(){
        saleActive = false;
        saleInfo.setLastItemAddedToNull();
        return saleInfo.getRunningTotal();
    }

    private void initSale(){
        this.saleInfo = new SaleInformation();
        this.saleActive = true;
    }
}

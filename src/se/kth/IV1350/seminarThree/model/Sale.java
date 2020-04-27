package se.kth.IV1350.seminarThree.model;

public class Sale {
    private SaleInformation saleInfo;
    private boolean saleActive;

    public Sale(){
        initSale();
    }

    public SaleInformation addItemToSale(ItemAndQuantity itemAndQuantity){
            return saleInfo.addItem(itemAndQuantity);
    }

    public boolean isSaleActive() {
        return saleActive;
    }
    public SaleInformation saleNotActive(){
        return saleInfo;
    }

    private void initSale(){
        this.saleInfo = new SaleInformation();
        this.saleActive = true;
    }
}

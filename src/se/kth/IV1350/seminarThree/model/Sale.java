package se.kth.IV1350.seminarThree.model;

public class Sale {
    private SaleInformation saleInfo;
    private boolean saleActive;

    public Sale(){
        initSale();
    }

    private void initSale(){
        this.saleInfo = new SaleInformation();
        this.saleActive = true;
    }
}

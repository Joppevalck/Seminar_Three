package se.kth.IV1350.seminarThree.model;

import java.time.LocalTime;
import java.util.Map;

public class SaleInformation {
    private LocalTime saleTime;
    private StoreLocation storeLocation;
    private Map items;

    /**
     *
     */
    public SaleInformation(){
        setTimeOfSale();
        setStoreLocationOfSale("nameOfStore", "addressOfStore" );
    }

    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    private void setStoreLocationOfSale(String nameOfStore, String addressOfStore){
        this.storeLocation = new StoreLocation(nameOfStore, addressOfStore);
    }

}

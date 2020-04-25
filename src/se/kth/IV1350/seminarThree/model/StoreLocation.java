package se.kth.IV1350.seminarThree.model;

public class StoreLocation {
    private String addressOfStore;
    private String nameOfStore;

    public StoreLocation(String addressOfStore, String nameOfStore){
        this.addressOfStore = addressOfStore;
        this.nameOfStore = nameOfStore;
    }

    String getAddressOfStore() {
        return addressOfStore;
    }

    String getNameOfStore() {
        return nameOfStore;
    }
}

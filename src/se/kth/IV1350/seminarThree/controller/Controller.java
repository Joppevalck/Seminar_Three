package se.kth.IV1350.seminarThree.controller;

import se.kth.IV1350.seminarThree.DTOPackage.ItemDTO;
import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;
import se.kth.IV1350.seminarThree.integration.*;
import se.kth.IV1350.seminarThree.model.*;

/**
 *  This is the applications controller. All calls to the model goes through this class.
 */
public class Controller {

    //  These attributes belong in the integration Layer
    private ExternalSystemCreator exSysCreator;

    //  These attributes belong in the model Layer
    private SaleLog saleLog;
    private Register register;
    private Sale sale;

    /**
     * Creates a new instance of the class Controller. It also creates an instance of SaleLog and Register.
     *
     * @param exSysCreator Contains all external systems that Controller needs.
     */
    public Controller(ExternalSystemCreator exSysCreator){
        this.exSysCreator = exSysCreator;

        this.saleLog = new SaleLog();
        this.register = new Register();

    }

    @Override
    public String toString() {
        return sale.isSaleActive() ? "Sale is active" : "Sale is not active";
    }

    public void saleStart(){
        this.sale = new Sale();
    }

    public SaleInformation registerItem(ScannedItemDTO scannedItem){
        if(sale == null){
            return null;
        }
        else if(sale.isSaleActive()){
            return addNewItem(scannedItem);
        }
        else{
            return sale.getSaleInformation();
        }
    }

    public int endSale(){
        return sale.endSale();
    }

    public double payment(int amountPaid){
        CompletedSale completedSale = sale.payment(amountPaid);
        Receipt receipt = new Receipt(completedSale);
        exSysCreator.getExAccSys().

        return completedSale.getChange();
    }
    private ItemDTO getItem(ScannedItemDTO scannedItem){
        return exSysCreator.getExInvSys().getItemInformation(scannedItem);
    }

    private ItemAndQuantity mergeItemAndQuantity(ItemDTO item, ScannedItemDTO scannedItem){
        return new ItemAndQuantity(item, scannedItem.getQuantity());
    }

    private SaleInformation addNewItem(ScannedItemDTO scannedItem){
        ItemDTO item = getItem(scannedItem);
        ItemAndQuantity itemAndQuantity = mergeItemAndQuantity(item, scannedItem);
        return sale.addItemToSale(itemAndQuantity);
    }


}

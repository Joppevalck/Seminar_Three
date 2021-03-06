package se.kth.IV1350.seminarThree.view;

import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;
import se.kth.IV1350.seminarThree.controller.Controller;

/**
 * This is a replacement or a faked version for the real view. It contains hardcoded execution to all call all system
 * operation in the controller
 */
public class View {
    private Controller ctrl;

    /**
     * Creates an instance of View, keeps track of an instance of the class Controller.
     *
     * @param ctrl is the controller that view is going to call.
     */
    public View(Controller ctrl){
        this.ctrl = ctrl;
    }

    /**
     * Simulates a sale, calls all public methods from the Controller class.
     */
    public void runFakeExecution(){
        runFakeSaleStart();
        runFakeRegisterItem(1, 2);
        runFakeRegisterItem(3, 3);
        runFakeEndSale();
        runFakeRegisterItem(2, 1);
        runFakePayment(200);
    }

    private void runFakeSaleStart(){
        ctrl.saleStart();
        System.out.println("A new sale has started.\n");
    }

    private void runFakeRegisterItem(int itemID, int quantity){
        ScannedItemDTO scannedItem = new ScannedItemDTO(itemID, quantity);
        String updatedSaleInfo = ctrl.registerItem(scannedItem).toString();
        if(updatedSaleInfo.contains("*")) {
            System.out.println("Item " + itemID + " with " + quantity + " quantities has been added. \nThe new " +
                    "saleinformation is:\n" + updatedSaleInfo + "\n");
        }else{
            System.out.println("Sale not active.\n");
        }

    }

    private void runFakeEndSale(){
        double total = ctrl.endSale();
        System.out.println("Amount to pay: " + total + "kr \n");
    }

    private void runFakePayment(int amountPaid){
        double change = ctrl.payment(amountPaid);
        System.out.println("\nChange: " + change);
    }
}

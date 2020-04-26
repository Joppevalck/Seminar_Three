package se.kth.IV1350.seminarThree.view;

import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;
import se.kth.IV1350.seminarThree.controller.Controller;

/**
 * This is a replacement or a faked version for the real view. It contains hardcoded execution to all call all system
 * operation in the controller
 */
public class View {
    private Controller ctrl;

    public View(Controller ctrl){
        this.ctrl = ctrl;
    }

    public void runFakeExecution(){
        runFakeSaleStart();
        System.out.println("A new sale has started.");

        runFakeRegisterItem(1, 2);
        System.out.println("An item with 2 quantities has been added.");
        System.out.println("The new saleinformation is:");

    }

    private void runFakeSaleStart(){
        ctrl.saleStart();
    }

    private void runFakeRegisterItem(int itemID, int quantity){
        ScannedItemDTO scannedItem = new ScannedItemDTO(itemID, quantity);


    }
}

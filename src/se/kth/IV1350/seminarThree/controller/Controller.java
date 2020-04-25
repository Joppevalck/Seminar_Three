package se.kth.IV1350.seminarThree.controller;

import se.kth.IV1350.seminarThree.integration.*;
import se.kth.IV1350.seminarThree.model.Register;
import se.kth.IV1350.seminarThree.model.SaleLog;

/**
 *  This is the applications controller. All calls to the model goes through this class.
 */
public class Controller {

    //  These attributes belong in the integration Layer
    private ExternalSystemCreator exSysCreator;

    //  These attributes belong in the model Layer
    private SaleLog saleLog;
    private Register register;

    /**
     * Creates a new instance of the class Controller. It also creates an instance of SaleLog and Register.
     *
     * @param exSysCreator Contains all external systems that Controller needs.
     */
    public Controller(ExternalSystemCreator exSysCreator){
        this.exSysCreator = exSysCreator;

        this.saleLog = new SaleLog();
    //    this.register = new Register();

    }

    public void saleStart(){

    }

}

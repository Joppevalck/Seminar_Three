package se.kth.IV1350.seminarThree.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import se.kth.IV1350.seminarThree.DTOPackage.ItemDTO;
import se.kth.IV1350.seminarThree.controller.Controller;
import se.kth.IV1350.seminarThree.integration.ExternalSystemCreator;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        ExternalSystemCreator exSysCreator = new ExternalSystemCreator();
        Controller ctrl = new Controller(exSysCreator);
        instanceToTest = new View(ctrl);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown(){
        instanceToTest = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRunFakeExecutionStartSale(){
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();

        testStartSale();
    }

    @Test
    public void testRunFakeExecutionRegisterItem(){
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();

        testAddedItems();
        testRunningTotal();
    }

    @Test
    public void testRunFakeExecutionEndSale(){
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();

        testEndSale();
    }

    private void testStartSale(){
        String expectedOutput = "started";
        assertTrue(printoutBuffer.toString().contains(expectedOutput),
                "UI did not start correctly.");
    }

    private void testAddedItems(){
        expectedRegItemID(1);
        expectedRegItemID(3);
    }

    private void expectedRegItemID(int itemID){
        String expectedOutput = "Item " + itemID;
        assertTrue(printoutBuffer.toString().contains(expectedOutput),
                "Item " + itemID + " did not get added.");
    }

    private void testRunningTotal(){
        expectedRunningPrice(10);
        expectedRunningPrice(157);

    }

    private void expectedRunningPrice(int price){
        String expectedOutput = "Total price: " + price + "kr\n";
        assertTrue(printoutBuffer.toString().contains(expectedOutput),
                "Running Total for price " + price + "kr not correct.");
    }

    private void testEndSale(){
        String expectedOutput = "Amount to pay: ";
        assertTrue(printoutBuffer.toString().contains(expectedOutput),
                "EndSale did not execute properly.");
    }

}
package se.kth.IV1350.seminarThree.controller;

import org.junit.jupiter.api.*;
import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;
import se.kth.IV1350.seminarThree.integration.ExternalSystemCreator;
import se.kth.IV1350.seminarThree.model.SaleInformation;
import se.kth.IV1350.seminarThree.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        ExternalSystemCreator exSysCreator = new ExternalSystemCreator();
        instanceToTest = new Controller(exSysCreator);

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
    public void testSaleStart(){
        instanceToTest.saleStart();
        assertTrue(instanceToTest.toString().contains("Sale is active"),
                "Sale did not start correctly");
    }

    @Test
    public void testAddAllItemID(){

        instanceToTest.saleStart();
        for (int i = 1; i < 6; i++){
            ScannedItemDTO scannedItem = new ScannedItemDTO(i, i);
            String printout = instanceToTest.registerItem(scannedItem).toString();
            String expectedOutput = i + "*";
            assertTrue(printout.contains(expectedOutput),
                    "Item " + i + " did not get added.");
        }
    }
    @Test
    public void testRegisterItemWithoutSaleStart(){

        ScannedItemDTO scannedItem = new ScannedItemDTO(1, 1);
        SaleInformation saleInfo = instanceToTest.registerItem(scannedItem);
        assertNull(saleInfo, "RegisterItem went through without a saleStart.");
    }

    @Test
    public void testInvalidItemID(){
        instanceToTest.saleStart();
        specificScannedItem(0,1);
        specificScannedItem(6,1);
        specificScannedItem(Integer.MAX_VALUE, 1);
        specificScannedItem(Integer.MIN_VALUE, 1);
    }

    @Test
    public void testEndSale(){
        instanceToTest.saleStart();
        instanceToTest.endSale();

        String expectedOutput = "Sale is not active";
        assertTrue(instanceToTest.toString().contains(expectedOutput),
                "Sale did not end correctly");
    }

    @Test
    public void testEndSaleWithoutStartingASale(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            instanceToTest.endSale();;
        });
    }
    private void specificScannedItem(int itemID, int quantity){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ScannedItemDTO scannedItem = new ScannedItemDTO(itemID, quantity);
            instanceToTest.registerItem(scannedItem);
        });
    }

}
package se.kth.IV1350.seminarThree.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.IV1350.seminarThree.DTOPackage.ItemDTO;
import se.kth.IV1350.seminarThree.DTOPackage.ScannedItemDTO;
import se.kth.IV1350.seminarThree.controller.Controller;
import se.kth.IV1350.seminarThree.model.SaleInformation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventorySystemTest {
    private ExternalInventorySystem instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {

        instanceToTest = new ExternalInventorySystem();

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
    public void testAddAllItemDescription(){
        String expectedOutput;
        for (int i = 1; i < 6; i++){
            ScannedItemDTO scannedItem = new ScannedItemDTO(i, i);
            String printout = instanceToTest.getItemInformation(scannedItem).getItemDescription();
            switch (i) {
                case 1:
                    expectedOutput = "Banana";
                    break;
                case 2:
                    expectedOutput = "Soda";
                    break;
                case 3:
                    expectedOutput = "Book";
                    break;
                case 4:
                    expectedOutput = "Frying Pan";
                    break;
                case 5:
                    expectedOutput = "Bread";
                    break;
                default:
                    expectedOutput = null;
            }

            assertTrue(printout.contains(expectedOutput),
                    "Item nr." + i + " did not have correct item description");
        }
    }

    @Test
    public void testInvalidItemID(){
        assertException(0,1);
        assertException(6,1);
        assertException(Integer.MAX_VALUE,1);
        assertException(Integer.MAX_VALUE,1);
    }

    private ItemDTO specificScannedItem(int itemID, int quantity){
        ScannedItemDTO scannedItem = new ScannedItemDTO(itemID, quantity);
        return instanceToTest.getItemInformation(scannedItem);
    }

    private void assertException(int itemID, int quantity){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            specificScannedItem(itemID,quantity);
        });
    }

}
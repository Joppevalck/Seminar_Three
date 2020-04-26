package se.kth.IV1350.seminarThree.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import se.kth.IV1350.seminarThree.controller.Controller;
import se.kth.IV1350.seminarThree.integration.ExternalSystemCreator;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printout;

    @BeforeEach
    public void setUp() {
        ExternalSystemCreator exSysCreator = new ExternalSystemCreator();
        Controller ctrl = new Controller(exSysCreator);
        instanceToTest = new View(ctrl);
        printout = new ByteArrayOutputStream();
    }

    @AfterEach
    public void tearDown(){
        instanceToTest = null;
    }

    @Test
    public void testRunFakeExecution(){
        System.out.println("runFakeExecution");
        View instance = null;
    }

}
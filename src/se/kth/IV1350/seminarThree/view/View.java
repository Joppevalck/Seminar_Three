package se.kth.IV1350.seminarThree.view;

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
}

package com.github.etienneZink.controller.listener;

import com.github.etienneZink.controller.Controller;
import com.github.etienneZink.view.JSudokuTextField;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Listener to react if the changed input is not between 1 - 4/9/16
 */
public class ValueChangeListener extends KeyAdapter{

    private Controller controller;

    public ValueChangeListener(Controller controller) {
        this.controller = controller;
    }

    public void keyReleased(KeyEvent ke) {
        JSudokuTextField component = (JSudokuTextField) ke.getSource();
        String text = component.getText();
        if(!text.equals("")){
            controller.submitValue(component.getIndexRow(),component.getIndexColumn(), Integer.parseInt(text));
        }
     }
}
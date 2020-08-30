package com.github.etienneZink.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.etienneZink.controller.Controller;

/**
 * Listener to react if the solve-button gets pressed
 */
public class SolveListener implements ActionListener {

    private Controller controller;

    public SolveListener(Controller controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.solve();
    }
    
}
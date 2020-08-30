package com.github.etienneZink.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.etienneZink.controller.Controller;

/**
 * Listener to react if the check-button gets pressed
 */
public class CheckListener implements ActionListener {

    private Controller controller;

    public CheckListener(Controller controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.check();
    }
}
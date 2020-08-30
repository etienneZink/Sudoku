package com.github.etienneZink.controller.listener;

import java.awt.event.WindowEvent;

import com.github.etienneZink.controller.Controller;

import java.awt.event.WindowAdapter;

/**
 * Listener to react if the close-button gets pressed
 */
public class SaveWhenCloseListener extends WindowAdapter {

    Controller controller;

    public SaveWhenCloseListener(Controller controller){
        this.controller = controller;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        controller.save();
    }
    
}
package com.github.etienneZink.controller.listener;

import com.github.etienneZink.controller.Controller;
import com.github.etienneZink.view.JSudokuTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValueChangeListener implements ActionListener{

    private Controller controller;

    public ValueChangeListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent ek) {
        JSudokuTextField jstf = (JSudokuTextField) ek.getSource();
        String text = jstf.getText();
        int row = jstf.getIndexRow();
        int column = jstf.getIndexColumn();
        if(text != ""){
            controller.submitValue(row,column, Integer.parseInt(text));
        }     
    }
}
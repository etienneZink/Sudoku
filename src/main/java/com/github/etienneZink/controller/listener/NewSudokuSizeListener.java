package com.github.etienneZink.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.etienneZink.controller.Controller;

public class NewSudokuSizeListener implements ActionListener {

    private Controller controller;
    private int BOARD_SIZE;

    public NewSudokuSizeListener(Controller controller, int BOARD_SIZE){
        this.controller = controller;
        this.BOARD_SIZE = BOARD_SIZE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.setBOARD_SIZE(BOARD_SIZE);
        controller.newSudoku();
    }
    
}
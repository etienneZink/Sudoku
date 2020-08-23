package com.github.etienneZink.controller;

import com.github.etienneZink.model.sudoku.framework.boards.BasicBoard;
import com.github.etienneZink.view.GUI;

public class Controller {
    
    private GUI gui;
    private BasicBoard model;

    public Controller(BasicBoard model){
        this.model = model;
        this.gui = new GUI(model.getFields());
    }

    private void loadValues(){

    }
}
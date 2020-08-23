package com.github.etienneZink.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import com.github.etienneZink.controller.listener.CheckListener;
import com.github.etienneZink.controller.listener.ClearListener;
import com.github.etienneZink.controller.listener.NewSudokuListener;
import com.github.etienneZink.controller.listener.NewSudokuSizeListener;
import com.github.etienneZink.controller.listener.SolveListener;
import com.github.etienneZink.model.sudoku.framework.boards.BasicBoard;
import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.view.GUI;
import com.github.etienneZink.view.JSudokuTextField;

public class Controller {

    private GUI view;
    private BasicBoard model;
    private int BOARD_SIZE;

    public Controller(int BOARD_SIZE) {
        this.BOARD_SIZE = BOARD_SIZE;
        model = new ClassicSudoku(BOARD_SIZE);
        view = new GUI(model.getFields());
        view.getClearBTN().addActionListener(new ClearListener(this));
        view.getNewSudokuBTN().addActionListener(new NewSudokuListener(this));
        view.getSolveBTN().addActionListener(new SolveListener(this));
        view.getCheckBTN().addActionListener(new CheckListener(this));
        view.getMenuVierMalVier().addActionListener(new NewSudokuSizeListener(this, 4));
        view.getMenuNeunMalNeun().addActionListener(new NewSudokuSizeListener(this, 9));
        view.getMenuSechzehnMalSechzehn().addActionListener(new NewSudokuSizeListener(this, 16));
    }

    public void clear() {
        model.clear();
        view.initializeContentPane(model.getFields());
    }

    public void newSudoku() {
        model = new ClassicSudoku(BOARD_SIZE);
        view.initializeContentPane(model.getFields());
    }

    public void solve() {
        model.solve();
        view.changeValues(model.getSolvedFields());
    }

    public void check(){
        ArrayList<Integer[]> indexes;
        Integer[] index;
        Iterator<Integer[]> iterator;
        JSudokuTextField[][] jstfArray = view.getJSTF();
        if (model.isSolved()) {
            for(int row = 0; row < model.BOARD_SIZE; ++row){
                for(int column = 0; column < model.BOARD_SIZE; ++column){
                    jstfArray[row][column].setBackground(Color.green);
                }
            }
        } else {
            indexes = model.compare();
            iterator = indexes.iterator();
            while(iterator.hasNext()){
                index = iterator.next();
                jstfArray[index[0]][index[1]].setBackground(Color.red);
            }
        }
        
    }

    public void setBOARD_SIZE(int BOARD_SIZE){
        this.BOARD_SIZE = BOARD_SIZE;
    }
}
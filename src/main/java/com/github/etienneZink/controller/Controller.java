package com.github.etienneZink.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import com.github.etienneZink.controller.listener.*;
import com.github.etienneZink.model.sudoku.framework.boards.BasicBoard;
import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.view.GUI;
import com.github.etienneZink.view.JSudokuTextField;

import org.apache.commons.lang.SystemUtils;

import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Controller {

    public final File file;
    public final File path;
    private GUI view;
    private BasicBoard model;
    private int BOARD_SIZE = 9;

    public Controller() {
        path = new File(SystemUtils.getUserHome().toString() + File.separator + "Sudoku" + File.separator + "saveFile");
        path.mkdirs();
        file = new File(path.toString() + File.separator + "saveFile.txt");

        if(file.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                model = (ClassicSudoku) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            model = new ClassicSudoku(BOARD_SIZE); 
        }
        this.BOARD_SIZE = model.BOARD_SIZE;
        view = new GUI(model.getFields());
        view.getClearBTN().addActionListener(new ClearListener(this));
        view.getNewSudokuBTN().addActionListener(new NewSudokuListener(this));
        view.getSolveBTN().addActionListener(new SolveListener(this));
        view.getCheckBTN().addActionListener(new CheckListener(this));
        view.getMenuVierMalVier().addActionListener(new NewSudokuSizeListener(this, 4));
        view.getMenuNeunMalNeun().addActionListener(new NewSudokuSizeListener(this, 9));
        view.getMenuSechzehnMalSechzehn().addActionListener(new NewSudokuSizeListener(this, 16));
        view.getFrame().addWindowListener(new SaveWhenCloseListener(this));
        initializeTFListener();
    }

    public void clear() {
        model.clear();
        view.initializeContentPane(model.getFields());
        initializeTFListener();
    }

    public void newSudoku() {
        model = new ClassicSudoku(BOARD_SIZE);
        view.initializeContentPane(model.getFields());
        initializeTFListener();
    }

    public void solve() {
        Integer[] index;
        ArrayList<Integer[]> indexes;
        Iterator<Integer[]> iterator;
        JSudokuTextField[][] jstfArray;
        indexes = model.compare();
        clear();
        jstfArray = view.getJSTF();
        model.solve();
        view.changeValues(model.getFields());
        iterator = indexes.iterator();
        while (iterator.hasNext()) {
            index = iterator.next();
            jstfArray[index[0]][index[1]].setBackground(Color.green);
        }
    }

    public void submitValue(int row, int column, int value) {
        model.setFieldAt(row, column, new SudokuField(value));
    }

    public void save(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            file.createNewFile();
            oos.writeObject(model);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check() {
        ArrayList<Integer[]> indexes;
        Integer[] index;
        Iterator<Integer[]> iterator;
        JSudokuTextField[][] jstfArray = view.getJSTF();
        if (model.isSolved()) {
            for (int row = 0; row < model.BOARD_SIZE; ++row) {
                for (int column = 0; column < model.BOARD_SIZE; ++column) {
                    jstfArray[row][column].setBackground(Color.green);
                }
            }
        } else {
            indexes = model.compare();
            iterator = indexes.iterator();
            while (iterator.hasNext()) {
                index = iterator.next();
                jstfArray[index[0]][index[1]].setBackground(Color.red);
            }
        }
    }

    private void initializeTFListener() {
        JSudokuTextField[][] jstfArray = view.getJSTF();
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                jstfArray[row][column].addKeyListener(new ValidateInputListener(this));
                jstfArray[row][column].addKeyListener(new ValueChangeListener(this));
            }
        }
    }

    // getter and setter

    public void setBOARD_SIZE(int BOARD_SIZE) {
        this.BOARD_SIZE = BOARD_SIZE;
    }

    public int getBOARD_SIZE() {
        return BOARD_SIZE;
    }
}
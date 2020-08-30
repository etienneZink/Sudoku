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

/**
 * Class that represents the interface between model and view. It launches a
 * <code>ClassicSudoku</code> as model and a <code>GUI</code> as the view.
 * 
 * @see ClassicSudoku
 * @see GUI
 */
public class Controller {

    public final File file;
    public final File path;
    private GUI view;
    private BasicBoard model;
    private int BOARD_SIZE = 9;

    // constructor

    public Controller() {
        path = new File(SystemUtils.getUserHome().toString() + File.separator + "Sudoku" + File.separator + "saveFile");
        path.mkdirs();
        file = new File(path.toString() + File.separator + "saveFile.txt");
        // load savefile
        if (file.exists()) {
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
        // initialize listeners
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

    // non-static methods

    /**
     * Clears all the non initial <code>Field</code> objets of the
     * <code>model</code> and initializes the <code>contentPane</code> of the
     * <code>view</code> and the <code>listeners</code> of it.
     */
    public void clear() {
        model.clear();
        view.initializeContentPane(model.getFields());
        initializeTFListener();
    }

    /**
     * This method creates a new <code>ClassicSudoku</code> as the
     * <code>model</code> and initializes the <code>contentPane</code> of the
     * <code>view</code> and the <code>listeners</code> of it.
     */
    public void newSudoku() {
        model = new ClassicSudoku(BOARD_SIZE);
        view.initializeContentPane(model.getFields());
        initializeTFListener();
    }

    /**
     * <code>Clear()</code> the <code>model</code> and <code>solve()</code> it. Then
     * initializes the <code>contentPane</code> of the <code>view</code> and the
     * <code>listeners</code> of it. Sets the <code>background</code> of all
     * <code>JSudokuTextField</code> objects to green, if they are newly set.
     */
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

    /**
     * Submits the value to the <code>model</code>.
     */
    public void submitValue(int row, int column, int value) {
        model.setFieldAt(row, column, new SudokuField(value));
    }

    /**
     * Saves the current <code>model</code> at <code>{@value #path}<code>
     */
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            file.createNewFile();
            oos.writeObject(model);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <code>Check()</code> if the <code>model isSolved()</code>. If
     * <code>true</code>, changes the <code>background</code> of all
     * <code>JSudokuTextField</code> objects to <code>green</code>, else changes the
     * <code>background</code> of all <code>JSudokuTextField</code> objects which
     * are wrong to <code>red</code>.
     */
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

    /**
     * Initializes the <code>ValidateInputListener</code> and the
     * <code>ValueChangeListener</code> to all the <code>JSudokuTextFiled</code>
     * objects of the <code>view</code>.
     */
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
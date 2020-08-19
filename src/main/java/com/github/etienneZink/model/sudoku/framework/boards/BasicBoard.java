package com.github.etienneZink.model.sudoku.framework.boards;

import java.io.Serializable;
import java.util.ArrayList;

import com.github.etienneZink.model.sudoku.framework.fields.Field;

/**
 * Abstract implementation of a basic game-board.
 */

public abstract class BasicBoard implements Serializable {

    private static final long serialVersionUID = 6535261797996973259L;

    public final int BOARD_SIZE;
    public final int BOARD_SIZE_ROOT;

    private boolean solved = false;
    private boolean isSolvable;

    private Field[][] fields;
    private Field[][] solvedFields;

    public BasicBoard() {
        BOARD_SIZE = 9;
        BOARD_SIZE_ROOT = 3;
        initializeFields();
        initializeSolvedFields();
    }

    public BasicBoard(Field[][] fields) {
        double BOARD_SIZE_ROOT = Math.sqrt(fields.length);

        if (BOARD_SIZE_ROOT == Math.floor(BOARD_SIZE_ROOT)) {
            this.BOARD_SIZE = fields.length;
            this.BOARD_SIZE_ROOT = (int) BOARD_SIZE_ROOT;
            this.fields = fields;
        } else {
            this.BOARD_SIZE = 9;
            this.BOARD_SIZE_ROOT = 3;
            this.fields = newArray(BOARD_SIZE, BOARD_SIZE);
        }
        initializeSolvedFields();
    }

    // non-static methods

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-column/row/group</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    public boolean checkValue(int row, int column, int value) {
        return (inRow(row, column, value) || inColumn(row, column, value) || inGroup(row, column, value));
    }

    /**
     * Compares <code>fields</code> with <code>solvedFields</code>.
     * @return <code>ArrayList<Integer[]></code> with the indexes of the wrong <code>Field</code> in <code>fields</code>.
     */
    public ArrayList<Integer[]> compare(){
        ArrayList<Integer[]> wrongIndexes = new ArrayList<Integer[]>();
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (fields[row][column] != solvedFields[row][column]) {
                    wrongIndexes.add(new Integer[]{row, column});
                }
            }
        }
        return wrongIndexes;
    }

    /**
     * Checks if the given <code>index</code> is appropriate for an
     * <code>array</code> with <code>length == BOARD_SIZE</code>.
     * 
     * @param index
     * @return <code>true</code> if <code>-1 < index < BOARD_SIZE</code>, else
     *         <code>false</code>.
     */
    private boolean indexInBoard(int index) {
        return (-1 < index && index < BOARD_SIZE) ? true : false;
    }

    private void initializeFields(){
        fields = newArray(BOARD_SIZE, BOARD_SIZE);
        for(int row = 0; row < BOARD_SIZE; ++row){
            for(int column = 0; column < BOARD_SIZE; ++column){
                fields[row][column] = newEmptyField();
            }
        }
        generateRandomFields();
    }

    /**
     * Initialize the <code>solvedSudoku</code>.
     */
    private void initializeSolvedFields() {
        solve();
        solvedFields = getFieldsOf(fields);
        clear();
    }

    /**
     * Clears all <code>Field</code> objects in <code>fields</code>, which aren't
     * <code>initial</code>.
     */
    private void clear() {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (!fields[row][column].isInitial()) {
                    fields[row][column] = newEmptyField();
                }
            }
        }
        solved = false;
    }

    /**
     * 
     * @param originalFields
     * @return New instance of <code>Field[][]</code> but with same
     *         <code>values</code> as <code>originalFields</code>.
     */
    private Field[][] getFieldsOf(Field[][] originalFields) {
        Field[][] tempSudoku = newArray(BOARD_SIZE, BOARD_SIZE);
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                tempSudoku[row][column] = originalFields[row][column];
            }
        }
        return tempSudoku;
    }

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-column</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inColumn(int fieldRow, int column, int value) {
        if (indexInBoard(fieldRow) && indexInBoard(column)) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (value == fields[row][column].getValue() && row != fieldRow) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-row</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inRow(int row, int fieldColumn, int value) {
        if (indexInBoard(row) && indexInBoard(fieldColumn)) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (value == fields[row][column].getValue() && column != fieldColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-group</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inGroup(int row, int column, int value) {
        int groupStartRow = (row / BOARD_SIZE_ROOT) * BOARD_SIZE_ROOT;
        int groupStartColumn = (column / BOARD_SIZE_ROOT) * BOARD_SIZE_ROOT;

        if (indexInBoard(row) && indexInBoard(column)) {
            for (int tempRow = groupStartRow; tempRow < groupStartRow + BOARD_SIZE_ROOT; ++tempRow) {
                for (int tempColumn = groupStartColumn; tempColumn < groupStartColumn + BOARD_SIZE_ROOT; ++tempColumn) {
                    if (value == fields[tempRow][tempColumn].getValue() && row != tempRow && column != tempColumn) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // getter and setter

    /**
     * 
     * @return The current value of <code>solved</code> without
     *         <code>valuation</code>, if this is the correct value or not.
     */
    public boolean getSolved() {
        return solved;
    }

    public boolean isSolvable() {
        return isSolvable;
    }

    public Field[][] getFields() {
        return fields;
    }

    public Field[][] getSolvedFields() {
        return solvedFields;
    }

    /**
     * 
     * @param row
     * @param column
     * @return The field at <code>[row][column]</code> or <code>null</code> if the
     *         row or column is inappropriate.
     */
    public Field getFieldAt(int row, int column) {
        if (indexInBoard(row) && indexInBoard(column)) {
            return fields[row][column];
        } else {
            return null;
        }
    }

    /**
     * 
     * @param row
     * @param column
     * @return The solved field at <code>[row][column]</code> or <code>null</code>
     *         if the row or column is inappropriate.
     */
    public Field getSolvedFieldAt(int row, int column) {
        if (indexInBoard(row) && indexInBoard(column)) {
            return solvedFields[row][column];
        } else {
            return null;
        }
    }

    public boolean setFieldAt(int row, int column, Field field) {
        if (indexInBoard(row) && indexInBoard(column)
                && (fields[row][column] == null || !fields[row][column].isInitial())) {
            fields[row][column] = field;
            return true;
        }
        return false;
    }

    protected void setIsSolved(boolean isSolved) {
        this.solved = isSolved;
    }

    protected void setSolvable(boolean isSolvable) {
        this.isSolvable = isSolvable;
    }

    // abstract methods

    /**
     * Checks if the <code>AbstactBoard</code> subtype is solved.
     * 
     * @return <code>true</code> if it is solved, else <code>false</code>.
     */
    public abstract boolean isSolved();

    public abstract void print();

    public abstract void printSolved();

    /**
     * Solved the <code>BasicBoard</code> subtype.
     */
    protected abstract void solve();

    /**
     * 
     * @return New subtype object of the class <code>Field</code> which is used in
     *         the <code>BasicBoard</code> subtype.
     */
    protected abstract Field newEmptyField();

    /**
     * @param rows
     * @param columns
     * @return New subtype array of the class <code>Field</code> which is used in
     *         the <code>BasicBoard</code> subtype.
     */
    protected abstract Field[][] newArray(int rows, int columns);

    /**
     * Generates a solvable <code>Field[][]</code> as <code>fields</code> with random values.
     */
    protected abstract void generateRandomFields();
}
package com.github.etienneZink.model.sudoku.framework.candidates.boards;

import java.io.Serializable;

import com.github.etienneZink.model.sudoku.framework.candidates.fields.Field;
import com.github.etienneZink.model.sudoku.framework.candidates.interfaces.FieldFactory;

/**
 * Abstract implementation of a basic game-board with the
 * <code>BOARD_SIZE</code>.
 */

public abstract class BasicBoard implements Serializable{

    private static final long serialVersionUID = 6535261797996973259L;

    public final int BOARD_SIZE;
    public final int BOARD_SIZE_ROOT;

    private boolean solved = false;
    private boolean isSolvable;

    private Field[][] fields;
    private Field[][] solvedFields;

    protected FieldFactory factory;

    public BasicBoard(Field[][] fields) {
        preInitialize();
        double BOARD_SIZE_ROOT = Math.sqrt(fields.length);

        if (BOARD_SIZE_ROOT == Math.floor(BOARD_SIZE_ROOT)) {
            this.BOARD_SIZE = fields.length;
            this.BOARD_SIZE_ROOT = (int) BOARD_SIZE_ROOT;
            this.fields = fields;
        } else {
            this.BOARD_SIZE = 9;
            this.BOARD_SIZE_ROOT = 3;
            this.fields = factory.emptyArray(BOARD_SIZE, BOARD_SIZE);
        }
        initialize();
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
     * Checks if the given <code>index</code> is appropriate for an
     * <code>array</code> with <code>length == BOARD_SIZE</code>.
     * 
     * @param index
     * @return <code>true</code> if <code>-1 < index < BOARD_SIZE</code>, else
     *         <code>false</code>.
     */
    protected boolean indexInBoard(int index) {
        return (-1 < index && index < BOARD_SIZE) ? true : false;
    }

    /**
     * Ckecks if the given legth is equal to the <code>BOARD_SIZE</code>.
     * 
     * @param lenght
     * @return <code>true</code> if <code>length == BOARD_SIZE</code>, else
     *         <code>false</code>.
     */
    protected boolean correctLenght(int lenght) {
        return (lenght == BOARD_SIZE) ? true : false;
    }

    protected void preInitialize() {
        setFactory();
    }

    /**
     * Initialize the <code>solvedSudoku</code>.
     */
    protected void initialize() {
        solve();
        solvedFields = getFieldsOf(fields);
        clear();
    }

    /**
     * Clears all <code>fields</code>, which aren't <code>initial</code>.
     */
    private void clear() {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (!fields[row][column].isInitial()) {
                        fields[row][column] = factory.emptyField();
                }
            }
        }

    }

    /**
     * 
     * @param originalFields
     * @return New instance of <code>SudokuField[][]</code> but with same
     *         <code>values</code> as <code>originalFields</code>.
     */
    private Field[][] getFieldsOf(Field[][] originalFields) {

        Field[][] tempSudoku = factory.emptyArray(BOARD_SIZE, BOARD_SIZE);
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
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (value == fields[row][column].getValue() && row != fieldRow) {
                return true;
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
        for (int column = 0; column < BOARD_SIZE; ++column) {
            if (value == fields[row][column].getValue() && column != fieldColumn) {
                return true;
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

        for (int tempRow = groupStartRow; tempRow < groupStartRow + BOARD_SIZE_ROOT; ++tempRow) {
            for (int tempColumn = groupStartColumn; tempColumn < groupStartColumn + BOARD_SIZE_ROOT; ++tempColumn) {
                if (value == fields[tempRow][tempColumn].getValue() && row != tempRow && column != tempColumn) {
                    return true;
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

    public Field getFieldAt(int row, int column) {
        return fields[row][column];
    }

    public Field getSolvedFieldAt(int row, int column) {
        return solvedFields[row][column];
    }

    public void setFieldAt(int row, int column, Field field) {
        if (indexInBoard(row) && indexInBoard(column)) {
            if (fields[row][column] == null) {
                fields[row][column] = field;
            } else {
                if (!fields[row][column].isInitial()) {
                    fields[row][column] = field;
                }
            }
        }
    }

    protected void setIsSolved(boolean isSolved) {
        this.solved = isSolved;
    }

    protected void setSolvable(boolean isSolvable) {
        this.isSolvable = isSolvable;
    }

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

    protected abstract void setFactory();
}
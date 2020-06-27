package com.github.etienneZink.model.sudoku.framework.candidates.fields;

import com.github.etienneZink.model.sudoku.framework.candidates.interfaces.FieldFactory;


public class SudokuFieldFactory implements FieldFactory{

    @Override
    public Field emptyField() {
        return new SudokuField();
    }

    public Field newField(int value) {
        return new SudokuField(value);
    }

    @Override
    public Field[][] emptyArray(int rows, int columns) {
        return new SudokuField[rows][columns];
    }
    
}
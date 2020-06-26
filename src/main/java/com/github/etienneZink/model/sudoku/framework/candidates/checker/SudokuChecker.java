package com.github.etienneZink.model.sudoku.framework.candidates.checker;

import com.github.etienneZink.model.sudoku.framework.candidates.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.Field;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.candidates.interfaces.Checker;

/**
 * Class to check if a ClassicSudoku is solved or not.
 * @see ClassicSudoku
 */
public class SudokuChecker implements Checker{

    private ClassicSudoku sudoku;

    // constructors

    public SudokuChecker(ClassicSudoku sudoku){
        this.sudoku = sudoku;
    }

    // non-static methods

    //TODO only works if SudokuField is changed to Field
    @Override
    public boolean isSolved(){
        SudokuField field;
        for(int row = 0; row < sudoku.BOARD_SIZE; ++row){
            for(int column = 0; column < sudoku.BOARD_SIZE; ++column){
                field = (SudokuField) sudoku.getFieldAt(row, column);
                if(field.isSet()){
                    if (sudoku.checkValue(row, column, field.getValue())){
                        return false;
                    }
                } else {
                    return false;
                }
            } 
        }
        return true;
    }
}
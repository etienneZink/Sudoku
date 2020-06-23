package model.sudokuFramework_Candidates.checker;

import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.fields.SudokuField;

public class SudokuChecker {

    private ClassicSudokuBoard sudoku;

    public SudokuChecker(ClassicSudokuBoard sudoku){
        this.sudoku = sudoku;
    }

    public boolean isSolved(){
        SudokuField field;
        for(int row = 0; row < sudoku.BOARD_SIZE; ++row){
            for(int column = 0; column < sudoku.BOARD_SIZE; ++column){
                field = sudoku.getFieldAt(row, column);
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
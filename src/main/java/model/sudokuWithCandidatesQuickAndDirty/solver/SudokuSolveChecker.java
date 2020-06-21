package model.sudokuWithCandidatesQuickAndDirty.solver;

import model.sudokuWithCandidatesQuickAndDirty.boards.ClassicSudokuBoard;
import model.sudokuWithCandidatesQuickAndDirty.fields.SudokuField;

public class SudokuSolveChecker {

    private ClassicSudokuBoard sudoku;

    public SudokuSolveChecker(ClassicSudokuBoard sudoku){
        this.sudoku = sudoku;
    }

    public boolean isSolved(){
        int value;
        SudokuField[][] board = sudoku.getBoard();
        for(int row = 0; row < sudoku.BOARD_SIZE; ++row){
            for(int column = 0; column < sudoku.BOARD_SIZE; ++column){
                value = board[row][column].getValue();
                if(value == -1){
                    return false;
                } else {
                    if (sudoku.inColumn(row, column, value) || sudoku.inRow(row, column, value) || sudoku.inGroup(row, column, value)){
                        return false;
                    }
                }
            } 
        }
        return true;
    }
}
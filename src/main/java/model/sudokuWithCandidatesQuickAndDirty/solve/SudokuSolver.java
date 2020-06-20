package model.sudokuWithCandidatesQuickAndDirty.solve;

import model.sudokuWithCandidatesQuickAndDirty.board.ClassicSudokuBoard;

public class SudokuSolver {

    ClassicSudokuBoard sudoku;
    
    public SudokuSolver(ClassicSudokuBoard sudoku){
        this.sudoku = sudoku;
    }

    public ClassicSudokuBoard solve(){
        while(!sudoku.isSolved()){
            solveSudoku();
        }

        return sudoku;
    }

    private void solveSudoku(){
        //TODO
    }


}
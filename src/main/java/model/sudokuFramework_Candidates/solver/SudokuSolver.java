package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.interfaces.Solver;

public class SudokuSolver implements Solver {

    private boolean successfullBuild = false;
    ClassicSudokuBoard sudoku;

    public SudokuSolver(AbstractBoard sudoku) {
        if(sudoku instanceof ClassicSudokuBoard){
            this.sudoku = (ClassicSudokuBoard) sudoku;
            successfullBuild = true;
        } 
    }

    @Override
    public boolean solve() {

        while (!sudoku.isSolved()) {
            solveSudoku();
        }

        return new SudokuSolveChecker(sudoku).isSolved();
    }

    public boolean isBuild(){
        return successfullBuild;
    }

    private void solveSudoku() {
        // TODO
    }

}
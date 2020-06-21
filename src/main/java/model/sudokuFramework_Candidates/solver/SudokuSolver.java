package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;

public class SudokuSolver extends AbstractSolver {

    
    ClassicSudokuBoard sudoku;

    public SudokuSolver(AbstractBoard sudoku) {
        if (sudoku instanceof ClassicSudokuBoard) {
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

    private void solveSudoku() {
        // TODO
    }

}
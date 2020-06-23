package model.sudokuFramework_Candidates.solver;

import java.util.ArrayList;
import java.util.List;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.checker.SudokuChecker;
import model.sudokuFramework_Candidates.fields.SudokuField;
import model.sudokuFramework_Candidates.interfaces.Solver;

public class SudokuSolver implements Solver {

    ClassicSudokuBoard sudoku;

    public SudokuSolver(AbstractBoard sudoku){
        if (sudoku instanceof ClassicSudokuBoard) {
            this.sudoku = (ClassicSudokuBoard) sudoku;
        }
    }

    @Override
    public boolean solve() {
        while (!sudoku.isSolved()) {
            solveSudoku();
        }
        return new SudokuChecker(sudoku).isSolved();
    }

    private void solveSudoku() {
        boolean somethingToChanged = false;
        SudokuField field;
        List<Integer> toRemove;
        SudokuField[][] board = sudoku.getBoard();

        for (int row = 0; row < sudoku.BOARD_SIZE; ++row) {
            for (int column = 0; column < sudoku.BOARD_SIZE; ++column) {
                field = board[row][column];

                if (!field.isSet()) {
                    toRemove = new ArrayList<Integer>();
                    for (int candidate : field.getCandidates()) {
                        if (sudoku.checkValue(row, column, candidate)) {
                            toRemove.add(candidate);
                        }
                    }
                    for (int candidateToRemove : toRemove) {
                        field.removeCandidate(candidateToRemove);
                        sudoku.setFieldAt(row, column, field);
                    }
                    somethingToChanged = true;
                }
            }
        }
        if (!somethingToChanged) {
            sudoku.solved();
        }
    }

}
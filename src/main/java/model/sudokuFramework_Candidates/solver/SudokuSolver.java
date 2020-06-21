package model.sudokuFramework_Candidates.solver;

import java.util.ArrayList;
import java.util.List;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.fields.SudokuField;

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
                        if (sudoku.inColumn(row, column, candidate) || sudoku.inRow(row, column, candidate)
                                || sudoku.inGroup(row, column, candidate)) {
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
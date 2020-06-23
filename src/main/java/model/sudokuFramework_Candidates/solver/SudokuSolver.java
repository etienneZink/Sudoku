package model.sudokuFramework_Candidates.solver;

import java.util.ArrayList;
import java.util.List;

import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.checker.SudokuChecker;
import model.sudokuFramework_Candidates.fields.SudokuField;
import model.sudokuFramework_Candidates.interfaces.Solver;

public class SudokuSolver implements Solver {

    ClassicSudokuBoard sudokuBoard;

    public SudokuSolver(ClassicSudokuBoard sudokuBoard){
            this.sudokuBoard = sudokuBoard;
    }

    @Override
    public boolean solve() {
        while (!sudokuBoard.isSolved()) {
            solveSudoku();
        }
        return new SudokuChecker(sudokuBoard).isSolved();
    }

    private void solveSudoku() {
        boolean somethingToChanged = false;
        SudokuField field;
        List<Integer> toRemove;

        for (int row = 0; row < sudokuBoard.BOARD_SIZE; ++row) {
            for (int column = 0; column < sudokuBoard.BOARD_SIZE; ++column) {
                field = sudokuBoard.getFieldAt(row, column);
                if (!field.isSet()) {
                    toRemove = new ArrayList<Integer>();
                    for (int candidate : field.getCandidates()) {
                        if (sudokuBoard.checkValue(row, column, candidate)) {
                            toRemove.add(candidate);
                        }
                    }
                    for (int candidateToRemove : toRemove) {
                        field.removeCandidate(candidateToRemove);
                        sudokuBoard.setFieldAt(row, column, field);
                    }
                    somethingToChanged = true;
                }
            }
        }
        if (!somethingToChanged) {
            sudokuBoard.solved();
        }
    }

}
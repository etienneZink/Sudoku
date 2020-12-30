package com.github.etienneZink.model.sudoku.framework.solver;

import java.util.ArrayList;
import java.util.Collections;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.interfaces.Solver;

/**
 * Backtracking algorithm which isn't deterministic, for sudoku. Would be a
 * little bit faster, if it would be deterministic. Beeing not deterministic is
 * essential for generating random fields.
 */
public final class SudokuSolverBacktracking implements Solver {

    private ClassicSudoku sudoku;

    public SudokuSolverBacktracking(ClassicSudoku sudoku) {
        this.sudoku = sudoku;
    }

    @Override
    public boolean solve() {
        solve(0, 0);
        return sudoku.isSolved();
    }
    
    private void solve(int row, int column) {
        // randomize the access of the values (impotant for generating random fields)
        ArrayList<Integer> possibleValues = new ArrayList<Integer>();
        for (int value = 1; value <= sudoku.BOARD_SIZE; ++value) {
            possibleValues.add(value);
        }
        Collections.shuffle(possibleValues);
        // if row and column are out of bounds, <code>getFieldAt</code> returns null ->
        // sudoku is at the end
        if (sudoku.getFieldAt(row, column) == null && sudoku.isSolved()) {
            return;
        } else {
            // if field is intial, it must be let out
            if (sudoku.getFieldAt(row, column).isSet()) {
                solve(newRow(row, column), newColumn(row, column));
            } else {
                // test all values for the field
                for (int value : possibleValues) {
                    if (!sudoku.checkValue(row, column, value)) {
                        sudoku.setFieldAt(row, column, new SudokuField(value));
                        solve(newRow(row, column), newColumn(row, column));
                        // return that the field isn't set to new SudokuField() when the sudoku is
                        // solved
                        if (sudoku.getSolved()) {
                            return;
                        }
                    }
                    sudoku.setFieldAt(row, column, new SudokuField());
                }
            }
        }

    }

    private int newRow(int row, int column) {
        return (column + 1 < sudoku.BOARD_SIZE) ? row : row + 1;
    }

    private int newColumn(int row, int column) {
        return (column + 1 < sudoku.BOARD_SIZE) ? column + 1 : 0;
    }
}
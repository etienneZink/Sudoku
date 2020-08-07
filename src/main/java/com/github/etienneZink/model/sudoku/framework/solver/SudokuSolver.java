package com.github.etienneZink.model.sudoku.framework.solver;

import java.util.HashSet;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.interfaces.Solver;

/**
 * Class which implements solver to solve a ClassicSudokuBoard.
 * 
 * @see ClassicSudoku
 */
public final class SudokuSolver implements Solver {

    ClassicSudoku sudoku;

    // constructors

    public SudokuSolver(ClassicSudoku sudoku) {
        this.sudoku = sudoku;
    }

    // non-static methods

    /**
     * Solve the given <code>ClassicSudoku</code>.
     * @return <code>True</code> if the <code>ClassicSudoku</code> was solved, else <code>false</code>.
     */
    @Override
    public boolean solve() {
            while (!sudoku.getSolved()) {
                if (!solveSudoku() && !sudoku.isSolved()) {
                    return false;
                }
            }
            return true;
    }

    /**
     * Inner implementation of <code>solve()</code>. Checks all fields of the
     * <code>ClassicSudoku</code>. If one isn't set, it iterates over the
     * <code>candidates</code> of the field. If one <code>candidate</code> is
     * already set in the <code>group/row/column</code>, it will be removed from the
     * <code>candidates</code>. If only one <code>candidate</code> is left, the
     * field will be <code>set</code> with the <code>value</code> of this
     * <code>candidate</code>.
     */
    private boolean solveSudoku() {
        SudokuField field;
        boolean somethingChanged = false;
        HashSet<Integer> toRemove;
        for (int row = 0; row < sudoku.BOARD_SIZE; ++row) {
            for (int column = 0; column < sudoku.BOARD_SIZE; ++column) {
                field = (SudokuField) sudoku.getFieldAt(row, column);
                if (!field.isSet()) {
                    toRemove = new HashSet<Integer>();
                    for (int candidate : field.getCandidates()) {
                        if (sudoku.checkValue(row, column, candidate)) {
                            toRemove.add(candidate);
                        }
                    }
                    field.getCandidates().removeAll(toRemove);
                    field.isToSet();
                    sudoku.setFieldAt(row, column, field);
                    somethingChanged = true;
                }
            }
        }
        return somethingChanged;
    }
}
package com.github.etienneZink.model.sudoku.framework.candidates.boards;

import java.io.Serializable;

import com.github.etienneZink.model.sudoku.framework.candidates.checker.SudokuChecker;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuInitialField;
import com.github.etienneZink.model.sudoku.framework.candidates.solver.SudokuSolver;

/**
 * Class that represents a classic sudoku game.
 */

// TODO Dokumentation überarbeiten
public final class ClassicSudoku extends BasicBoard<SudokuField> implements Serializable {

    private static final long serialVersionUID = 3947440594492979142L;

    // constructors

    @Deprecated
    public ClassicSudoku(int[][] values) {
        super();
        initialize(values);
    }

    public ClassicSudoku(SudokuField[][] fields) {
        super(fields);
    }

    // non-static methods

    @Override
    public void print() {
        int value;
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (row % BOARD_SIZE_ROOT == 0) {
                System.out.println("-------------------------------------------------");
            }
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (column % BOARD_SIZE_ROOT == 0) {
                    System.out.print("|");
                }
                System.out.print("  ");
                if ((value = getFieldAt(row, column).getValue()) == -1) {
                    System.out.print(" " + "  ");
                } else {
                    System.out.print(value + "  ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void printSolved() {
        int value;
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (row % BOARD_SIZE_ROOT == 0) {
                System.out.println("-------------------------------------------------");
            }
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (column % BOARD_SIZE_ROOT == 0) {
                    System.out.print("|");
                }
                System.out.print("  ");
                if ((value = getSolvedFieldAt(row, column).getValue()) == -1) {
                    System.out.print(" " + "  ");
                } else {
                    System.out.print(value + "  ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    /**
     * Solves the <code>ClassicSudoku</code> and <code>set</code> its
     * <code>sudoku</code> to the solved version of it, if it exists, and
     * <code>sets isSolvable</code>.
     */
    @Override
    protected void solve() {
        setSolvable(new SudokuSolver(this).solve());
    }

    /**
     * Checks if the <code>ClassicSudokuBoard</code> was solved.
     * 
     * @return <code>True</code> if the <code>ClassicSudokuBoard</code> is solved,
     *         else <code>false</code>.
     */
    @Override
    public boolean isSolved() {
        setIsSolved(new SudokuChecker(this).isSolved());
        return getSolved();
    }

    /**
     * Initialiez the <code>sudoku</code> with the given <code>values</code>.
     * 
     * @param values
     */

    @Deprecated
    private void initialize(int[][] values) {
        if (correctLenght(values.length)) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (correctLenght(values[row].length)) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        setFieldAt(row, column, new SudokuInitialField(values[row][column]));
                    }
                }
            }
        }
        initialize();
    }

}
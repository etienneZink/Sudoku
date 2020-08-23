package com.github.etienneZink.model.sudoku.framework.boards;

import com.github.etienneZink.model.sudoku.framework.checker.SudokuChecker;
import com.github.etienneZink.model.sudoku.framework.fields.Field;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuInitialField;
import com.github.etienneZink.model.sudoku.framework.solver.SudokuSolver;
import com.github.etienneZink.model.sudoku.framework.solver.SudokuSolverBacktracking;

/**
 * Class that represents a classic sudoku game.
 */

public final class ClassicSudoku extends BasicBoard {

    private static final long serialVersionUID = 3947440594492979142L;

    // constructors

    public ClassicSudoku(int BOARD_SIZE) {
        super(BOARD_SIZE);
    }

    public ClassicSudoku(SudokuField[][] fields) {
        super(fields);
    }

    // non-static methods

    @Override
    public void print() {
        printInConsole(getFields());
    }

    @Override
    public void printSolved() {
        printInConsole(getSolvedFields());
    }

    /**
     * Solves the <code>ClassicSudoku</code> and <code>set</code> its
     * <code>sudoku</code> to the solved version of it, if it exists, and
     * <code>sets isSolvable</code>.
     */
    @Override
    protected boolean solve() {
        return new SudokuSolver(this).solve();
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

    @Override
    protected Field newEmptyField() {
        return new SudokuField();
    }

    @Override
    protected Field newInitialField(Field field) {
        return new SudokuInitialField(field.getValue());
    }

    @Override
    protected Field[][] newArray(int rows, int columns) {
        return new SudokuField[rows][columns];
    }

    @Override
    protected void generateRandomFields() {
        new SudokuSolverBacktracking(this).solve();
    }

    protected void printInConsole(Field[][] fields){
        int value;
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (row % BOARD_SIZE_ROOT == 0) {
                for(int colums = 0; colums < BOARD_SIZE*6 + BOARD_SIZE_ROOT + 1; ++colums){
                    System.out.print("-");
                }
                System.out.println();
            }
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (column % BOARD_SIZE_ROOT == 0) {
                    System.out.print("|");
                }
                System.out.print("  ");
                if ((value = fields[row][column].getValue()) == -1) {
                    System.out.print("  " + "  ");
                } else {
                    if (value < 10) {
                        System.out.print(value + "   ");
                    } else {
                        System.out.print(value + "  ");
                    }
                }
            }
            System.out.print("|");
            System.out.println();
        }
        for(int colums = 0; colums < BOARD_SIZE*6 + BOARD_SIZE_ROOT + 1; ++colums){
            System.out.print("-");
        }
        System.out.println();
    }
}
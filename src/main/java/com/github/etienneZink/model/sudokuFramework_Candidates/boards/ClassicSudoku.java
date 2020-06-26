package com.github.etienneZink.model.sudokuFramework_Candidates.boards;

import java.util.Objects;

import com.github.etienneZink.model.sudokuFramework_Candidates.checker.SudokuChecker;
import com.github.etienneZink.model.sudokuFramework_Candidates.fields.SudokuField;
import com.github.etienneZink.model.sudokuFramework_Candidates.fields.SudokuInitialField;
import com.github.etienneZink.model.sudokuFramework_Candidates.solver.SudokuSolver;

/**
 * Class that represents a classic sudoku game.
 */

 //TODO Dokumentation überarbeiten
public final class ClassicSudoku extends BasicBoard {

    private SudokuField[][] sudoku = new SudokuField[BOARD_SIZE][BOARD_SIZE];
    private SudokuField[][] solvedSudoku;

    // constructors

    public ClassicSudoku(int[][] values){
        super(values.length);
        initialize(Objects.requireNonNull(values));
    }

    public ClassicSudoku(SudokuField[][] fields) {
        super(fields.length);
        sudoku = fields;
        initialize();
    }

    // non-static methods

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-column/row/group</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    public boolean checkValue(int row, int column, int value) {
        return (inRow(row, column, value) || inColumn(row, column, value) || inGroup(row, column, value));
    }

    public void print(SudokuField[][] sudoku) {
        int value;
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (row % 3 == 0) {
                System.out.println("-------------------------------------------------");
            }
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (column % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print("  ");
                if ((value = sudoku[row][column].getValue()) == -1) {
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
    protected void solve() {
        setSolvable(new SudokuSolver(this).solve());
    }

    /**
     * Checks if the <code>ClassicSudokuBoard</code> was solved.
     * 
     * @return <code>True</code> if the <code>ClassicSudokuBoard</code> is solved,
     *         else <code>false</code>.s
     */
    @Override
    public boolean isSolved() {
        setIsSolved(new SudokuChecker(this).isSolved());
        return getSolved();
    }

    private void initialize(){
        setSolvedSudoku();
    }

    // TODO lagere for schleifen und checks aus, sodass je nach param andere innere
    // Funtion ausgeführt wird

    /**
     * Initialiez the <code>sudoku</code> with the given <code>values</code>.
     * 
     * @param values
     */
    private void initialize(int[][] values) {
        if (correctLenght(values.length)) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (correctLenght(values[row].length)) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        sudoku[row][column] = new SudokuInitialField(values[row][column]);
                    }
                }
            }
        }
        initialize();
    }

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-column</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inColumn(int fieldRow, int column, int value) {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (value == sudoku[row][column].getValue() && row != fieldRow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-row</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inRow(int row, int fieldColumn, int value) {
        for (int column = 0; column < BOARD_SIZE; ++column) {
            if (value == sudoku[row][column].getValue() && column != fieldColumn) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the <code>value</code> is already set in the
     * <code>field-group</code>.
     * 
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inGroup(int row, int column, int value) {
        int groupStartRow = (row / 3) * 3;
        int groupStartColumn = (column / 3) * 3;

        for (int tempRow = groupStartRow; tempRow < groupStartRow + 3; ++tempRow) {
            for (int tempColumn = groupStartColumn; tempColumn < groupStartColumn + 3; ++tempColumn) {
                if (value == sudoku[tempRow][tempColumn].getValue() && row != tempRow && column != tempColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clears all <code>fields</code>, which aren't <code>initial</code>.
     */
    private void clear() {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                if (!sudoku[row][column].isInitial()) {
                    sudoku[row][column] = new SudokuField();
                }
            }
        }
    }

    private void setSolvedSudoku() {
        solve();
        solvedSudoku = getFieldsOf(sudoku);
        clear();
    }

    private SudokuField[][] getFieldsOf(SudokuField[][] originalSudoku) {
        SudokuField[][] tempSudoku = new SudokuField[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                tempSudoku[row][column] = originalSudoku[row][column];
            }
        }
        return tempSudoku;
    }

    // getter and setter

    public SudokuField[][] getSudoku() {
        return sudoku;
    }

    public SudokuField[][] getSolvedSudoku() {
        return solvedSudoku;
    }

    public SudokuField getFieldAt(int row, int column) {
        return sudoku[row][column];
    }

    public void setFieldAt(int row, int column, SudokuField field) {
        if (indexInBoard(row) && indexInBoard(column) && !sudoku[row][column].isInitial()) {
            sudoku[row][column] = field;
        }
    }
}
package model.sudokuFramework_Candidates.boards;

import java.util.Objects;

import model.sudokuFramework_Candidates.checker.SudokuChecker;
import model.sudokuFramework_Candidates.exceptions.NotBuildException;
import model.sudokuFramework_Candidates.fields.SudokuField;
import model.sudokuFramework_Candidates.fields.SudokuInitialField;
import model.sudokuFramework_Candidates.solver.SudokuSolver;

/**
 * Class that represents a classic sudoku game.
 */

public final class ClassicSudokuBoard extends BasicBoard {

    private SudokuField[][] board = new SudokuField[BOARD_SIZE][BOARD_SIZE];

    // constructors

    public ClassicSudokuBoard(int[][] values) throws NotBuildException {
        initialize(Objects.requireNonNull(values));
    }

    public ClassicSudokuBoard(SudokuField[][] fields) throws NotBuildException {
        initialize(Objects.requireNonNull(fields));
    }

    public ClassicSudokuBoard() {
        initialize();
    }

    // non-static methods

    /**
     * Checks if the <code>value</code> is already set in the <code>field-column/row/group</code>.
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    public boolean checkValue(int row, int column, int value) {
        return (inRow(row, column, value) || inColumn(row, column, value) || inGroup(row, column, value));
    }

    public void print() {
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
                if ((value = board[row][column].getValue()) == -1) {
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
    public void solve() {
        new SudokuSolver(this).solve();
    }

    // TODO lagere for schleifen und checks aus, sodass je nach param andere innere
    // Funtion ausgeführt wird

    /**
     * Initialiez the <code>board</code> with the given <code>values</code>.
     * @param values
     * @throws NotBuildException if the values were inappropriate.
     */
    private void initialize(int[][] values) throws NotBuildException {
        if (correctLenght(values.length)) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (correctLenght(values[row].length)) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        board[row][column] = new SudokuInitialField(values[row][column]);
                    }
                } else {
                    throw new NotBuildException();
                }
            }
        } else {
            throw new NotBuildException();
        }

    }

    /**
     * Initialiez the <code>board</code> with the given <code>values</code>.
     * @param values
     * @throws NotBuildException if the values were inappropriate.
     */
    private void initialize(SudokuField[][] values) throws NotBuildException {
        if (correctLenght(values.length)) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (correctLenght(values[row].length)) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        board[row][column] = values[row][column];
                    }
                } else {
                    throw new NotBuildException();
                }
            }
        } else {
            throw new NotBuildException();
        }

    }

    /**
     * Initialiez the <code>board</code> with empty <code>SudokuFields</code>.
     * @param values
     * @throws NotBuildException if the values were inappropriate.
     */
    private void initialize() {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                board[row][column] = new SudokuField();
            }
        }
    }


    /**
     * Checks if the <code>value</code> is already set in the <code>field-column</code>.
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inColumn(int fieldRow, int column, int value) {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (value == board[row][column].getValue() && row != fieldRow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the <code>value</code> is already set in the <code>field-row</code>.
     * @param row
     * @param column
     * @param value
     * @return <code>true</code> if it is already set, else <code>false</code>.
     */
    private boolean inRow(int row, int fieldColumn, int value) {
        for (int column = 0; column < BOARD_SIZE; ++column) {
            if (value == board[row][column].getValue() && column != fieldColumn) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the <code>value</code> is already set in the <code>field-group</code>.
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
                if (value == board[tempRow][tempColumn].getValue() && row != tempRow && column != tempColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    // getter and setter

    public SudokuField[][] getBoard() {
        return board;
    }

    public SudokuField getFieldAt(int row, int column) {
        return board[row][column];
    }

    @Override
    public boolean isSolved() {
        solved = new SudokuChecker(this).isSolved();
        return solved;
    }

    public void setFieldAt(int row, int column, SudokuField field) {
        if (indexInBoard(row) && indexInBoard(column) && !board[row][column].isInitial()) {
            board[row][column] = field;
        }
    }
}
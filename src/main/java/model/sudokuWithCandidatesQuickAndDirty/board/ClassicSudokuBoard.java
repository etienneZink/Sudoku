package model.sudokuWithCandidatesQuickAndDirty.board;

import java.io.Serializable;

import model.sudokuWithCandidatesQuickAndDirty.exceptions.WrongValueException;
import model.sudokuWithCandidatesQuickAndDirty.exceptions.FieldAlreadySetException;

//TODO Dokumentation

public class ClassicSudokuBoard implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1801731341833282685L;

    public static final int BOARD_SIZE = 9;

    private SudokuField[][] board;
    private boolean successfullBuild = false;
    private boolean solved = false;

    public ClassicSudokuBoard(int[][] values) {
        initialize(values);
    }

    public ClassicSudokuBoard(SudokuField[][] fields) {
        initialize(fields);
    }

    public boolean inColumn(int fieldRow, int column, int value) {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            if (value == board[row][column].getValue() && row != fieldRow) {
                return true;
            }
        }
        return false;
    }

    public boolean inRow(int row, int fieldColumn, int value) {
        for (int column = 0; column < BOARD_SIZE; ++column) {
            if (value == board[row][column].getValue() && column != fieldColumn) {
                return true;
            }
        }
        return false;
    }

    public boolean inGroup(int row, int column, int value) {
        int groupStartRow = (row / 3) * 3;
        int groupStartColumn = (column / 3) * 3;

        for (int tempRow = groupStartRow; tempRow < groupStartRow + 3; ++tempRow) {
            for (int tempColumn = groupStartColumn; tempColumn < groupStartColumn + 3; ++tempColumn) {
                if (value == board[tempRow + groupStartRow][tempColumn + groupStartColumn].getValue() && row != tempRow && column != tempColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print(){
        int value;
        for(int row = 0; row < BOARD_SIZE; ++row){
            for(int column = 0; column < BOARD_SIZE; ++column){
                if((value = board[row][column].getValue()) == -1){
                    System.out.print(" " + "     ");
                } else {
                    System.out.print(value + "     ");
                }
            }
            System.out.println();
        }
    }

    private void initialize(int[][] values) {
        board = new SudokuField[BOARD_SIZE][BOARD_SIZE];
        int value;
        if (values.length == BOARD_SIZE) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (values[row].length == BOARD_SIZE) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        value = values[row][column];
                        if (value == 0) {
                            board[row][column] = new SudokuField();
                        } else {
                            board[row][column] = new SudokuField(value);
                        }
                    }
                    successfullBuild = true;

                } else {
                    successfullBuild = false;
                    break;
                }
            }

        }

    }

    private void initialize(SudokuField[][] fields) {
        SudokuField field;

        if (fields.length == BOARD_SIZE) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (fields[row].length == BOARD_SIZE) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        field = fields[row][column];
                        if (field == null) {
                            board[row][column] = new SudokuField();
                        } else {
                            board[row][column] = field;
                        }
                    }
                    successfullBuild = true;

                } else {
                    successfullBuild = false;
                    break;
                }
            }

        }
    }

    private boolean indexInBoard(int value) {
        return (0 <= value && value < BOARD_SIZE) ? true : false;
    }

    private boolean isLegalValue(int value) {
        return (0 < value && value < 10) ? true : false;
    }

    public boolean isBuild() {
        return successfullBuild;
    }

    public SudokuField[][] getBoard() {
        return board;
    }

    public boolean isSolved() {
        return solved;
    }

    public void solved() {
        solved = true;
    }

    public void setFieldAt(int row, int column, int value) throws WrongValueException, FieldAlreadySetException {
        SudokuField field;
        if (indexInBoard(row) && indexInBoard(column)) {
            field = board[row][column];
            if (!field.isSet) {
                if (isLegalValue(value)) {
                    board[row][value] = new SudokuField(value);
                }
            } else {
                throw new FieldAlreadySetException();
            }
        } else {
            throw new WrongValueException();
        }

        // TODO Unterscheidung in exceptions
    }

}
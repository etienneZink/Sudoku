package model.sudokuFramework_Candidates.boards;

import java.io.Serializable;

import model.sudokuFramework_Candidates.exceptions.FieldAlreadySetException;
import model.sudokuFramework_Candidates.exceptions.WrongValueException;
import model.sudokuFramework_Candidates.fields.Field;
import model.sudokuFramework_Candidates.fields.SudokuField;
import model.sudokuFramework_Candidates.interfaces.FieldTypes;

//TODO Dokumentation

public final class ClassicSudokuBoard extends AbstractBoard implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1801731341833282685L;

    private SudokuField[][] board;

    public ClassicSudokuBoard(int[][] values) {
        initialize(values);
    }

    public ClassicSudokuBoard(SudokuField[][] fields) {
        initialize(fields);
    }

    public ClassicSudokuBoard(Field[][] fields) {
        if (fields instanceof SudokuField[][]){
        initialize((SudokuField[][]) fields);
        }
        
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
        if (values.length == BOARD_SIZE) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (values[row].length == BOARD_SIZE) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        board[row][column] = (SudokuField) factory.getInstance(FieldTypes.SudokuField, values[row][column]);
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
        if (fields.length == BOARD_SIZE) {
            for (int row = 0; row < BOARD_SIZE; ++row) {
                if (fields[row].length == BOARD_SIZE) {
                    for (int column = 0; column < BOARD_SIZE; ++column) {
                        board[row][column] = (SudokuField) factory.getInstance(FieldTypes.SudokuField, fields[row][column].getValue());
                    }
                    successfullBuild = true;

                } else {
                    successfullBuild = false;
                    break;
                }
            }

        }
    }

    public SudokuField[][] getBoard() {
        return board;
    }

    /**
     * Throws ArrayIndexOutOfBoundsException if row or column are inappropriate
     * 
     * @param row
     * @param column
     * @param value
     * @throws WrongValueException
     * @throws FieldAlreadySetException
     */
    public void setFieldAt(int row, int column, int value) throws WrongValueException, FieldAlreadySetException{
        SudokuField field;
        if (indexInBoard(row) && indexInBoard(column)) {
            field = board[row][column];
            if (!field.isSet()) {
                if (isLegalValue(value)) {
                    board[row][value] = (SudokuField) factory.getInstance(FieldTypes.SudokuField, value);
                } else {
                    throw new WrongValueException();
                }
            } else {
                throw new FieldAlreadySetException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

        // TODO Unterscheidung in exceptions
    }
}
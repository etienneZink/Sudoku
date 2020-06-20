package model.sudoku_Framework.classes;

import java.io.Serializable;

import model.sudoku_Framework.exceptions.NoSuitingArrayException;
import model.sudoku_Framework.exceptions.ValueNotSetException;
import model.sudoku_Framework.exceptions.WrongValueException;
import model.sudoku_Framework.interfaces.Factory;

/**
 * Serializable class to represent a classic sudoku field with immutable
 * <code>Cell</code> for inner structrue which is accessed threw
 * <code>ClassicFactory</code>.
 * 
 * @author Etienne Zink
 * @version 1.0
 * @see Cell
 * @see ClassicFactory
 */
public abstract class ClassicSudoku implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -8799226328944756150L;

    private static int SUDOKU_FIELD_SIZE = 9;

    /**
     * Represents the build-status: If the intended build run succesfully or failed.
     */
    private boolean successfullBuild;
    private Cell[][] sudokuField;
    private ClassicFactory factory = ClassicFactory.getFactory();

    // constructors

    public ClassicSudoku(){
        initialize();
    }

    public ClassicSudoku(int[][] inputArray){
        this();
        try {
            sudokuField = toCellArray(inputArray);
        } catch (Exception e) {
            successfullBuild = false;
            e.printStackTrace();
        }
    }

    public ClassicSudoku(Cell[][] inputArray){
        this();
        try {
            setSudokuField(inputArray);
        } catch (Exception e) {
            e.printStackTrace();
            successfullBuild = false;
        }
    }

    // static methods

    // non-static mathods

    public void print() {
        for(int row = 0; row < getSudokuFieldSize(); ++row){
            for(int column = 0; column < getSudokuFieldSize(); ++column){
                try {
                    System.out.print(getCellAt(row, column).getValue() + "     ");
                } catch (Exception e) {
                    System.out.print("" + "     ");
                }
            }
            System.out.println();
        }

    }

    /**
     * Initializes the sudokuField with <code>Cell</code> objects whit <code>ifSet = false</code> and sets <code>successfullBuild = true</code>.
     */
    private void initialize(){
        successfullBuild = true;
        sudokuField = new Cell[SUDOKU_FIELD_SIZE][SUDOKU_FIELD_SIZE];
        for(int row = 0; row < SUDOKU_FIELD_SIZE; ++row){
            for(int column  = 0; column < SUDOKU_FIELD_SIZE; ++column){
                sudokuField[row][column] = factory.getInstance();
            }
        }
    }

    /**
     * 
     * @param originalArray
     * @return 
     * @throws NoSuitingArrayException
     * @throws WrongValueException If there is a value in <code>originalArray</code> which isn't represented in the <code>HashMap</code> of ClassicFactory.
     */
    private Cell[][] toCellArray(int[][] originalArray) throws NoSuitingArrayException, WrongValueException {
        Cell[][] targetArray = new Cell[SUDOKU_FIELD_SIZE][SUDOKU_FIELD_SIZE];

        if (originalArray.length == SUDOKU_FIELD_SIZE) {
            for (int row = 0; row < originalArray.length; ++row) {
                if (originalArray[row].length == SUDOKU_FIELD_SIZE) {
                    for (int column = 0; column < originalArray[row].length; ++column) {
                        targetArray[row][column] = factory.getInstance(originalArray[row][column]);
                    }
                } else {
                    throw new NoSuitingArrayException();
                }

            }
        } else {
            throw new NoSuitingArrayException();
        }

        return targetArray;
    }

    // getter and setter

    public static int getSudokuFieldSize() {
        return SUDOKU_FIELD_SIZE;
    }

    /**
     * 
     * @param fieldSize
     * @throws WrongValueException if the <code>fieldSize</code> is inappropriat, has
     *                             no integer sqrRoot.
     */
    public static void setSudokuFieldSize(int fieldSize) throws WrongValueException {
        double sqrRoot = Math.sqrt(fieldSize);
        if (sqrRoot == Math.floor(sqrRoot)) {
            SUDOKU_FIELD_SIZE = (int) sqrRoot;
        } else {
            throw new WrongValueException();
        }
    }

    public boolean isSuccessfullBuild() {
        return successfullBuild;
    }

    public Cell[][] getSudokuField() {
        return sudokuField;
    }

    public Cell getCellAt(int row, int column){
        return sudokuField[row][column];
    }

    public int getValueAt(int row, int column) throws ValueNotSetException {
        return sudokuField[row][column].getValue();
    }

    public boolean getIsSetAt(int row, int column) {
        return sudokuField[row][column].getIsSet();
    }

    public void setValueAt(int row, int column, int value) throws WrongValueException {
        sudokuField[row][column] = factory.getInstance(value);
    }

    /**
     * 
     * @param originalArray
     * @throws NoSuitingArrayException If 
     */
    public void setSudokuField(Cell[][] originalArray) throws NoSuitingArrayException{
        Cell[][] targetArray = new Cell[SUDOKU_FIELD_SIZE][SUDOKU_FIELD_SIZE];
        successfullBuild = false;

        if (originalArray.length == SUDOKU_FIELD_SIZE) {
            for (int row = 0; row < originalArray.length; ++row) {
                if (originalArray[row].length == SUDOKU_FIELD_SIZE) {
                    for (int column = 0; column < originalArray[row].length; ++column) {
                        if(originalArray[row][column] == null){
                            targetArray[row][column] = factory.getInstance();
                        } else {
                            targetArray[row][column] = originalArray[row][column];
                        }
                        
                    }
                } else {
                    throw new NoSuitingArrayException();
                }

            }
        } else {
            throw new NoSuitingArrayException();
        }

        successfullBuild = true;
        sudokuField = targetArray;

    }

    public void setSudokuField(int[][] input) {
        try {
            sudokuField = toCellArray(input);
            successfullBuild = true;
        } catch (Exception e) {
            e.printStackTrace();
            successfullBuild = false;
        }

    }

    public Factory getFactory(){
        return factory;
    }
    
}
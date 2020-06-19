package model.sodukoFramework.classes;

import java.io.Serializable;

import model.sodukoFramework.exceptions.NoSquareArrayException;
import model.sodukoFramework.exceptions.ValueNotSetException;
import model.sodukoFramework.exceptions.WrongValueException;

/**
 * Serializable class to represent a sudokufield with immutable
 * <code>Cell</code> for inner structrue which is accessed threw <code>CellFactory</code>.
 * 
 * @author Etienne Zink
 * @version 1.0
 * @see Cell
 * @see CellFactory
 */
public class ClassicSudoku implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -2514791753861127039L;

    private boolean successfullBuild;
    private Cell[][] sudokuField; 
    private CellFactory factory = CellFactory.getFactory();


    // constructors

    public ClassicSudoku(Cell[][] sudokuField) {
        this.sudokuField = sudokuField;
        successfullBuild = true;
    }

    public ClassicSudoku(int[][] inputArray) {
        try {
            sudokuField = toCellArray(inputArray);
            successfullBuild = true;
        } catch (Exception e) {
            successfullBuild = false;
            e.printStackTrace();
        }

    }

    // static mathods

    // non-static methods

    private Cell[][] toCellArray(int[][] originalArray) throws NoSquareArrayException, WrongValueException{
        Cell[][] targetArray = new Cell[originalArray.length][originalArray.length];

        for(int row = 0; row < originalArray.length; ++row){
            for(int column = 0; column < originalArray[row].length; ++column){
                if(column > targetArray[row].length - 1){
                    throw new NoSquareArrayException();
                }
                targetArray[row][column] = factory.getInstance(originalArray[row][column]);
            }
        }

        return targetArray;
    }

    // getter and setter

    public boolean isSuccessfullBuild(){
        return successfullBuild;
    }

    public Cell[][] getSudokuField() {
        return sudokuField;
    }

    public int getValueAt(int row, int column) throws ValueNotSetException{
        return sudokuField[row][column].getValue();
    }

    public boolean getValueIsSet(int row, int column) {
        return sudokuField[row][column].getIsSet();
    }

    public void setValueAt(int row, int column, int value) throws WrongValueException{
       sudokuField[row][column] = factory.getInstance(value);
    }
    
    public void setSudokuField(Cell[][] inputArray){
        sudokuField = inputArray;
    }

    public void setSudokuField(int[][] input){
        try {
            sudokuField = toCellArray(input);
            successfullBuild = true;
        } catch (Exception e) {
            e.printStackTrace();
            successfullBuild = false;
        }
        
    }
}
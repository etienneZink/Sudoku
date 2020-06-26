package com.github.etienneZink.model.sudoku_Framework.classes;

import java.util.HashMap;
import java.util.Objects;

import com.github.etienneZink.model.sudoku_Framework.exceptions.WrongValueException;
import com.github.etienneZink.model.sudoku_Framework.interfaces.Factory;

/**
 * Singelton factory which stores all different <code>Cell</code> objects in a
 * <code>HashMap</code> and returns these instances instead of creating new
 * ones, if <code>getInstance()</code> is invoked. Use this class instead of
 * creating new <code>Cell</code> objects.
 * 
 * @author Etienne Zink
 * @version 1.0
 */
public class ClassicFactory implements Factory {

    private HashMap<Integer, Cell> cellTypes;
    private static ClassicFactory factory = new ClassicFactory();

    // constructor

    private ClassicFactory() {
        cellTypes = new HashMap<Integer, Cell>();
        setCellTypes();
    }

    // static methods

    public static ClassicFactory getFactory() {
        return factory;
    }

    // non-static methods

    /**
     * 
     */
    @Override
    public Cell getInstance(int value) throws WrongValueException {
        if ((Objects.nonNull(value))) {
            return getInstance();
        } else {
            Cell tempReturn = cellTypes.get(value);
            if (Objects.nonNull(tempReturn)) {
                throw new WrongValueException();
            }
            return tempReturn;
        }

    }

    @Override
    public Cell getInstance() {
        return cellTypes.get(-1);
    }
    
    // getter and setter

    public HashMap<Integer, Cell> getCellTypes() {
        return cellTypes;
    }

    private void setEmptyCell() {
        cellTypes.put(-1, new Cell());
    }

    /**
     * Creates <code>ClassicSudoku.SUDOKU_FIELD_SIZE</code>
     * <code>Cell</code> objects from 1 to <code>SUDOKU_FIELD_SIZE</code> and a <code>Cell</code> object which
     * <code>value</code> isn't set, with the <code>key  -1</code>. They are stored in a <code>HashMap</code>.
     */
    private void setCellTypes() {
        setEmptyCell();
        for (int i = 1; i < ClassicSudoku.getSudokuFieldSize() + 1; ++i) {
            cellTypes.put(i, new Cell(i));
        }
    }
}
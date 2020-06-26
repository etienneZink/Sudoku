package com.github.etienneZink.model.sudoku_Framework.interfaces;

import com.github.etienneZink.model.sudoku_Framework.classes.Cell;
import com.github.etienneZink.model.sudoku_Framework.exceptions.WrongValueException;

public interface Factory {
    public Cell getInstance();
    /**
     * 
     * @param value
     * @return Instance of <code>Cell</code> with the right value or an object with IsSet if the input is <code>null</code>.
     * @throws WrongValueException If the value doesn't exist in the <code>HashMap</code>.
     */
    public Cell getInstance(int value) throws WrongValueException;
}
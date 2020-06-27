package com.github.etienneZink.model.sudoku.framework.candidates.interfaces;

import com.github.etienneZink.model.sudoku.framework.candidates.fields.Field;

/**
 * Interface for <code>field subtype factory</code>. 
 */
public interface FieldFactory {

    public Field emptyField();
    
    public Field[][] emptyArray(int rows, int columns);
    
}
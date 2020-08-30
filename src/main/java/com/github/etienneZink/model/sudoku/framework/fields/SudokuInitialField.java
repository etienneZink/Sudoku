package com.github.etienneZink.model.sudoku.framework.fields;

/**
 * Class which represents the initial fields of a <code>ClassicSudoku</code>.
 * This class should only be used, to create the <code>Field[][]</code> for the
 * <code>ClassicSudoku</code>.
 * 
 * @see ClassicSudoku
 */
public final class SudokuInitialField extends SudokuField {

    private static final long serialVersionUID = -5736656543972666685L;

    // constructors

    public SudokuInitialField() {
        super();
    }

    public SudokuInitialField(int value) {
        super(value);
        if (isSet()) {
            setInitial();
        }
    }

}
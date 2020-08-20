package com.github.etienneZink.view;

import javax.swing.JTextField;

/**
 * Subclass of <code>JTextField</code> which saves its index in the gui. This is important for the model,
 * to set the value at the correct position.
 */
public class JSudokuTextField extends JTextField{

    /**
     *
     */
    private static final long serialVersionUID = 5901713222727174359L;

    private int indexRow;
    private int indexColumn;

    public JSudokuTextField(int indexRow, int indexColumn){
        super();
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
    }

    public int getIndexRow(){
        return indexRow;
    }

    public int getIndexColumn(){
        return indexColumn;
    }
}
package com.github.etienneZink.model.sudoku.framework.fields;

import java.io.Serializable;

/**
 * Class that represents a basic field in a game. <code>Static int BOARD_SIZE</code> must be set when 
 * creating a <code>BasicBoard</code> subtype object with <code>Field</code> object inside.
 */

public abstract class Field implements Serializable {

    private static final long serialVersionUID = -3783448412446847604L;

    protected static int BOARD_SIZE = 9;

    private int value;
    private boolean isSet = false;
    private boolean initialField = false;

    // constructors

    protected Field() {
        
    }

    protected Field(int value) {
        this.value = value;
        isSet = true;
    }

    // static method

    public static void setBOARD_SIZE(int value){
        BOARD_SIZE = value;
    }

    // getter and setter

    public boolean isSet() {
        return isSet;
    }

    /**
     * 
     * @return Value or -1 if isSet = false
     */
    public int getValue() {
        return isSet ? value : -1;
    }

    public boolean isInitial() {
        return initialField;
    }

    protected void setIsSet(boolean isSet) {
        this.isSet = isSet;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    protected void setInitial() {
        initialField = true;
    }
}

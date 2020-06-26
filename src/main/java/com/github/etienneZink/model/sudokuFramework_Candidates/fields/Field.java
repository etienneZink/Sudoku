package com.github.etienneZink.model.sudokuFramework_Candidates.fields;

import java.io.Serializable;

/**
 * Abstract class that represents a basic field in a game.
 */

public abstract class Field implements Serializable {

    private static final long serialVersionUID = -3783448412446847604L;

    private int value;
    private boolean isSet = false;
    private boolean initialField = false;

    // constructros

    protected Field() {

    }

    protected Field(int value) {
        this.value = value;
        isSet = true;
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

    protected void setInitial(){
        initialField = true;
    }
}
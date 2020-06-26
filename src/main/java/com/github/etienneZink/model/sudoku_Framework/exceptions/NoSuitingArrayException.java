package com.github.etienneZink.model.sudoku_Framework.exceptions;

public class NoSuitingArrayException extends Exception{
    
    /**
     *
     */
    private static final long serialVersionUID = 7381289471104584265L;

    @Override
    public String getMessage(){
        return "The array dosn't suite!";
    }
}
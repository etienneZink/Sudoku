package com.github.etienneZink.model.sudoku_Framework.exceptions;

public class WrongValueException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -1905238814976285241L;

    public WrongValueException(Exception e){
        super(e);
    }

    public WrongValueException(){
        super();
    }

    @Override
    public String getMessage(){
        return "You entered a wrong value!";
    }
    
}
package model.sudoku_Framework.exceptions;

public class ValueNotSetException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -5839110614422988L;

    @Override
    public String getMessage(){
        return "The value is not set!";
    }
    
}
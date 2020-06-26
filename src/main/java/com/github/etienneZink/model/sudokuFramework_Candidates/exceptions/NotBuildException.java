package com.github.etienneZink.model.sudokuFramework_Candidates.exceptions;

/**
 * Exception if the build of an <code>AbstractBoard</code> subtype did't work.
 * @see BasicBoard
 */
public class NotBuildException extends Exception{

    private static final long serialVersionUID = 4952668225742420679L;

    public NotBuildException(){
        super();
    } 

    public NotBuildException(String text){
        super(text);
    }
    
}
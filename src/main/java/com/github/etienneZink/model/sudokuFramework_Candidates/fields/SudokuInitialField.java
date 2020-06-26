package com.github.etienneZink.model.sudokuFramework_Candidates.fields;

public class SudokuInitialField extends SudokuField{

    private static final long serialVersionUID = -5736656543972666685L;

    public SudokuInitialField(int value){
        super(value);
        if(isSet()){
            setInitial();
        }
    }
    
}
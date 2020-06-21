package model.sudokuFramework_Candidates.fields;

import java.io.Serializable;

//TODO Dokumetation

public abstract class Field implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -3783448412446847604L;

    protected int value;
    protected boolean isSet = false;

    protected Field(){
        
    }

    protected Field(int value){
        this.value = value;
        isSet = true;
    }

    public boolean isSet(){
        return isSet;
    }

    /**
     * 
     * @return Value or -1 if isSet = false
     */
    public int getValue(){
        return isSet? value: -1; 
    }
}
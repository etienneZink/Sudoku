package model.sodukoFramework.exceptions;

public class WrongValueException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -1905238814976285241L;

    @Override
    public String getMessage(){
        return "The value isn't represented in the HashMap of the factory";
    }
    
}
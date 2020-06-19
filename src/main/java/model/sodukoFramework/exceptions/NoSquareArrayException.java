package model.sodukoFramework.exceptions;

public class NoSquareArrayException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 7539608547849440637L;

    @Override
    public String getMessage(){
        return "The array is not a square!";
    }
}
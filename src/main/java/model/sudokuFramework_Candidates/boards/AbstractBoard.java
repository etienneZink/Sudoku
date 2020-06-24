package model.sudokuFramework_Candidates.boards;


//TODO Dokumentation

public abstract class AbstractBoard {

    public final int BOARD_SIZE = 9;

    /**
     * Needs to be checked before working with a board.
     */
    protected boolean solved = false;

    protected boolean indexInBoard(int value) {
        return (-1 < value && value < BOARD_SIZE) ? true : false;
    }

    protected boolean correctLenght(int lenght){
        return (lenght == BOARD_SIZE)? true: false;
    }

    public abstract boolean isSolved();

    public abstract boolean solve();

    public void solved(){
        solved = true;
    }
    
}
package com.github.etienneZink.model.sudokuFramework_Candidates.boards;


/**
 * Abstract implementation of a basic game-board with the <code>BOARD_SIZE</code>.
 */

public abstract class BasicBoard {

    public final int BOARD_SIZE;

    protected boolean solved = false;
    private boolean isSolvable;

    public BasicBoard(int BOARD_SIZE){
        this.BOARD_SIZE = BOARD_SIZE;
    }

    /**
     * Checks if the given <code>index</code> is appropriate for an <code>array</code> with <code>length == BOARD_SIZE</code>.
     * @param index
     * @return <code>true</code> if <code>-1 < index < BOARD_SIZE</code>, else <code>false</code>.
     */
    protected boolean indexInBoard(int index) {
        return (-1 < index && index < BOARD_SIZE) ? true : false;
    }

    /**
     * Ckecks if the given legth is equal to the <code>BOARD_SIZE</code>.
     * @param lenght
     * @return <code>true</code> if <code>length == BOARD_SIZE</code>, else <code>false</code>.
     */
    protected boolean correctLenght(int lenght){
        return (lenght == BOARD_SIZE)? true: false;
    }

    /**
     * Checks if the <code>AbstactBoard</code> subtype is solved.
     * @return <code>true</code> if it is solved, else <code>false</code>.
     */
    public abstract boolean isSolved();

    /**
     * Solved the <code>BasicBoard</code> subtype.
     */
    public abstract void solve();
    
}
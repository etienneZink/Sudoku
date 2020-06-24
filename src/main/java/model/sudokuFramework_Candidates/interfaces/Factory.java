package model.sudokuFramework_Candidates.interfaces;

import model.sudokuFramework_Candidates.boards.BasicBoard;

public interface Factory {
    /**
     * 
     * @param board
     * @return <code>Solver</code> or subtype based on the <code>board</code>
     */
    public Solver getInstance(BasicBoard board);
}
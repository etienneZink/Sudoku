package model.sudokuFramework_Candidates.interfaces;

import model.sudokuFramework_Candidates.boards.AbstractBoard;

public interface Factory {
    public Solver getInstance(AbstractBoard board);
}
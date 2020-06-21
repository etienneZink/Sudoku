package model.sudokuFramework_Candidates.interfaces;

import model.sudokuFramework_Candidates.boards.AbstractBoard;

public interface SolverFactoryInterface {
    public Solver getInstance(FieldTypes type, AbstractBoard board);
}
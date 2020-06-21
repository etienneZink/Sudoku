package model.sudokuWithCandidatesQuickAndDirty.interfaces;

import model.sudokuWithCandidatesQuickAndDirty.boards.AbstractBoard;

public interface SolverFactoryInterface {
    public Solver getInstance(FieldTypes type, AbstractBoard board);
}
package model.sudokuFramework_Candidates.interfaces;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.solver.AbstractSolver;

public interface SolverFactoryInterface {
    public AbstractSolver getInstance(FieldTypes type, AbstractBoard board);
}
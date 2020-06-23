package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.interfaces.Solver;

public abstract class AbstractSolver implements Solver {

    @Override
    public abstract boolean solve();

    protected abstract AbstractSolver getInstance(AbstractBoard board);
    
}
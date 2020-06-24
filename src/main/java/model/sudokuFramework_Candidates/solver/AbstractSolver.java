package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.BasicBoard;
import model.sudokuFramework_Candidates.interfaces.Solver;

public abstract class AbstractSolver implements Solver {

    @Override
    public abstract void solve();

    protected abstract AbstractSolver getInstance(BasicBoard board);
    
}
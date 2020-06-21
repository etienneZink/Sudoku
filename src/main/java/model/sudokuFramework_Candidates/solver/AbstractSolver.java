package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.interfaces.Solver;

public abstract class AbstractSolver implements Solver{

    /**
     * Needs to be checked before working with Solver.
     */
    protected boolean successfullBuild = false;

    @Override
    public abstract boolean solve();
    
    public boolean isBuild() {
        return successfullBuild;
    }
}
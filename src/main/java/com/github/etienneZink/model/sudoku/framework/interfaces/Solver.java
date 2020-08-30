package com.github.etienneZink.model.sudoku.framework.interfaces;


public interface Solver {
    /**
     * Solve the given <code>BasicBoard</code> or subtype.
     */
    public boolean solve();
}
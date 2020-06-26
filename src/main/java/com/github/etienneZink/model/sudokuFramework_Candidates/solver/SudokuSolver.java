package com.github.etienneZink.model.sudokuFramework_Candidates.solver;

import java.util.HashSet;

import com.github.etienneZink.model.sudokuFramework_Candidates.boards.ClassicSudoku;
import com.github.etienneZink.model.sudokuFramework_Candidates.exceptions.NotSolvableException;
import com.github.etienneZink.model.sudokuFramework_Candidates.fields.SudokuField;
import com.github.etienneZink.model.sudokuFramework_Candidates.interfaces.Solver;

/**
 * Class which implements solver to solve a ClassicSudokuBoard.
 * @see ClassicSudoku
 */
public class SudokuSolver implements Solver {

    ClassicSudoku sudokuBoard;

    // constructors

    public SudokuSolver(ClassicSudoku sudokuBoard){
            this.sudokuBoard = sudokuBoard;
    }

    // non-static methods

    /**
     * Solve the given <code>ClassicSudokuBoard</code>.
     * Throws <code>NotSolvableException</code> if the sudoku is unsolvable. 
     */
    @Override
    public void solve() {
        clear();
        while (!sudokuBoard.getSolved()) {
            if(!solveSudoku() && !sudokuBoard.isSolved()){
                throw new NotSolvableException();
            }
        }
    }

    /**
     * Inner implementation of <code>solve()</code>. 
     * Checks all fields of the <code>ClassicSudokuBoard</code>. If one isn't set, it iterates over the <code>candidates</code> of the field.
     * If one <code>candidate</code> is already set in the <code>group/row/column</code>, it will be removed from the <code>candidates</code>. 
     * If only one <code>candidate</code> is left, the field will be <code>set</code> with the <code>value</code> of this <code>candidate</code>. 
     */
    private boolean solveSudoku() {
        SudokuField field;
        boolean somethingChanged = false;
        HashSet<Integer> toRemove;
        for (int row = 0; row < sudokuBoard.BOARD_SIZE; ++row) {
            for (int column = 0; column < sudokuBoard.BOARD_SIZE; ++column) {
                field = sudokuBoard.getFieldAt(row, column);
                if (!field.isSet()) {
                    toRemove = new HashSet<Integer>();
                    for (int candidate : field.getCandidates()) {
                        if (sudokuBoard.checkValue(row, column, candidate)) {
                            toRemove.add(candidate);
                        }
                    }
                    field.getCandidates().removeAll(toRemove);
                    field.isToSet();
                    sudokuBoard.setFieldAt(row, column, field);
                    somethingChanged = true;
                }
            }
        }
        return somethingChanged;
    }

    /**
     * Clears all <code>fields</code>, which aren't <code>initial</code>.
     */
    private void clear(){
        for(int row = 0; row < sudokuBoard.BOARD_SIZE; ++row){
            for(int column = 0; column < sudokuBoard.BOARD_SIZE; ++column){
                if(!sudokuBoard.getFieldAt(row, column).isInitial()){
                    sudokuBoard.setFieldAt(row, column, new SudokuField());
                }
            }
        }
    }

}
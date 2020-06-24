package model.sudokuFramework_Candidates.solver;

import java.util.ArrayList;
import java.util.List;

import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.exceptions.NotSolvableException;
import model.sudokuFramework_Candidates.fields.SudokuField;
import model.sudokuFramework_Candidates.interfaces.Solver;

/**
 * Class which implements solver to solve a ClassicSudokuBoard.
 * @see ClassicSudokuBoard
 */
public class SudokuSolver implements Solver {

    ClassicSudokuBoard sudokuBoard;

    // constructors

    public SudokuSolver(ClassicSudokuBoard sudokuBoard){
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
        while (!sudokuBoard.isSolved()) {
            if(!solveSudoku()){
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
        List<Integer> toRemove;
        for (int row = 0; row < sudokuBoard.BOARD_SIZE; ++row) {
            for (int column = 0; column < sudokuBoard.BOARD_SIZE; ++column) {
                field = sudokuBoard.getFieldAt(row, column);
                if (!field.isSet()) {
                    toRemove = new ArrayList<Integer>();
                    for (int candidate : field.getCandidates()) {
                        if (sudokuBoard.checkValue(row, column, candidate)) {
                            toRemove.add(candidate);
                        }
                    }
                    for (int candidateToRemove : toRemove) {
                        field.removeCandidate(candidateToRemove);
                        sudokuBoard.setFieldAt(row, column, field);
                    }
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
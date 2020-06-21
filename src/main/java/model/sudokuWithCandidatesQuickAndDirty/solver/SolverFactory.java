package model.sudokuWithCandidatesQuickAndDirty.solver;

import model.sudokuWithCandidatesQuickAndDirty.boards.AbstractBoard;
import model.sudokuWithCandidatesQuickAndDirty.interfaces.FieldTypes;
import model.sudokuWithCandidatesQuickAndDirty.interfaces.Solver;
import model.sudokuWithCandidatesQuickAndDirty.interfaces.SolverFactoryInterface;

//TODO Dokumentation Singelton

public class SolverFactory implements SolverFactoryInterface {

    private static SolverFactory factory = new SolverFactory();

    public static SolverFactory get(){
        return factory;
    }

    @Override
    public Solver getInstance(FieldTypes type, AbstractBoard board) {
        switch (type) {
            case SudokuField:
                return new SudokuSolver(board);
        
            default:
                return null;
        }
    }

    
}
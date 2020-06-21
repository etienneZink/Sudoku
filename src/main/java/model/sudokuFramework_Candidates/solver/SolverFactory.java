package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.interfaces.FieldTypes;
import model.sudokuFramework_Candidates.interfaces.SolverFactoryInterface;

//TODO Dokumentation Singelton

public class SolverFactory implements SolverFactoryInterface {

    private static SolverFactory factory = new SolverFactory();

    public static SolverFactory get(){
        return factory;
    }

    @Override
    public AbstractSolver getInstance(FieldTypes type, AbstractBoard board) {
        switch (type) {
            case SudokuField:
                return new SudokuSolver(board);
            default:
                return null;
        }
    }

    
}
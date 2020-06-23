package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.interfaces.Factory;

//TODO Dokumentation Singelton

public class SolverFactory implements Factory {

    private static SolverFactory factory = new SolverFactory();

    public static SolverFactory get(){
        return factory;
    }

    @Override
    public AbstractSolver getInstance(AbstractBoard board) {

        if(board instanceof ClassicSudokuBoard){
            return new SudokuSolver(board);
        } else {
            return null;
        }
    }

    
}
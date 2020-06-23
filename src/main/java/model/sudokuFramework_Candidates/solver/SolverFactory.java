package model.sudokuFramework_Candidates.solver;

import model.sudokuFramework_Candidates.boards.AbstractBoard;
import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.interfaces.Factory;
import model.sudokuFramework_Candidates.interfaces.Solver;

//TODO Dokumentation Singelton

public class SolverFactory implements Factory {

    private static SolverFactory factory = new SolverFactory();

    public static SolverFactory get(){
        return factory;
    }

    @Override
    public Solver getInstance(AbstractBoard board) {
        //TODO switch on types -> polymorthism?? usage?? 

        if(board instanceof ClassicSudokuBoard){
            return new SudokuSolver((ClassicSudokuBoard)board);
        } else {
            return null;
        }
    }

    
}
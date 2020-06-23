package sudoku;

import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.checker.SudokuChecker;
import model.sudokuFramework_Candidates.interfaces.Solver;
import model.sudokuFramework_Candidates.solver.SolverFactory;

public class SolveCheck {

    private int[][] sudokuToSolve = new int[9][9];
    private ClassicSudokuBoard board;
    private Solver solver;

    private SolveCheck(){

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                sudokuToSolve[i][j] = 0;
            }
        }
        sudokuToSolve[0][1] = 4;
        sudokuToSolve[0][7] = 7;

        sudokuToSolve[1][0] = 9;
        sudokuToSolve[1][2] = 6;
        sudokuToSolve[1][4] = 7;
        sudokuToSolve[1][6] = 1;
        sudokuToSolve[1][8] = 4;

        sudokuToSolve[2][1] = 1;
        sudokuToSolve[2][3] = 8;
        sudokuToSolve[2][5] = 5;
        sudokuToSolve[2][7] = 9;

        sudokuToSolve[3][2] = 9;
        sudokuToSolve[3][3] = 3;
        sudokuToSolve[3][5] = 7;
        sudokuToSolve[3][6] = 6;

        sudokuToSolve[4][1] = 7;
        sudokuToSolve[4][7] = 2;

        sudokuToSolve[5][2] = 4;
        sudokuToSolve[5][3] = 5;
        sudokuToSolve[5][5] = 6;
        sudokuToSolve[5][6] = 7;

        sudokuToSolve[6][1] = 9;
        sudokuToSolve[6][3] = 6;
        sudokuToSolve[6][5] = 2;
        sudokuToSolve[6][7] = 5;

        sudokuToSolve[7][0] = 5;
        sudokuToSolve[7][2] = 1;
        sudokuToSolve[7][4] = 9;
        sudokuToSolve[7][6] = 2;
        sudokuToSolve[7][8] = 8;

        sudokuToSolve[8][1] = 2;
        sudokuToSolve[8][7] = 6;
        
        try {
            board = new ClassicSudokuBoard(sudokuToSolve);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        solver = SolverFactory.get().getInstance(board);

    }
    public static void main(String[] args) {
       SolveCheck check = new SolveCheck();
       System.out.println("Sudoku to solve:");
        check.board.print();
        final long startTime = System.currentTimeMillis();
        check.solver.solve();
        final long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Sudoku solved:");
        check.board.print();
        SudokuChecker checker = new SudokuChecker(check.board);
        System.out.println("Is solved? " + checker.isSolved());
        System.out.println("Solved in " + duration + "ms");
        
    }
}
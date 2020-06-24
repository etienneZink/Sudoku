package sudoku;

import model.sudokuFramework_Candidates.boards.ClassicSudokuBoard;
import model.sudokuFramework_Candidates.checker.SudokuChecker;
import model.sudokuFramework_Candidates.exceptions.NotBuildException;

public class SolveCheck {

    private int[][] sudokuToSolve = new int[9][9];
    private int[][] sudokuToSolve2 = { { 0, 0, 3, 0, 2, 0, 6, 0, 0 }, { 9, 0, 0, 3, 0, 5, 0, 0, 1 },
            { 0, 0, 1, 8, 0, 6, 4, 0, 0 }, { 0, 0, 8, 1, 0, 2, 9, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 8 },
            { 0, 0, 6, 7, 0, 8, 2, 0, 0 }, { 0, 0, 2, 6, 0, 9, 5, 0, 0 }, { 8, 0, 0, 2, 0, 3, 0, 0, 9 },
            { 0, 0, 5, 0, 1, 0, 3, 0, 0 } };
    private ClassicSudokuBoard board;

    private SolveCheck() {

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
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
    }

    public static void main(String[] args) {
        SolveCheck sudokuGame = new SolveCheck();
        System.out.println("Sudoku to solve:");
        sudokuGame.board.print();
        long startTime = System.currentTimeMillis();
        sudokuGame.board.solve();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Sudoku solved:");
        sudokuGame.board.print();
        SudokuChecker checker = new SudokuChecker(sudokuGame.board);
        System.out.println("Is solved? " + checker.isSolved());
        System.out.println("Solved in " + duration + "ms");

        System.out.println("Sudoku to solve:");
        try {
            sudokuGame.board = new ClassicSudokuBoard(sudokuGame.sudokuToSolve2);
        } catch (NotBuildException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sudokuGame.board.print();
        startTime = System.currentTimeMillis();
        sudokuGame.board.solve();
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Sudoku solved:");
        sudokuGame.board.print();
        checker = new SudokuChecker(sudokuGame.board);
        System.out.println("Is solved? " + checker.isSolved());
        System.out.println("Solved in " + duration + "ms");
        
    }
}
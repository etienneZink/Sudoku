package sudoku;

import com.github.etienneZink.model.sudoku.framework.candidates.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.candidates.checker.SudokuChecker;

public class SolveCheck {

    private int[][] sudokuToSolve = new int[9][9];
    private int[][] sudokuToSolve2 = 
    
    { { 0, 0, 3, 0, 2, 0, 6, 0, 0 }, { 9, 0, 0, 3, 0, 5, 0, 0, 1 },
            { 0, 0, 1, 8, 0, 6, 4, 0, 0 }, { 0, 0, 8, 1, 0, 2, 9, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 8 },
            { 0, 0, 6, 7, 0, 8, 2, 0, 0 }, { 0, 0, 2, 6, 0, 9, 5, 0, 0 }, { 8, 0, 0, 2, 0, 3, 0, 0, 9 },
            { 0, 0, 5, 0, 1, 0, 3, 0, 0 } };
            
    private ClassicSudoku board;

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
            board = new ClassicSudoku(sudokuToSolve);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        SolveCheck sudokuGame = new SolveCheck();
        long endTime = System.currentTimeMillis();

        System.out.println("Sudoku to solve:");

        sudokuGame.board.print();   

        long duration = endTime - startTime;
        System.out.println("Sudoku solved:");

        sudokuGame.board.printSolved();

        //SudokuChecker checker = new SudokuChecker(sudokuGame.board);
        System.out.println("Is solved? " + sudokuGame.board.isSolved());
        System.out.println("Solved in " + duration + "ms");

        System.out.println("Sudoku to solve:");

        sudokuGame.board.print();

        startTime = System.currentTimeMillis();
        sudokuGame.board = new ClassicSudoku(sudokuGame.sudokuToSolve2);
        endTime = System.currentTimeMillis();

        duration = endTime - startTime;
        System.out.println("Sudoku solved:");

        sudokuGame.board.printSolved();

        //checker = new SudokuChecker(sudokuGame.board);
        System.out.println("Is solved? " + sudokuGame.board.isSolved());
        System.out.println("Solved in " + duration + "ms");
        
    }
}
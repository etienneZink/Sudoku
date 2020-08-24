package com.github.etienneZink.model.sudoku.framework.solverTest;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.solver.SudokuSolver;

public class RandomFields {
    public static void main(String[] args) {
        ClassicSudoku sudoku = new ClassicSudoku(9);
        sudoku.print();
        sudoku.printSolved();
        System.out.println("Is solvable: " + sudoku.isSolvable());
        new SudokuSolver(sudoku).solve();
        sudoku.print();
        System.out.println("Is solved: " + sudoku.isSolved());
    }
}
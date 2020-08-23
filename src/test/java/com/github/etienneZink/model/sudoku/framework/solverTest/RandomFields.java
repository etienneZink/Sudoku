package com.github.etienneZink.model.sudoku.framework.solverTest;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;

public class RandomFields {
    public static void main(String[] args) {
        //TODO
        ClassicSudoku sudoku = new ClassicSudoku();
        sudoku.print();
        sudoku.printSolved();
        System.out.println("Is solvable: " + sudoku.isSolvable());
        //sudoku.solve();
        sudoku.print();
        System.out.println("Is solved: " + sudoku.isSolved());
    }
}
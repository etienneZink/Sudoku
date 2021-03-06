package com.github.etienneZink.model.sudoku.framework.solverTest;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuInitialField;
import com.github.etienneZink.model.sudoku.framework.solver.SudokuSolverBacktracking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuSolveTest {

        public ClassicSudoku sudoku;
        public SudokuField[][] sudokuToSolve =

                        { { new SudokuInitialField(0), new SudokuInitialField(0), new SudokuInitialField(3),
                                        new SudokuInitialField(0), new SudokuInitialField(2), new SudokuInitialField(0),
                                        new SudokuInitialField(6), new SudokuInitialField(0),
                                        new SudokuInitialField(0) },
                                        { new SudokuInitialField(9), new SudokuInitialField(0),
                                                        new SudokuInitialField(0), new SudokuInitialField(3),
                                                        new SudokuInitialField(0), new SudokuInitialField(5),
                                                        new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(1) },
                                        { new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(1), new SudokuInitialField(8),
                                                        new SudokuInitialField(0), new SudokuInitialField(6),
                                                        new SudokuInitialField(4), new SudokuInitialField(0),
                                                        new SudokuInitialField(0) },
                                        { new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(8), new SudokuInitialField(1),
                                                        new SudokuInitialField(0), new SudokuInitialField(2),
                                                        new SudokuInitialField(9), new SudokuInitialField(0),
                                                        new SudokuInitialField(0) },
                                        { new SudokuInitialField(7), new SudokuInitialField(0),
                                                        new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(8) },
                                        { new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(6), new SudokuInitialField(7),
                                                        new SudokuInitialField(0), new SudokuInitialField(8),
                                                        new SudokuInitialField(2), new SudokuInitialField(0),
                                                        new SudokuInitialField(0) },
                                        { new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(2), new SudokuInitialField(6),
                                                        new SudokuInitialField(0), new SudokuInitialField(9),
                                                        new SudokuInitialField(5), new SudokuInitialField(0),
                                                        new SudokuInitialField(0) },
                                        { new SudokuInitialField(8), new SudokuInitialField(0),
                                                        new SudokuInitialField(0), new SudokuInitialField(2),
                                                        new SudokuInitialField(0), new SudokuInitialField(3),
                                                        new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(9) },
                                        { new SudokuInitialField(0), new SudokuInitialField(0),
                                                        new SudokuInitialField(5), new SudokuInitialField(0),
                                                        new SudokuInitialField(1), new SudokuInitialField(0),
                                                        new SudokuInitialField(3), new SudokuInitialField(0),
                                                        new SudokuInitialField(0) } };

        public SudokuField[][] solvedSudoku = { { new SudokuInitialField(4), new SudokuInitialField(8), new SudokuInitialField(3),
                new SudokuInitialField(9), new SudokuInitialField(2), new SudokuInitialField(1),
                new SudokuInitialField(6), new SudokuInitialField(5),
                new SudokuInitialField(7) },
                { new SudokuInitialField(9), new SudokuInitialField(6),
                                new SudokuInitialField(7), new SudokuInitialField(3),
                                new SudokuInitialField(4), new SudokuInitialField(5),
                                new SudokuInitialField(8), new SudokuInitialField(2),
                                new SudokuInitialField(1) },
                { new SudokuInitialField(2), new SudokuInitialField(5),
                                new SudokuInitialField(1), new SudokuInitialField(8),
                                new SudokuInitialField(7), new SudokuInitialField(6),
                                new SudokuInitialField(4), new SudokuInitialField(9),
                                new SudokuInitialField(3) }, 
                { new SudokuInitialField(5), new SudokuInitialField(4),
                                new SudokuInitialField(8), new SudokuInitialField(1),
                                new SudokuInitialField(3), new SudokuInitialField(2),
                                new SudokuInitialField(9), new SudokuInitialField(7),
                                new SudokuInitialField(6) },
                { new SudokuInitialField(7), new SudokuInitialField(2),
                                new SudokuInitialField(9), new SudokuInitialField(5),
                                new SudokuInitialField(6), new SudokuInitialField(4),
                                new SudokuInitialField(1), new SudokuInitialField(3),
                                new SudokuInitialField(8) },
                { new SudokuInitialField(1), new SudokuInitialField(3),
                                new SudokuInitialField(6), new SudokuInitialField(7),
                                new SudokuInitialField(9), new SudokuInitialField(8),
                                new SudokuInitialField(2), new SudokuInitialField(4),
                                new SudokuInitialField(5) },
                { new SudokuInitialField(3), new SudokuInitialField(7),
                                new SudokuInitialField(2), new SudokuInitialField(6),
                                new SudokuInitialField(8), new SudokuInitialField(9),
                                new SudokuInitialField(5), new SudokuInitialField(1),
                                new SudokuInitialField(4) },
                { new SudokuInitialField(8), new SudokuInitialField(1),
                                new SudokuInitialField(4), new SudokuInitialField(2),
                                new SudokuInitialField(5), new SudokuInitialField(3),
                                new SudokuInitialField(7), new SudokuInitialField(6),
                                new SudokuInitialField(9) },
                { new SudokuInitialField(6), new SudokuInitialField(9),
                                new SudokuInitialField(5), new SudokuInitialField(4),
                                new SudokuInitialField(1), new SudokuInitialField(7),
                                new SudokuInitialField(3), new SudokuInitialField(8),
                                new SudokuInitialField(2) } };
        
        @Before
        public void setUp(){
                sudoku = new ClassicSudoku(sudokuToSolve);
        }

        @Test
        public void solverTest(){
                boolean same = true;
                for(int row = 0; row < sudoku.BOARD_SIZE; ++row){
                        for(int column = 0; column < sudoku.BOARD_SIZE; ++column){
                                if(!(sudoku.getSolvedFieldAt(row, column).getValue() == solvedSudoku[row][column].getValue())){
                                        same = false;
                                }
                        }
                }                
                Assert.assertTrue(same);
        }

        @Test
        public void backtrackingTest(){
                new SudokuSolverBacktracking(sudoku).solve();
                boolean same = true;
                for(int row = 0; row < sudoku.BOARD_SIZE; ++row){
                        for(int column = 0; column < sudoku.BOARD_SIZE; ++column){
                                if(!(sudoku.getFieldAt(row, column).getValue() == solvedSudoku[row][column].getValue())){
                                        same = false;
                                }
                        }
                }                
                Assert.assertTrue(same);
        }
}
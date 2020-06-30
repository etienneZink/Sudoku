package com.github.etienneZink.model.sudoku.framework.boardTests;

import com.github.etienneZink.model.sudoku.framework.candidates.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuInitialField;

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
                                if(!isSame(row, column)){
                                        same = false;
                                }
                        }
                }                
                Assert.assertTrue(same);
        }

        public boolean isSame(int row, int column){
                return sudoku.getSolvedFieldAt(row, column).getValue() == solvedSudoku[row][column].getValue();
        }
}
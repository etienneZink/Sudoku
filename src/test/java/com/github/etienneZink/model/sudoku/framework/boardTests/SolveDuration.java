package com.github.etienneZink.model.sudoku.framework.boardTests;

import java.time.Duration;
import java.time.Instant;

import com.github.etienneZink.model.sudoku.framework.candidates.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuInitialField;
import com.github.etienneZink.model.sudoku.framework.candidates.solver.SudokuSolver;
import com.github.etienneZink.model.sudoku.framework.candidates.solver.SudokuSolverBacktracking;

public class SolveDuration {

        public static SudokuField[][] sudokuToSolve =

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

        public static ClassicSudoku sudoku;
        static Instant startTime;
        static Instant endTime;
        static Duration duration;
        static SudokuSolver normalSolver;
        static SudokuSolverBacktracking backtrackingSolver;
        

        public static void main(String[] args) {

                // für genauere Ergebnisse sollte sudoku.print() auskommentiert werden.
                sudoku = new ClassicSudoku(sudokuToSolve);
                normalSolver = new SudokuSolver(sudoku);
                sudoku.print();
                startTime = Instant.now();
                normalSolver.solve();
                endTime = Instant.now();
                duration = Duration.between(startTime, endTime);
                System.out.println("Duration normalSolver: " + duration.toNanos() + "ns");
                sudoku.print();

                sudoku = new ClassicSudoku(sudokuToSolve);
                backtrackingSolver = new SudokuSolverBacktracking(sudoku);
                sudoku.print();
                startTime = Instant.now();
                backtrackingSolver.solve();
                endTime = Instant.now();
                duration = Duration.between(startTime, endTime);
                System.out.println("Duration normalSolver: " + duration.toNanos() + "ns");
                sudoku.print();
        }
}
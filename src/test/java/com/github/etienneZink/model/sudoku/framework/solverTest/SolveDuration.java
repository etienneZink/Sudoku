package com.github.etienneZink.model.sudoku.framework.solverTest;

import java.time.Duration;
import java.time.Instant;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;
import com.github.etienneZink.model.sudoku.framework.fields.Field;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.fields.SudokuInitialField;
import com.github.etienneZink.model.sudoku.framework.solver.SudokuSolver;
import com.github.etienneZink.model.sudoku.framework.solver.SudokuSolverBacktracking;

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

        static ClassicSudoku sudoku;
        static ClassicSudoku randomSudoku;
        static Field[][] randomSudokuToSolve;
        static Instant startTime;
        static Instant endTime;
        static Duration duration;
        static SudokuSolver normalSolver;
        static SudokuSolverBacktracking backtrackingSolver;
        

        public static void main(String[] args) {

                // für genauere Ergebnisse sollte sudoku.print() auskommentiert werden.
                // wieso ist er ohne sudoku.print() schneller? Zeit wird danach gemessen! RAM/CPU noch zu sehr ausgelastet danach?
                sudoku = new ClassicSudoku(sudokuToSolve);
                randomSudoku = new ClassicSudoku();
                randomSudokuToSolve = randomSudoku.getFields();

                normalSolver = new SudokuSolver(randomSudoku);
                randomSudoku.print();
                startTime = Instant.now();
                normalSolver.solve();
                endTime = Instant.now();
                duration = Duration.between(startTime, endTime);
                System.out.println("Duration candidateSolver: " + duration.toNanos() + "ns");
                randomSudoku.print();
                
                randomSudoku = new ClassicSudoku((SudokuField[][]) randomSudokuToSolve);
                backtrackingSolver = new SudokuSolverBacktracking(randomSudoku);
                randomSudoku.print();
                startTime = Instant.now();
                backtrackingSolver.solve();
                endTime = Instant.now();
                duration = Duration.between(startTime, endTime);
                System.out.println("Duration backtrackingSolver: " + duration.toNanos() + "ns");
                randomSudoku.print();
        }
}
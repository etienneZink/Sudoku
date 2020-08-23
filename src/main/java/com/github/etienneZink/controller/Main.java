package com.github.etienneZink.controller;

import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;

public class Main {
    public static void main(String[] args) {
        new Controller(new ClassicSudoku(9));
    }
}
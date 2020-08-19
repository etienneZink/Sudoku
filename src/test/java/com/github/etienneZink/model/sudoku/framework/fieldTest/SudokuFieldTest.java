package com.github.etienneZink.model.sudoku.framework.fieldTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.etienneZink.model.sudoku.framework.fields.SudokuField;

import org.junit.Before;
import org.junit.Test;

public class SudokuFieldTest {

    SudokuField fieldWithoutValue;
    SudokuField fieldValue;
    SudokuField fieldWrongValue;

    @Before
    public void setUp() {
        fieldWithoutValue = new SudokuField();
        fieldValue = new SudokuField(1);
        fieldWrongValue = new SudokuField(-1);
    }

    @Test
    public void removeTest(){
        for(int i = 1; i < 9; ++i){
            fieldWithoutValue.removeCandidate(i);
        }
       
        assertTrue(fieldWithoutValue.isSet());
        assertEquals(9, fieldWithoutValue.getValue());
    }

    @Test
    public void setTest(){
        assertTrue(fieldValue.isSet());
        assertTrue(!fieldWrongValue.isSet());
    }
}
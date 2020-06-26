package sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.github.etienneZink.model.sudokuFramework_Candidates.fields.SudokuField;

public class SudokuFieldTest {

    SudokuField fieldWithoutValue;
    SudokuField fieldValue;

    @Before
    public void setUp() {
        fieldWithoutValue = new SudokuField();
        fieldValue = new SudokuField(1);
    }

    @Test
    public void removeTest(){
        for(int i = 1; i < 9; ++i){
            fieldWithoutValue.removeCandidate(i);
        }
       
        assertTrue("tests if field was set",fieldWithoutValue.isSet());
        assertEquals("tests if field has value as expected",9, fieldWithoutValue.getValue());
    }

    @Test
    public void setTest(){
        assertTrue("tests if value was set", fieldValue.isSet());
    }
}
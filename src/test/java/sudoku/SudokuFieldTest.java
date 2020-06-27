package sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuField;
import com.github.etienneZink.model.sudoku.framework.candidates.fields.SudokuFieldFactory;

import org.junit.Before;
import org.junit.Test;

public class SudokuFieldTest {

    SudokuField fieldWithoutValue;
    SudokuField fieldValue;
    SudokuFieldFactory factory = new SudokuFieldFactory();

    @Before
    public void setUp() {
        fieldWithoutValue = (SudokuField) factory.emptyField();
        fieldValue = (SudokuField) factory.newField(1);
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
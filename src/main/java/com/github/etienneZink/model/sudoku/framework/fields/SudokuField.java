package com.github.etienneZink.model.sudoku.framework.fields;

import java.util.HashSet;
import java.util.Iterator;
import com.github.etienneZink.model.sudoku.framework.boards.ClassicSudoku;

/**
 * Class that represents the basic <code>Field</code> in a <code>ClassicSudoku</code> with a
 * <code>HashSet</code> of <code>candidates</code> which represents the values possible for this field.
 * 
 * @see Field
 * @see ClassicSudoku
 */
public class SudokuField extends Field {

    private static final long serialVersionUID = 6812321149646212285L;

    
    private HashSet<Integer> candidates;

    public SudokuField() {
        super();
        initialize();
    }

    public SudokuField(int value) {
        super(value);
        if (!isLegalValue(value)) {
            setIsSet(false);
            initialize();
        }
    }

    private void initialize() {
        candidates = new HashSet<Integer>(BOARD_SIZE);
        for (int i = 0; i < BOARD_SIZE; ++i) {
            candidates.add(i + 1);
        }
    }

    private boolean isLegalValue(int value) {
        return (0 < value && value < BOARD_SIZE + 1) ? true : false;
    }

    public void removeCandidate(int value) {
        candidates.remove(value);
        isToSet();
    }
    
    /**
     * Checks if the value of the <code>SudokuField</code> can be set.
     * @return <code>isSet</code>
     */
    public boolean isToSet() {
        if (candidates.size() == 1) {
            Iterator<Integer> it = candidates.iterator();
            if (it.hasNext()) {
                setValue(it.next());
                setIsSet(true);
            }
        }
        return isSet();
    }

    public void addCandidate(int value) {
        candidates.add(value);
    }

    // getter and setter

    public HashSet<Integer> getCandidates() {
        return candidates;
    }
}
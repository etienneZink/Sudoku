package model.sudokuFramework_Candidates.fields;

import java.util.ArrayList;
import java.util.List;

//TODO Dokumentation

public class SudokuField extends Field {

    /**
     *
     */
    private static final long serialVersionUID = 6812321149646212285L;

    private List<Integer> candidates;

    public SudokuField() {
        super();
        initialize();
    }

    public SudokuField(int value) {
        super(value);
    }

    private void initialize() {
        candidates = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) {
            candidates.add(i + 1);
        }
    }

    private void isToSet(){
        if (candidates.size() == 1) {
            value = candidates.get(0);
            isSet = true;
        }
    }

    public List<Integer> getCandidates() {
        return candidates;
    }

    public void removeCandidate(int value) {
        int index = candidates.indexOf(value);
        candidates.remove(index);
        isToSet();
    }

}
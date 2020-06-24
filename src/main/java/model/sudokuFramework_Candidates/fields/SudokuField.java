package model.sudokuFramework_Candidates.fields;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//TODO Dokumentation

public class SudokuField extends Field {

    /**
     *
     */
    private static final long serialVersionUID = 6812321149646212285L;

    private HashSet<Integer> candidates;

    public SudokuField() {
        super();
        initialize();
    }

    public SudokuField(int value) {
        //TODO more sexy -> anderer weg es auszudrücken
        if(isLegalValue(value)){
            setValue(value);
            setIsSet(true);
        } else {
            setIsSet(false);
            initialize();
        }
    }

    private void initialize() {
        candidates = new HashSet<Integer>(9);
        for (int i = 0; i < 9; ++i) {
            candidates.add(i + 1);
        }
    }

    private void isToSet(){
        if (candidates.size() == 1) {
            Iterator<Integer> it = candidates.iterator();
            if(it.hasNext()){
                setValue(it.next());
                setIsSet(true);
            }
            
        }
    }

    private boolean isLegalValue(int value) {
        return (0 < value && value < 10) ? true : false;
    }

    public HashSet<Integer> getCandidates() {
        return candidates;
    }

    public void removeCandidate(int value) {
        candidates.remove(value);
        isToSet();
    }

    public void addCandidate(int value){
        candidates.add(value);
    }
}
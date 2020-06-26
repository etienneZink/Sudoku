package com.github.etienneZink.model.sudoku.framework.candidates.fields;

import java.util.HashSet;
import java.util.Iterator;

//TODO Dokumentation

public class SudokuField extends Field{

    private static final long serialVersionUID = 6812321149646212285L;

    private HashSet<Integer> candidates;

    public SudokuField() {
        super();
        initializeCandidates();
    }

    public SudokuField(int value) {
        super(value);
        if(!isLegalValue(value)){
            setIsSet(false);
            initializeCandidates();
        }
    }

    private void initializeCandidates() {
        candidates = new HashSet<Integer>(9);
        for (int i = 0; i < 9; ++i) {
            candidates.add(i + 1);
        }
    }

    public void isToSet(){
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
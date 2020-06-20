package model.sudokuWithCandidatesQuickAndDirty.board;

import java.util.ArrayList;
import java.util.List;

import model.sudokuWithCandidatesQuickAndDirty.exceptions.WrongValueException;

//TODO Dokumentation

public class SudokuField extends Field{

    /**
     *
     */
    private static final long serialVersionUID = 6812321149646212285L;

    private List<Integer> candidates;

    public SudokuField() {
        super();
        initialize();
    }

    public SudokuField(int value){
        super(value);
    }

    private void initialize(){
        candidates = new ArrayList<Integer>();
        for(int i = 0; i < 9; ++i){
            candidates.add(i + 1);
        }
    }

    public List<Integer> getCandidates(){
        return candidates;
    }

    public void removeCandidate(int value) throws WrongValueException{
        try {
            candidates.remove(value);
            if(candidates.size() == 1){
                value = candidates.get(0);
                isSet = true;
            }
        } catch (Exception e) {
            throw new WrongValueException();
        }
        
    }
    
}
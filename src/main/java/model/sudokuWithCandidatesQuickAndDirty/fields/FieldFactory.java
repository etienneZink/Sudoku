package model.sudokuWithCandidatesQuickAndDirty.fields;

import model.sudokuWithCandidatesQuickAndDirty.interfaces.FieldFactoryInterface;
import model.sudokuWithCandidatesQuickAndDirty.interfaces.FieldTypes;

// TODO Dokumentation Singlton 

public class FieldFactory implements FieldFactoryInterface {

    private static FieldFactory factory = new FieldFactory();

    public static FieldFactory get(){
        return factory;
    }

    @Override
    public Field getInstance(FieldTypes type, int value) {
        switch (type) {
            case SudokuField:
                if ((Integer)value == null || value < 1 || 9 < value) {
                    return new SudokuField();
                } else {
                    return new SudokuField(value);
                }
            default:
                return null;
        }
    } 
}
package model.sudokuWithCandidatesQuickAndDirty.interfaces;

import model.sudokuWithCandidatesQuickAndDirty.fields.Field;

public interface FieldFactoryInterface {
    public Field getInstance(FieldTypes type, int value);
}
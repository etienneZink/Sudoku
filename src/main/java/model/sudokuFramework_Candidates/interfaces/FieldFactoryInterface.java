package model.sudokuFramework_Candidates.interfaces;

import model.sudokuFramework_Candidates.fields.Field;

public interface FieldFactoryInterface {
    public Field getInstance(FieldTypes type, int value);
}
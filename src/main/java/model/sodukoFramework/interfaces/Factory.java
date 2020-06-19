package model.sodukoFramework.interfaces;

import model.sodukoFramework.classes.Cell;
import model.sodukoFramework.exceptions.WrongValueException;

public interface Factory {
    public Cell getInstance() throws WrongValueException;
    public Cell getInstance(int value) throws WrongValueException;
}
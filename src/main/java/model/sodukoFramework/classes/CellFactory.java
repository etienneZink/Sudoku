package model.sodukoFramework.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import model.sodukoFramework.exceptions.WrongValueException;
import model.sodukoFramework.interfaces.Factory;

/**
 * Singelton factory which stores all different <code>Cell</code> objects in a <code>HashMap</code> and returns these instances 
 * instead of creating new ones, if <code>getInstance()</code> is invoked. Use this class instead of creating new <code>Cell</code> objects.
 * 
 * @author Etienne Zink
 * @version 1.0
 */
public class CellFactory implements Factory{

    private HashMap<Integer, Cell> cellTypes;
    private static CellFactory factory = new CellFactory();

    // constructor

    private CellFactory(){
        cellTypes = new HashMap<Integer,Cell>();
        setCellTypes();
    }

    // static methods

    public static CellFactory getFactory(){
        return factory;
    }

    // non-static methods
    @Override
    public Cell getInstance(int value) throws WrongValueException{
        if (cellTypes.get(value) == null){
            throw new WrongValueException();
        }
        return cellTypes.get(value);
    }

    @Override
    public Cell getInstance() throws WrongValueException{
        return getInstance(-1);
    }

    /**
     * Default implementation of <code>setCellTypes()</code>. 
     * Creates 9 <code>Cell</code> objects from 1 to 9 and a <code>Cell</code> object which value isn't set, with the <code>key = -1</code>.
     * They are stored in <code>cellTypes</code>. 
     */
    public void setCellTypes(){
        setEmptyCell();
        for(int i = 1; i < 10; ++i){
            cellTypes.put(i, new Cell(i));
        }
    }

    // getter and setter

    public HashMap<Integer, Cell> getCellTypes(){
        return cellTypes;
    }

    /**
     * Creates <code>Cell</code> objects for all values in the <code>HashSet</code> valueSet and a 
     * type <code>Cell</code> object which value isn't set, with the <code>key = -1</code>. They are stored in <code>cellTypes</code>.
     * 
     * @param valueSet must be positiv 
     */
    public void setCellTypes(HashSet<Integer> valueSet){
        setEmptyCell();                     
        Integer value;
        Iterator<Integer> setIterator = valueSet.iterator();
        while(setIterator.hasNext()){
            value = setIterator.next();
            cellTypes.put(value, new Cell(value));
        }
    }

    private void setEmptyCell(){
        cellTypes.put(-1, new Cell());
    }
}
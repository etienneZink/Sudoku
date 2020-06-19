package model.sodukoFramework.classes;

import java.io.Serializable;

import model.sodukoFramework.exceptions.ValueNotSetException;

/**
 * Immutable and serializable class for inner structure of <code>Sudoku</code>.
 * 
 * @author Etienne Zink
 * @version 1.0
 */
public class Cell implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2736891441965617088L;

    private int value;
    final private boolean valueIsSet;

    // constructors

    /**
     * Initialize a new <code>Cell</code> with <code>valueIsSet = false</code>.
     */

    protected Cell() {
        valueIsSet = false;
    }

    protected Cell(final int value) {

        valueIsSet = true;
        this.value = value;
    }

    // static methods

    // non-static mathods

    /**
     * The same method like <code>equals(Object obj)</code> because if they have the same value, then they are the same object aswell.
     * 
     * @param c
     * @return 
     */

    public boolean equals(Cell c){
        return this.equals(c);
    }

    // getter

    /**
     * 
     * @return <code>value</code>  
     * @throws ValueNotSetException If <code>valueIsSet</code> is <code>false</code>
     */

    public int getValue() throws ValueNotSetException {
        if (!valueIsSet) {
            throw new ValueNotSetException();
        }
        return value;

    }

    public boolean getIsSet() {
        return valueIsSet;
    }

}
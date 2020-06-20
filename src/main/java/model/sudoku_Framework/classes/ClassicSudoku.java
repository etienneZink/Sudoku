package model.sudoku_Framework.classes;

/**
 * Serializable class to represent a classic sudoku field with immutable
 * <code>Cell</code> for inner structrue which is accessed threw
 * <code>CellFactory</code>.
 * 
 * @author Etienne Zink
 * @version 1.0
 * @see AbstractSudoku
 */
public class ClassicSudoku extends AbstractSudoku {

    /**
     *
     */
    private static final long serialVersionUID = -2514791753861127039L;



    // constructors

    public ClassicSudoku(Cell[][] inputArray) {
        super(inputArray);
    }

    public ClassicSudoku(int[][] inputArray) {
        super(inputArray);
    }

    public ClassicSudoku(){
        super();
    }

    // static mathods

    // non-static methods

    @Override
    public void print() {
        for(int row = 0; row < getSudokuFieldSize(); ++row){
            for(int column = 0; column < getSudokuFieldSize(); ++column){
                try {
                    System.out.print(getCellAt(row, column).getValue() + "     ");
                } catch (Exception e) {
                    System.out.print("" + "     ");
                }
            }
            System.out.println();
        }

    }

    // getter and setter



}
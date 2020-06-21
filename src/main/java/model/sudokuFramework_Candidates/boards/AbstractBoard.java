package model.sudokuFramework_Candidates.boards;

import model.sudokuFramework_Candidates.fields.FieldFactory;

//TODO Dokumentation

public abstract class AbstractBoard {

    public final int BOARD_SIZE = 9;

    /**
     * Needs to be checked before working with a board.
     */
    protected boolean successfullBuild = false;
    protected boolean solved = false;
    protected FieldFactory factory = FieldFactory.get();

    protected boolean indexInBoard(int value) {
        return (0 <= value && value < BOARD_SIZE) ? true : false;
    }

    protected boolean isLegalValue(int value) {
        return (0 < value && value < 10) ? true : false;
    }

    public boolean isBuild() {
        return successfullBuild;
    }

    public boolean isSolved() {
        return solved;
    }

    public void solved() {
        solved = true;
    }
}
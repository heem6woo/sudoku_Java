package org.example.controller;

import org.example.Main;
import org.example.view.Container;
import org.example.model.Cell;
import org.example.view.Container.Over;

public class Controller {
    Container board;


    public Controller(Container board) {
        this.board = board;

    }

    public void setValue(int row, int col, int val) throws Container.Over {
        int index = (row * 9) + col;

        if (row < 0 || row >= Main.GRID ||col < 0 || col >= Main.GRID || !board.isValid(index, val)) {
            throw new IndexOutOfBoundsException();
        }

        Cell target = board.getCell(index);

        target.setValue(val);
        board.iCompletedCells();


    }

    public void setBlank(int row, int col) {
        int index = (row * 9)  + col;

        if (row < 0 || row >= Main.GRID ||col < 0 || col >= Main.GRID) {
            throw new IndexOutOfBoundsException();
        }

        board.getCell(index).setValue(0);

        board.dCompletedCells();

    }

    public void printBoard() {

        board.printContainer();
    }

    public void printCellRow(int row, int col) {
        board.printConstraint((row * 9) + col, Main.CONSTRAINTS.ROW);
    }
    public void printCellBox(int row, int col) {
        board.printConstraint((row * 9) + col, Main.CONSTRAINTS.BOX);
    }
    public void printCellCol(int row, int col) {
        board.printConstraint((row * 9) + col, Main.CONSTRAINTS.COL);
    }


}

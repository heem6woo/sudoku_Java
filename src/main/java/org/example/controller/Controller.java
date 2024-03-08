package org.example.controller;

import org.example.Main;
import org.example.view.Container;
import org.example.model.Cell;

public class Controller {
    Container board;


    public Controller(Container board) {
        this.board = board;

    }

    public void setValue(int row, int col, int val)  {
        int index = (row * 9) + col;

        if (row < 0 || row >= Main.GRID ||col < 0 || col >= Main.GRID || board.isValid(index, val)) {
            throw new IndexOutOfBoundsException();
        }

        Cell target = board.getCell(index);

        target.setValue(val);

    }

    public void printBoard() {
        board.printContainer();
    }


}

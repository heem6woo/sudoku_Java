package org.example.model;
import org.example.Position;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    Position position;

    int value;

    List<Cell> row, col, box;


    public Cell(int x, int y, int val) {

        position = new Position(x, y);

        value = val;

    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Cell){
            int toCompare = ((Cell) o).value;
            return value == toCompare;
        }
        return false;
    }

    public void setValue(int val) {
        value = val;
    }

    public Position getPosition() {

        return position;
    }

    public int getValue() {

        return value;
    }

    public void setRow(List<Cell> row) {
        this.row = row;
    }

    public void setCol(List<Cell> col) {
        this.col = col;
    }

    public void setBox(List<Cell> box) { this.box = box;}

    public List<Cell> getRow() {
        return this.row;
    }

    public List<Cell> getCol() {
        return this.col;
    }

    public List<Cell> getBox() {
        return this.box;
    }

    public boolean isValid(int value) {
        Cell temp = new Cell(-1,-1, value);
        if (!(value >= 1 && value <= 9) ||
                this.row.contains(temp) ||
                this.col.contains(temp) ||
                this.box.contains(temp))
        {
            return false;
        }
        return true;
    }

    /**
     * Used for testing equals override method
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Cell> cells = new ArrayList<>();
        Cell c1 = new Cell(0,0,2);
        Cell c2 = new Cell(1,1, 3);
        Cell temp = new Cell(-1,-1, 1);

        cells.add(c1);
        cells.add(c2);

        System.out.println(cells.contains(temp));
    }
}

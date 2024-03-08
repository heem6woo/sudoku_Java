package org.example.model;
import org.example.Position;
import java.util.List;

public class Cell {
    Position position;

    int value;

    List<Cell> row;
    List<Cell> col;
    List<Cell> box;


    public Cell(int x, int y, int val) {

        position = new Position(x, y);

        value = val;

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

    public void setBox(List<Cell> Box) {
        this.box = box;
    }

    public List<Cell> getRow() {
        return row;
    }

    public List<Cell> getCol() {
        return this.col;
    }

    public List<Cell> getBox() {
        return this.box;
    }
}

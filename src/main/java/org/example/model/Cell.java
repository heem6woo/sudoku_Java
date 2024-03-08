package org.example.model;
import org.example.Position;

public class Cell {
    Position position;

    int value;

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
}

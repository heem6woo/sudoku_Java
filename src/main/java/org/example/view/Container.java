package org.example.view;

import org.example.Main;
import org.example.Position;
import org.example.model.Cell;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;


public class Container {
    private ArrayList<Cell> cells;

    public Container() {
        // y:0 x: 0 - 8 = 0 - 8
        // y:1 x: 0 - 8 = 9 - 17
        cells = new ArrayList<Cell>();

        for(int i = 0; i < Main.GRID; ++i) {

            for(int j = 0; j < Main.GRID; ++j) {

                cells.add(new Cell(i,j, 0));
            }

        }
        // Set Row
        for(int i = 0; i < Main.GRID; ++i) {
            List<Cell> row = cells.subList(i*9, i*9+ 9);

            for(int j = 0; j < Main.GRID; ++j) {

                Cell cell = cells.get((i * 9) + j);
                cell.setRow(row);
            }
        }

        // Set Col
        for(int i = 0; i < Main.GRID; ++i) {
            List<Cell> col = new ArrayList<>();

            for(int j = 0; j < Main.GRID; ++j) {

                Cell cell = cells.get((j * 9) + i);

                col.add(cell);
            }

            for(int j = 0; j < Main.GRID; ++j) {

                Cell cell = cells.get((j * 9) + i);

                cell.setCol(col);
            }

        }

        List<Cell> box1 = new ArrayList<>();
        List<Cell> box2 = new ArrayList<>();
        List<Cell> box3 = new ArrayList<>();

        // Set Box
        for(int i = 0; i < Main.GRID; ++i) {
            if (i != 0 && (i + 1) % 3 == 0) {

                System.out.println(box1);
                System.out.println(box2);
                System.out.println(box3);
                for(int j = 0; j < Main.GRID; ++j) {

                    Cell cell = cells.get((i * 9) + j);

                    if(j >= 0 && j < 3) {
                        cell.setBox(new ArrayList<Cell>(box1));
                    } else if(j >= 3 && j < 6) {
                        cell.setBox(new ArrayList<Cell>(box2));
                    } else if (j >= 6 && j < 9) {
                        cell.setBox(new ArrayList<Cell>(box3));
                    }

                }
                box1 = new ArrayList<>();
                box2 = new ArrayList<>();
                box3 = new ArrayList<>();
            }
            for(int j = 0; j < Main.GRID; ++j) {

                Cell cell = cells.get((i * 9) + j);
                if(j >= 0 && j < 3) {
                    box1.add(cell);
                } else if(j >= 3 && j < 6) {
                    box2.add(cell);
                } else if (j >= 6 && j < 9) {
                    box3.add(cell);
                }

            }

        }

        /*
        for (int i = 0; i < Main.GRID / 3; ++i) {

            List<Cell> box = new ArrayList<>();

            for (int j = 0; i < Main.GRID; ++i) {


            }
        }
         */




    }

    public ArrayList<Cell> getContainer() {
        return cells;
    }

    public Cell getCell(int index) {
        return cells.get(index);
    }

    public void readInput(String text) throws FileNotFoundException {

        System.out.println(text);
        File input = new File(text);

        Scanner textIn = new Scanner(input);

        int index = 0;

        while (textIn.hasNext()) {

            String line = textIn.nextLine();

            if (line.isEmpty()) continue;
            for(int in = 0; in < line.length(); ++in) {

                char curr = line.charAt(in);

                if ( '1' <= curr && curr <= '9') {
                    cells.get(index).setValue((int) (curr - '0'));
                    index += 1;
                } else if (curr == '-') {
                    cells.get(index).setValue(0);
                    index += 1;
                }

            }

        }

    }

    public void printConstraint(int index, Main.CONSTRAINTS constraint) {
        Cell c = cells.get(index);
        int i = 0;
        List<Cell> target = (constraint == Main.CONSTRAINTS.ROW) ? c.getRow() :
                ((constraint == Main.CONSTRAINTS.COL) ? c.getCol() : c.getBox());
        if(target == null) System.err.println(constraint + " is null!");
        for(Cell t: target) {
            if (i % 3 == 0) System.out.print(' ');
            if (t.getValue() == 0) {
                System.out.print('_');
            } else {
                System.out.print(t.getValue());
            }
            ++i;
        }
        System.out.println();

    }


    public void printContainer() {

        for(int i = 0; i < Main.GRID; ++i) {

            // print a row
            for(int j =0; j < Main.GRID; ++j) {

                if (j % 3 == 0) {
                    System.out.print(' ');
                }

                int value = cells.get((i * 9) + j).getValue();
                if (value == 0) {
                    System.out.print('_');
                } else {
                    System.out.print(value);
                }

            }

            // print new line
            System.out.println();

        }
    }

    public boolean isValid(int index, int val) {
        return cells.get(index).isValid(val);
    }

}

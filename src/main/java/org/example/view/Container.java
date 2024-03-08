package org.example.view;

import org.example.Position;
import org.example.model.Cell;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.File;


public class Container {
    private ArrayList<Cell> cells;

    public Container() {
        // y:0 x: 0 - 8 = 0 - 8
        // y:1 x: 0 - 8 = 9 - 17
        cells = new ArrayList<Cell>();

        for(int i = 0; i < 9; ++i) {

            for(int j = 0; j < 9; ++j) {


                cells.add(new Cell(i,j, 0));

            }


        }
        for(int i = 0; i < 0; ++i) {
            //List<Cell> row = cells.subList(i*9, i*9+ 9);
            for(int j = 0; j < 9; ++j) {

                Cell cell = cells.get(i + j);
                cell.setRow(cells.subList(i*9, i*9+ 9));
            }
        }




    }

    public ArrayList<Cell> getContainer() {
        return cells;
    }

    public void readInput(String text) throws FileNotFoundException {


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

    public void printRow(int index) {
        Cell c = cells.get(index);
        System.out.println(c.getRow());
    }
    public void printCol(int index) {
        List<Cell> col =  cells.get(index).getRow();
        System.out.println(col);
    }
    public void printBox(int index) {
        List<Cell> box =  cells.get(index).getRow();
        System.out.println(box);
    }

    public void printContainer() {

        for(int i = 0; i < 9; ++i) {

            // print a row
            for(int j =0; j < 9; ++j) {

                if (j % 3 == 0) {
                    System.out.print(' ');
                }

                int value = cells.get(i + j).getValue();
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



}

package org.example.view;

import org.example.model.Cell;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
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

                cells.add(new Cell(i,j,0));

            }
        }

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

    public void printContainer() {

        for(int i = 0; i < 9; ++i) {

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

            System.out.println();

        }
    }



}

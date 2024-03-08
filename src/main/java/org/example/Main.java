package org.example;

import org.example.view.Container;
import org.example.controller.Controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int GRID = 9;

    public static enum CONSTRAINTS {
        ROW,
        COL,
        BOX
    }

    public static String BARRIER = "---------------------------";
    public static void main(String[] args){

        Container board = new Container();

        Scanner cmd = new Scanner(System.in);

        System.out.println("Please select the sudoku board:");
        System.out.println("Samples are samples/test1.in, samples/test2.in, samples/test3.in");

        String sudoku = cmd.next();



        while (true) {
            try {
                board.readInput(sudoku);

                board.printContainer();

                System.out.println(BARRIER);

                Controller controller = new Controller(board);

                while(cmd.hasNext()) {

                    String ctr = cmd.next();

                    switch (ctr) {
                        case("exit"):
                            break;
                        case("help"):
                            System.out.println("row: 0 - 8, col: 0 - 8, value: 1 - 9");
                            System.out.println("exit - to exit the game");
                            System.out.println("set i j v - to set v(value) on i(row), j(col)");
                            System.out.println("print - to print the sudoku board");
                            break;
                        case("set"):
                            int i = cmd.nextInt();
                            int j = cmd.nextInt();
                            int v = cmd.nextInt();
                            controller.setValue(i, j, v);
                            break;
                        case("print"):
                            controller.printBoard();
                    }


                }


            } catch (FileNotFoundException ex) {
                System.err.println("File is not found!");
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.err.println("Invalid value!");
            }
        }



    }
}
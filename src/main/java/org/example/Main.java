package org.example;

import org.example.view.Container;
import org.example.controller.Controller;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static int GRID = 9;

    public static enum CONSTRAINTS {
        ROW,
        COL,
        BOX
    }

    public static String BARRIER = "---------------------------";

    public static String USAGE = "row: 0 - 8, col: 0 - 8, value: 1 - 9\n" +
            "exit - to exit the game\n" +
            "set i j v - to set v(value) on i(row), j(col) cell\n" +
            "print, p - to print the sudoku board\n" +
            "print_contraint, pc i j- to print the costraints(row, col, and box) for i,j cell";



    public static void main(String[] args) {

        Container board = new Container();

        Scanner cmd = new Scanner(System.in);


        System.out.println("Please select the sudoku board:");
        System.out.println("To choose the default sudoku, please type 'default'.");
        System.out.println("Samples are samples/test1.in, samples/test2.in, samples/test3.in");
        System.out.println("To exit the program, please type the exit or ctrl + D(EOF).");

        String ctr = cmd.next();

        try {
            switch (ctr) {

                case ("exit"):
                    break;

                case ("default"):
                    ctr = "samples/test1.in";

                default:
                    board.readInput(ctr);

                    board.printContainer();

                    System.out.println(BARRIER);

            }


        } catch (FileNotFoundException ex) {
            System.err.println("File is not found!");
            return;

        }


        Controller controller = new Controller(board);
        int i;
        int j;

        while (cmd.hasNext()) {

            ctr = cmd.next();
            try {
                switch (ctr) {
                    case ("exit"):
                        break;
                    case ("help"):
                        System.out.println(USAGE);
                        break;
                    case ("set"):
                        i = cmd.nextInt();
                        j = cmd.nextInt();
                        int v = cmd.nextInt();
                        controller.setValue(i, j, v);
                        break;
                    case ("print"), ("p"):
                        controller.printBoard();
                        break;
                    case ("print_constraint"), ("pc"):
                        i = cmd.nextInt();
                        j = cmd.nextInt();
                        System.out.println("Row:");
                        controller.printCellRow(i, j);
                        System.out.println("Col:");
                        controller.printCellCol(i, j);
                        System.out.println("Box:");
                        controller.printCellBox(i, j);
                        break;
                    default:
                        throw new Exception();
                }
            } catch (IndexOutOfBoundsException ex) {
                System.err.println("Invalid value!");
            } catch (Container.Over ex) {
                System.out.println(ex.getMsg());
                break;
            } catch (Exception ex) {
                System.out.println(USAGE);
            }

        }

    } // main
}
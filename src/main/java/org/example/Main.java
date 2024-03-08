package org.example;

import org.example.view.Container;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){

        Container board = new Container();
        try {
            board.readInput("samples/test1.in");

        } catch (FileNotFoundException ex) {
            System.err.println("File is not found!");
        }

        board.printContainer();

    }
}
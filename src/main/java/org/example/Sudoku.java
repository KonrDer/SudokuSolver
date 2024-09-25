package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*die nötigen Imports für die GUI/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Random;

import javax.swing.*;

/**
@author Konrad Hennig
@author U-Jin Hong
 */


public class Sudoku {
    private int[][] gameBoard;
    private static final int sizeX = 9;
    private static final int sizeY = 9;

    //Konstruktor
    public Sudoku(){
        this.gameBoard = new int[9][9];
        initialize();

    }

    //getter
    public int[][] getGameBoard(){
        return this.gameBoard;
    }

    public int getSizeX(){
        return sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }

    //Objektmethoden
    public boolean isValidRow(String row) {
        String[] digits = row.split(" ");
        List<Character> valids = List.of('0','1','2','3','4','5','6','7','8','9');

        // nur Reihen der Länge 9
        if (digits.length != 9)
            return false;

        boolean validDigitLength = Arrays.stream(digits).allMatch(i -> i.length() == 1);
        boolean validDigits = Arrays.stream(digits).allMatch(i -> valids.contains(i.charAt(0)));

        String[] digitsWithoutZero = Arrays.stream(digits)
                .filter(i -> !i.equals("0"))
                .toArray(String[]::new);
        String[] distinctDigitsWithoutZero = Arrays.stream(digitsWithoutZero)
                .distinct()
                .toArray(String[]::new);

        /**
         nur Reihen mit gültigen single-digits und keine Dopplungen(Ausnahme: 0)
         */
        return (validDigitLength && validDigits
                && (digitsWithoutZero.length - distinctDigitsWithoutZero.length) == 0);
    }

    public boolean areValidColumns(String[] rows) {
        for(int i = 0; i < rows.length;i++){
            rows[i] = rows[i].replace(" ", "");
        }

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            //Spalten werden erstellt
            String column = Arrays.stream(rows)
                    .map(j -> j.charAt(finalI) + "")
                    .collect(Collectors.joining(" "));
            if (!isValidRow(column))
                return false;
        }
        return true;
    }

    /**Methode public lassen, damit getestet werden kann*/
    public void fillGameBoard(String[] rows){
        for(int i = 0; i < rows.length;i++){
            for(int j = 0; j < rows[i].length(); j++){
                gameBoard[i][j] = rows[i].charAt(j) - '0';
            }
        }
    }

    public void fillGameBoardFromConsole() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die Sudoku Zeilen wie folgt ein: 1 0 3 0 0 0 7 2 9 " +
                "und drücken Sie Enter nach jeder Zeile.");


        String[] rows = new String[9];

        do {
            int rowCounter = 0;

            while (rowCounter < 9) {
                String s = in.readLine();
                if (isValidRow(s)) {
                    rows[rowCounter++] = s;
                }
                else
                    System.out.println("Keine gültige Zeile!");
            }
        }
        while(!areValidColumns(rows));

        fillGameBoard(rows);

    }


    private void drawSudoku(){
    }

    private void initialize(){

    }


    public void writeGameBoard(){
        StringBuilder horizontalBuilder = new StringBuilder();
        appendNTimes(horizontalBuilder, '+', 12);
        System.out.println(horizontalBuilder);
    }

    private static StringBuilder appendNTimes(StringBuilder builder, char c, int n){
        for(int i = 0; i < n; i++){
            builder.append(c);
        }
        return builder;
    }

    public static void main(String[] args) {
        Sudoku testSudoku = new Sudoku();
    }

}

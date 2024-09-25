package org.example;

import org.example.Sudoku;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try{
//            s.fillGameBoard();
//        }
//        catch(IOException e){
//        }


        String[] rows = {"123456789", "234567891", "345678912", "456789123", "567891234",
                "678912345", "789123456", "891234567", "912345678"};


        Sudoku s = new Sudoku();
//        try{s.fillGameBoardFromConsole();}
//        catch(IOException e) {
//            System.out.println("Konrad is ploeet");
//        }
        s.fillGameBoard(rows);
        Arrays.stream(s.getGameBoard()).forEach(i -> System.out.println(Arrays.toString(i)));
        s.writeGameBoard();

        //TODO delete or move somewhere else when understood
        //Demo Stringbuilder:
//        List<String> trees = Arrays.asList("oak", "pine", "fir", "ash", "birch", "elm", "yew");
//        System.out.println(listToString(trees));
        System.out.println(gameBoardToString(s));
    }

    //part of Demo Stringbuilder:
    private static String listToString(List<String> list){
        StringBuilder sb = new StringBuilder();

        for(String el : list){
            sb.append(el).append(" ");
        }
        return sb.toString();
    }

    private static String gameBoardToString(Sudoku s){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 9;i++){
            appendNTimes(builder, "────", 9).append("\n");
            for(int j = 0; j < 9; j++){
                builder.append("| ").append(s.getGameBoard()[i][j]).append(" ");
                if(j == 8){
                    builder.append("|");
                }
            }
            builder.append('\n');

            if(i == 8){
                appendNTimes(builder, "────", 9);
            }
        }
        return builder.toString();
    }


    private static StringBuilder appendNTimes(StringBuilder builder, String s, int n){
        for(int i = 0; i < n; i++){
            builder.append(s);
        }
        return builder;
    }
}
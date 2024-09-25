package org.example;

import org.example.Sudoku;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasicTests {
    Sudoku testSudoku;



    @Test
    void testCorrectInitializationWithoutZeros(){
        testSudoku = new Sudoku();
        String[] testRows = {"123456789", "234567891", "345678912", "456789123", "567891234", "678912345",
                "789123456", "891234567", "912345678"};
        testSudoku.fillGameBoard(testRows);

        for(int i = 0; i < testRows.length; i++){
            for(int j = 0; j < testRows[i].length();j++){
                Assertions.assertEquals(testSudoku.getGameBoard()[i][j] + '0', testRows[i].charAt(j));

            }
        }
    }



    /*public static void main(String[] args){
        System.out.println("This test class is to be continued.");
    }*/
}

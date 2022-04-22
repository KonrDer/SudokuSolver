import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
@author Konrad Henninger
@author U-Jin Hong
 */

public class Sudoku {
    private int[][] gameBoard;

    //Konstruktor
    public Sudoku(){
        this.gameBoard = new int[9][9];
    }

    //getter
    public int[][] getGameBoard(){
        return this.gameBoard;
    }


    public void fillGameBoard() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die Sudoku Zeilen wie folgt ein: 1 0 3 0 0 0 7 2 9 " +
                "und drücken Sie Enter nach jeder Zeile.\nWenn Sie fertig sind, drücken Sie " +
                "nochmal Enter.");

        boolean isCorrectSudoku = false;

        while(!isCorrectSudoku){
            int rowCounter = 0;
            String[] rowContent = new String[9];
            int i = 0;

            while(rowCounter < 9){
                if(!in.readLine().isEmpty()){
                    rowContent[i++] = in.readLine();
                }
                else{
                    break;
                }
            }

        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        return null;
    }

}

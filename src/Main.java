import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Sudoku s = new Sudoku();
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
    }
}

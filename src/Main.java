import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        try{
            s.fillGameBoard();
        }
        catch(IOException e){
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
/*
@author Konrad Henninger
@author U-Jin Hong
 */


/*
das hier ist der cringe ujin branch hihihihihihihihi loserrrrrrrrrr
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

    public boolean isValidRow(String row) {
        String[] digits = row.split(" ");
        List<Character> valids = List.of('0','1','2','3','4','5','6','7','8','9');
        if (digits.length != 9)
            return false;

        boolean validLength = Arrays.stream(digits).allMatch(i -> i.length() == 1);
        boolean validDigits = Arrays.stream(digits).allMatch(i -> valids.contains(i.charAt(0)));

        String[] digitsWithoutZero = Arrays.stream(digits)
                .filter(i -> !i.equals("0"))
                .toArray(String[]::new);
        String[] distinctDigitsWithoutZero = Arrays.stream(digitsWithoutZero)
                .distinct()
                .toArray(String[]::new);

        /*
        nur Reihen der Laenge 9, mit gueltigen single-digits und keine Dopplungen(Ausnahme: 0)
         */
        return (validLength && validDigits
                && (digitsWithoutZero.length - distinctDigitsWithoutZero.length) == 0);
    }

    public boolean areValidColumns(String[] rows) {
        for(int i = 0; i < rows.length;i++){
            rows[i] = rows[i].replace(" ", "");
        }

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            String column = Arrays.stream(rows).map(j -> j.charAt(finalI) + "").collect(Collectors.joining(" "));
            if (!isValidRow(column))
                return false;
        }
        return true;
    }
     public boolean isValidSudoku(String[] rows) {
            return false;
        }
        //Konrad ist gayyyyyy


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
        int rowCounter = 0;

        do {
            while (rowCounter < 9) {
                String s = in.readLine();
                if (isValidRow(s)) {
                    rows[rowCounter++] = s;
                }
                else
                    System.out.println("Keine gueltige Zeile, du Hurensohn!");
            }
        }
        while(!areValidColumns(rows));

        fillGameBoard(rows);

    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        return null;
    }

}

import java.util.Scanner;

public class Main {

    private static final char CHAR_DEAD='.';
    private static final char CHAR_ALIVE='#';

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int steps = in.nextInt(); in.nextLine();

        GameOfLife board = new GameOfLife(rows,cols);

        for (int i=0; i<rows; i++) {
            String line = in.nextLine();
            parseLine(i, line, board);
        }

        board.evolve(steps);
        printState(board.getState());
    }

    private static void parseLine(int i, String line, GameOfLife board) {
        char[] lineChars = line.toCharArray();
        for (int c=0; c< lineChars.length; c++) {
            board.addCell(i,c,lineChars[c]==CHAR_ALIVE);
        }
    }

    private static void printState(boolean[][] board) {
        for (int i=0;i<board.length;i++) {
            for (int j = 0; j<board[i].length; j++) {
                if (board[i][j]) {
                    System.out.print(CHAR_ALIVE);
                } else {
                    System.out.print(CHAR_DEAD);
                }

            }
            System.out.println();
        }
    }
}
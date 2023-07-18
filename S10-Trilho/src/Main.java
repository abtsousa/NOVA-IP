import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        int cols = in.nextInt();
        int[][] field = new int[lines][cols];
        for (int i=0; i<lines; i++) {
            for (int j=0; j<cols; j++) {
                field[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        Path path = new Path(field);
        path.getPath();
    }
}
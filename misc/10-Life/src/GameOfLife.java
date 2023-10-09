public class GameOfLife {
    private boolean[][] state; // L+2 rows, C+2 columns
    private int rows; // rows (L)
    private int cols; // cols (C)

    // pre: rows > 0 && cols > 0
    // Create the boolean matrix
    // with rows+2 rows and cols+2 columns.
    public GameOfLife(int rows, int cols) {
        state = new boolean[rows+2][cols+2];
        this.rows = rows;
        this.cols = cols;
    }

    // pre: 0 <= row && row < rows && 0 <= col && col < cols
    // Assign the value of isAlive to the cell
    // in row row+1 and column col+1.
    public void addCell(int row, int col, boolean isAlive) {
        state[row+1][col+1] = isAlive;
    }

    // returns the game state (the matrix)
    // Create a new matrix of booleans, with L rows and C columns,
    // copy the cells of the “real board”, and
    // return the matrix.
    public boolean[][] getState() {
        boolean[][] board = new boolean[rows][cols];
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=cols; j++) {
                board[i-1][j-1]=state[i][j];
            }
        }
        return board;
    }


    // execute ticks state transitions
    // pre: ticks >= 0
    public void evolve(int ticks) {
        for (int i=0; i<ticks; i++) {
            evolve();
        }
    }

    public void evolve() {
        boolean[][] nextState = new boolean[rows+2][cols+2];
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=cols; j++) {
                int neighbors = countNeighbors(i,j);
                nextState[i][j]=(neighbors==3)||(neighbors==2 && state[i][j]);
            }
        }
        state = nextState;
    }

    //pre: row>=1 && col >=1 && col < cols && row < rows
    private int countNeighbors(int row, int col) {
        int neighbors = 0;
        for (int j=-1; j<=1; j++) {
            if (state[row-1][col+j]) neighbors++;
            if (state[row+1][col+j]) neighbors++;
        }
        if (state[row][col-1]) neighbors++;
        if (state[row][col+1]) neighbors++;
        return neighbors;
    }
}

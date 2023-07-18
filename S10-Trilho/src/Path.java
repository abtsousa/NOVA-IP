public class Path {
    private int[][] field;
    private static final char CHAR_LEFT = 'E';
    private static final char CHAR_RIGHT = 'D';
    private static final char CHAR_UP = 'C';
    private static final char CHAR_DOWN = 'B';
    private static final int NULL = 0;

    public Path(int[][] field) {
        this.field = field;
    }

    public void getPath() {
        int i=0;
        int j=0;
        int steps=0;
        int ref=field[0][0];
        boolean pathEnd = false;
        while (!pathEnd) {
            steps++;
            ref = field[i][j];
            field[i][j]=NULL;
            if (pathExists(i-1,j,ref)) {i=i-1; System.out.print(CHAR_UP);}       //up
            else if (pathExists(i+1,j,ref)) {i=i+1; System.out.print(CHAR_DOWN);}  //down
            else if (pathExists(i,j-1,ref)) {j=j-1; System.out.print(CHAR_LEFT);}  //left
            else if (pathExists(i,j+1,ref)) {j=j+1; System.out.print(CHAR_RIGHT);}  //right
            else {pathEnd = true;}
        }
        System.out.println();
        System.out.println(ref*steps);
    }

    private boolean pathExists(int i, int j, int ref) {
        if (i>=0 && i<field.length && j>=0 && j<field[i].length) {
            return field[i][j]==ref;
        } else return false;
    }
}

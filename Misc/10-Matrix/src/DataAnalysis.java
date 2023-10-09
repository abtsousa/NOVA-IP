public class DataAnalysis {
    private int[][] data;
    private int rows, cols;

    //pre: isProperMatrix(data)
    public DataAnalysis(int[][] data) {
        this.data = data;
        rows = data.length;
        if (rows == 0) cols = 0;
        else cols = data[0].length;
    }

    private static boolean isProperMatrix(int[][] matrix) {
        int i = 0;
        while (i < matrix.length - 1
                && matrix[i].length == matrix[i+1].length) { //percorre as linhas
            i++;
        }
        return i == matrix.length-1;
    }

    public boolean isEmpty() {
        return rows == 0;
    }

    //pre !isEmpty()
    public int getMaximum() {
        int max = data[0][0];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (data[i][j]>max) {max = data[i][j];}
            }
        }
        return max;
    }

    public boolean contains(int elem) {
        boolean found = false;
        int i=0;
        while (i<rows && !found) {
            int j=0;
            while (j<cols && !found) {
                if (data[i][j]==elem) {found = true;}
                else {j++;}
            }
        }
        return found;
    }

/*
    public boolean contains(int elem) {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (data[i][j]==elem) {return true;}
            }
        }
        return false;
    }
*/

    //Conta elementos por ordem crescente
    public int countIncreasingRows() {
        int count = 0;
        for (int i=0; i<rows; i++) {
            int j=0;
            while (j<cols-1 && data[i][j]<data[i][j+1]) {j++;}
            if (j == cols-1) {count++;}
        }
        return count;
    }

    public int getColumnWithLargestTotal() {
        int max = Integer.MIN_VALUE; //max pode ser negativo
        int idMax=0;
        for (int j=0; j<cols; j++) {
            int sum=0;
            for (int i=0;i<rows; i++) {
                sum += data[i][j];
            }
            if (sum > max) {
                max = sum;
                idMax = j;
            }
        }
        return idMax;
    }

    public DataAnalysis transpose() {
        int[][] other = new int[cols][rows];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                other[j][i] = data[i][j];
            }
        }
        return new DataAnalysis(other);
    }

/*
    public boolean isMagicSquare() {
        if (rows != cols) {return false;}
        else if (rows==1 || rows==0) {return true;}
        else {
            int sum = sumDiag();
            int i=0; int j=0;
            while (sumRow(i)==sum && i<rows) {i++;}
            while (sumCol(j)==sum && j<cols) {j++;}
            return (i==rows && i==j);
        }
    }
*/

    public boolean isMagicSquare() {
        if (rows != cols) {return false;}
        else if (rows==1 || rows==0) {return true;}
        else {
            int sum = sumXY(0,0,1,1);
            int i=0; int j=0;
            while (i<rows && sumXY(i,0,0,1)==sum) {i++;}
            if (i<rows) return false;
            else {
                while (j<cols && sumXY(0,j,1,0)==sum) {j++;}
                if (j<cols) return false;
                else return (sum == sumXY(rows-1,0,-1,1));
            }
        }
    }

    private int sumXY(int i, int j, int deltaI, int deltaJ) {
        int sum = 0;
        while (isInside(i,j)) {
            sum += data[i][j];
            i += deltaI;
            j += deltaJ;
        }
        return sum;
    }

    private boolean isInside(int i, int j) {
        return i<rows && j<cols && i>=0 && j>=0;
    }

    //TESTE 2022

    // Cria um vetor com os mínimos das várias linhas da matriz data.
    private int[] getRowsMins() {
        int[] result = new int[rows];
        for (int i = 0; i < rows; i++) {
            int min = data[i][0];
            for (int j = 1; j < cols; j++) {
                if (data[i][j]<min) {
                    min = data[i][j];
                }
            }
            result[i]=min;
        }
        return result;
    }

    private int[] getColsMaxs() {
        int[] result = new int[cols];
        for (int j = 0; j < cols; j++) {
            int max = data[0][j];
            for (int i = 1; i < rows; i++) {
                if (data[i][j]>max) {
                    max = data[i][j];
                }
            }
            result[j]=max;
        }
        return result;
    }

    public int countMinMax() {
        int[] rowsMins = getRowsMins();
        int[] colsMaxs = getColsMaxs();
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j] == rowsMins[i] && data[i][j] == colsMaxs[j]) {
                    count++;
                }
            }
        }
        return count;
    }
/*
    private int sumDiag() {
        int sum=0;
        for (int i=0; i<rows; i++) {
            sum += data[i][i];
        }
        return sum;
    }

    private int sumRow(int i) {
        int sum=0;
        for (int j=0; j<cols; j++) {
            sum += data[i][j];
        }
        return sum;
    }

    private int sumCol(int j) {
        int sum=0;
        for (int i=0; i<rows; i++) {
            sum += data[i][j];
        }
        return sum;
    }
*/
}

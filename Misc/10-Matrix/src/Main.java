public class Main {
    public static void main(String[] args) {
        int[][] data = {{0,1,2,3},{4,5,6,7},{8,8,8,9},{0,0,0,0}};
        DataAnalysis analysis = new DataAnalysis(data);
        System.out.println(analysis.countMinMax());
    }
}
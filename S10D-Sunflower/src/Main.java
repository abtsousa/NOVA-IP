import java.util.Scanner;

public class Main {
    private static final String FIBB_TRUE = "OK";
    private static final String FIBB_FALSE = "FAKE";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int photos = in.nextInt();
        for (int i=0; i<photos; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            if (isFibb(n1,n2) || (n1==1 && n2==2) || (n1==2 && n2==1)) {System.out.println(FIBB_TRUE);}
            else {System.out.println(FIBB_FALSE);}
        }
    }

    public static int[] getFibbSeq(int min) {
        int n1 = 0;
        int n2 = 1;
        int[] result = new int[2];
        while (n1<min) {
            int n3 = n1+n2;
            n1 = n2;
            n2 = n3;
        }

        result[0] = n1;
        result[1] = n2;
        return result;
    }

    private static boolean isFibb(int a, int b) {
        int n1, n2;
        if (b < a) {
            n1 = b;
            n2 = a;
        } else {
            n1 = a;
            n2 = b;
        }

        int[] fibb = getFibbSeq(n1);
        return (fibb[0] == n1 && fibb[1] == n2);
    }
}
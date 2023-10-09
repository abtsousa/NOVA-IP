import java.util.Scanner;

public class Main {
    public static int jump;
    public static final int NUMEROS = 13;
    public static final int NAIPES = 4;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] naipes = in.next().toCharArray();
        in.nextLine();
        jump = in.nextInt();
        in.nextLine();
        cmdLoop(in, naipes);
    }

    private static void cmdLoop(Scanner in, char[] naipes) {
        int n, ci;
        char c;
        do {
            n = in.nextInt();
            if (n!=0) {
                c = in.next().charAt(0);
                ci = searchChar(naipes, c);
                System.out.printf("%d %C\n",numero(n), naipes[(ci-1+NAIPES) % NAIPES]);
            }
        } while (n!=0);
    }

    private static int numero(int n) {
        n = n-jump;
        if (n<=0) {return n+NUMEROS;}
        else {return n;}
    }

    private static int searchChar(char[] array, char c) {
        int i=0;
        while (array[i]!=c) {i++;}
        return i;
    }
}